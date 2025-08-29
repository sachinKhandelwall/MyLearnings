## 📌 Basic Authentication

### 🔹 Postman
- Example: `GET http://localhost:8080/secure-data`
- Go to **Authorization → Basic Auth**
- Enter Username = `admin`, Password = `password123`
- Postman auto-adds in Request Header:  
  `Authorization: Basic YWRtaW46cGFzc3dvcmQxMjM=` (base64 of `admin:password123`)

---

### 🔹 RestAssured
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BasicAuthExample {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:8080";

        Response response = given()
                .auth().basic("admin", "password123")
                .when()
                .get("/secure-data")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}
