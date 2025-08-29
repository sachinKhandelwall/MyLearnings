## 📌 Basic Authentication

### 🔹 Postman
- Example: `GET http://localhost:8080/secure-data`  
- In Postman → **Authorization → Basic Auth**  
- Username = `admin` , Password = `password123`  
- Postman auto-adds in Request Header:  
  `Authorization: Basic YWRtaW46cGFzc3dvcmQxMjM=` (base64 of `admin:password123`)  

---

### 🔹 RestAssured
```java
// Non-preemptive Basic Auth (2-step process)
// Sends credentials only after server responds with 401 Unauthorized
Response response = given()
        .auth().basic("admin", "password123")
        .when()
        .get("/secure-data")
        .then()
        .statusCode(200)
        .extract().response();

// Preemptive Basic Auth (preferred)
// Sends credentials in the very first request → saves one extra round trip
Response response = given()
        .auth().preemptive().basic("admin", "password123")
        .when()
        .get("/secure-data")
        .then()
        .statusCode(200)
        .extract().response();

---

🔹 Quick Notes

.auth().basic(user, pass) →
 Non-preemptive Basic Auth (2-step: request → 401 → resend with creds)

.auth().preemptive().basic(user, pass) →
Preemptive Basic Auth (sends creds in 1st request, saves round trip, preferred if API always requires Basic Auth)
