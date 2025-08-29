## 📌 OAuth2 with Gmail API (Authorization Code Flow)

### 🔹 What is OAuth2?
- **OAuth2** is a secure authorization framework used by Google APIs and most modern services.  
- Instead of passing username/password, apps use **tokens**:  
  1. **Authorization Code** → temporary code after user login & consent  
  2. **Access Token** → short-lived token for API calls  
  3. **Refresh Token** → long-lived token to get new access tokens without asking user again  
- Benefits: users don’t share their password, tokens are revocable, and access is scoped (e.g., Gmail read-only or send mail).  

---

### 🔹 Configuration Steps (Google Cloud Console)
1. Go to [Google Cloud Console](https://console.cloud.google.com/).  
2. Create a **new project** (or select an existing one).  
3. Enable the **Gmail API** under *APIs & Services → Library*.  
4. Go to *APIs & Services → OAuth consent screen*:  
   - Set app name, support email, and scopes (e.g.,  
     - `https://www.googleapis.com/auth/gmail.readonly` (read mails)  
     - `https://www.googleapis.com/auth/gmail.send` (send mails))  
5. Go to *APIs & Services → Credentials → Create Credentials → OAuth Client ID*:  
   - Application type = **Web application** (or Desktop for testing).  
   - Add **Authorized redirect URI** (e.g., `http://localhost:8080/callback`).  
6. Download the **Client ID** & **Client Secret**.  

---

### 🔹 OAuth2 Complete Flow (Gmail API)
1. **Get Authorization Code**  
   - Direct user to:  
     ```
     https://accounts.google.com/o/oauth2/auth
       ?response_type=code
       &client_id=<YOUR_CLIENT_ID>
       &redirect_uri=<YOUR_REDIRECT_URI>
       &scope=https://www.googleapis.com/auth/gmail.readonly https://www.googleapis.com/auth/gmail.send
       &access_type=offline
     ```
   - User logs in & consents → redirected to:  
     `<YOUR_REDIRECT_URI>?code=AUTH_CODE`

2. **Exchange Authorization Code for Tokens**  
   - POST → `https://accounts.google.com/o/oauth2/token`  
   - Params: `grant_type=authorization_code`, `code=<AUTH_CODE>`, `client_id`, `client_secret`, `redirect_uri`  
   - Response includes `access_token`, `refresh_token`, `expires_in`.  

3. **Call Gmail API using Access Token**  
   - Example (list messages):  
     ```
     GET https://gmail.googleapis.com/gmail/v1/users/me/messages
     Authorization: Bearer <ACCESS_TOKEN>
     ```

4. **Send Email with Access Token**  
   - Gmail requires base64-encoded RFC822 message body.  
   - Example payload (raw → base64url encoded):  
     ```
     To: recipient@example.com
     Subject: Test Email from API

     Hello from Gmail API!
     ```
   - API:  
     ```
     POST https://gmail.googleapis.com/gmail/v1/users/me/messages/send
     Authorization: Bearer <ACCESS_TOKEN>
     Content-Type: application/json

     {
       "raw": "<BASE64URL_ENCODED_EMAIL>"
     }
     ```

5. **Refresh Token (when access token expires)**  
   - POST → `https://accounts.google.com/o/oauth2/token`  
   - Params: `grant_type=refresh_token`, `refresh_token=<REFRESH_TOKEN>`, `client_id`, `client_secret`  
   - Response → new `access_token`.  

---

### 🔹 Postman Setup
- In Postman → **Authorization → OAuth 2.0**  
  - Grant Type = Authorization Code  
  - Auth URL = `https://accounts.google.com/o/oauth2/auth`  
  - Access Token URL = `https://accounts.google.com/o/oauth2/token`  
  - Client ID = `<YOUR_CLIENT_ID>`  
  - Client Secret = `<YOUR_CLIENT_SECRET>`  
  - Scope = `https://www.googleapis.com/auth/gmail.readonly https://www.googleapis.com/auth/gmail.send`  
  - Redirect URI = `<YOUR_REGISTERED_REDIRECT_URI>`  
- Click **Get New Access Token** → Login → Token saved → Postman auto-adds `Authorization: Bearer <token>`.  

**Send Email in Postman**:  
- Method: `POST`  
- URL: `https://gmail.googleapis.com/gmail/v1/users/me/messages/send`  
- Headers:  
  - `Authorization: Bearer <ACCESS_TOKEN>`  
  - `Content-Type: application/json`  
- Body → Raw JSON:  
  ```json
  {
    "raw": "BASE64URL_ENCODED_EMAIL"
  }
  ```

---

### 🔹 RestAssured Example
```java
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.Base64;
import static io.restassured.RestAssured.given;

public class GmailOAuth2Example {
    public static void main(String[] args) {

        // STEP 1: Exchange AUTH_CODE for Access + Refresh Token
        String accessToken = given()
                .formParam("grant_type", "authorization_code")
                .formParam("code", "<AUTH_CODE>")
                .formParam("client_id", "<YOUR_CLIENT_ID>")
                .formParam("client_secret", "<YOUR_CLIENT_SECRET>")
                .formParam("redirect_uri", "<YOUR_REGISTERED_REDIRECT_URI>")
                .when()
                .post("https://accounts.google.com/o/oauth2/token")
                .then()
                .statusCode(200)
                .extract().path("access_token");

        // STEP 2: List Gmail Messages
        Response response = given()
                .auth().oauth2(accessToken)
                .when()
                .get("https://gmail.googleapis.com/gmail/v1/users/me/messages")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Gmail Messages: " + response.asString());

        // STEP 3: Send Email
        String email = "To: recipient@example.com\n"
                     + "Subject: Test Email from API\n\n"
                     + "Hello from Gmail API!";
        String encodedEmail = Base64.getUrlEncoder().encodeToString(email.getBytes());

        Response sendResponse = given()
                .auth().oauth2(accessToken)
                .contentType("application/json")
                .body("{\"raw\":\"" + encodedEmail + "\"}")
                .when()
                .post("https://gmail.googleapis.com/gmail/v1/users/me/messages/send")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Send Email Response: " + sendResponse.asString());

        // STEP 4: Refresh Token (when expired)
        String newAccessToken = given()
                .formParam("grant_type", "refresh_token")
                .formParam("refresh_token", "<YOUR_REFRESH_TOKEN>")
                .formParam("client_id", "<YOUR_CLIENT_ID>")
                .formParam("client_secret", "<YOUR_CLIENT_SECRET>")
                .when()
                .post("https://accounts.google.com/o/oauth2/token")
                .then()
                .statusCode(200)
                .extract().path("access_token");

        System.out.println("New Access Token: " + newAccessToken);
    }
}
```

---

### 🔹 Quick Notes
- Flow: **Auth Code → Access Token → API Call (Read/Send Email) → Refresh Token**.  
- `.auth().oauth2(token)` in RestAssured = auto sets `Authorization: Bearer <token>`.  
- For sending emails, Gmail expects **base64url-encoded RFC822 email string**.  
- Use **scope `gmail.send`** for sending, `gmail.readonly` for reading.  
- Refresh token avoids repeated login prompts.  
