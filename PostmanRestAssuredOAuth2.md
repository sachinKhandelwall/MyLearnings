## 📌 OAuth2 Authentication

### 🔹 What is OAuth2?
- **OAuth2** is an open standard for secure authorization.  
- Instead of sending username/password with every request, a client app uses **tokens**.  
- Flow (simplified):  
  1. Client requests authorization (user login/consent).  
  2. Authorization Server issues an **Access Token** (short-lived).  
  3. Client uses the Access Token in API requests → `Authorization: Bearer <token>`.  
  4. When the token expires, a **Refresh Token** can be used to obtain a new one.  
- Common flows:  
  - **Authorization Code Flow** → when user login/consent is needed (e.g., Gmail).  
  - **Client Credentials Flow** → server-to-server communication (no user login).  

---

### 🔹 Configuration (Example: Gmail API)
1. Go to [Google Cloud Console](https://console.cloud.google.com/).  
2. Create a **New Project** → Enable **Gmail API**.  
3. Navigate to **APIs & Services → Credentials**.  
4. Create **OAuth 2.0 Client ID** (Web Application or Desktop).  
5. Note down:  
   - **Client ID**  
   - **Client Secret**  
   - **Auth URL** = `https://accounts.google.com/o/oauth2/auth`  
   - **Token URL** = `https://accounts.google.com/o/oauth2/token`  
6. Add required scopes (e.g., `https://www.googleapis.com/auth/gmail.readonly`).  

---

### 🔹 Postman
- Example: `GET https://gmail.googleapis.com/gmail/v1/users/me/messages`  
- In Postman → **Authorization → OAuth 2.0**  
  - Grant Type = **Authorization Code**  
  - Auth URL = `https://accounts.google.com/o/oauth2/auth`  
  - Access Token URL = `https://accounts.google.com/o/oauth2/token`  
  - Client ID = `your-client-id`  
  - Client Secret = `your-client-secret`  
  - Scope = `https://www.googleapis.com/auth/gmail.readonly`  
- Click **Get New Access Token** → Login with Gmail → Postman auto-adds:  
  `Authorization: Bearer <access_token>`  

---

### 🔹 RestAssured
```java
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GmailOAuth2Example {
    public static void main(String[] args) {
        // Step 1: Get Access Token
        String token = given()
                .formParam("grant_type", "authorization_code")
                .formParam("code", "<AUTHORIZATION_CODE>") // obtained after consent screen
                .formParam("client_id", "<YOUR_CLIENT_ID>")
                .formParam("client_secret", "<YOUR_CLIENT_SECRET>")
                .formParam("redirect_uri", "<YOUR_REGISTERED_REDIRECT_URI>")
                .when()
                .post("https://accounts.google.com/o/oauth2/token")
                .then()
                .statusCode(200)
                .extract()
                .path("access_token");

        // Step 2: Use Token to Access Gmail API
        Response response = given()
                .auth().oauth2(token) // auto adds Bearer token
                .when()
                .get("https://gmail.googleapis.com/gmail/v1/users/me/messages")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}
```

---

### 🔹 Quick Notes
- `.auth().oauth2(token)` → auto adds `Authorization: Bearer <token>`.  
- Or manually: `.header("Authorization", "Bearer " + token)`.  
- Gmail APIs need **Authorization Code Flow** (interactive login).  
- Access Tokens expire → use **Refresh Tokens** to renew without user login.  
