## 📌 Postman + RestAssured File Upload

POST http://localhost:8080/upload

Go to Body → form-data

    Key = file
    Type = File
    Value = testfile.txt

Postman auto-sets: Content-Type: multipart/form-data

**Note on Key:**  
The key does not always have to be file.  
It depends on what the backend expects (e.g., file, document, image, profilePic).  
In Postman and RestAssured, you must use the same key name that the API requires.  

### 🔹 RestAssured (Java)

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class FileUploadExample {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:8080";

        File testFile = new File("src/test/resources/testfile.txt");

        Response response = given()
                .multiPart("file", testFile) // key must match API (e.g., file, image, document)
                .contentType(ContentType.MULTIPART)
                .when()
                .post("/upload")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}

---

## 📌 Postman + RestAssured URL Encoded (a.k.a. application/x-www-form-urlencoded)

### 🔹 What is it?
- Used to send form data (`application/x-www-form-urlencoded`) in the request body.
- Data is sent as key-value pairs, joined with &, and special characters are percent-encoded.
- For example(space in name) fullName=John Doe   →   fullName=John%20Doe
- Commonly used in login/auth APIs.  
- Equivalent to Postman → Body → x-www-form-urlencoded.  

### 🔹 Postman Example
POST http://localhost:8080/login  

**Body → x-www-form-urlencoded**  
| KEY      | VALUE      |
|----------|------------|
| username | john_doe   |
| password | secret123  |

Header (auto): `Content-Type: application/x-www-form-urlencoded`

### 🔹 RestAssured Example

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class FormParamExample {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://localhost:8080";

        Response response = given()
                .contentType(ContentType.URLENC)
                .formParam("username", "john_doe")
                .formParam("password", "secret123")
                .when()
                .post("/login")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}
