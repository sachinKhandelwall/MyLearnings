## 📌 File Upload Example

### 🔹 Postman (GUI)


POST http://localhost:8080/upload

**Body → form-data**

| KEY        | TYPE | VALUE          |
|------------|------|----------------|
| file       | File | testfile.txt   |

**Note on Key:**  
The key does **not** always have to be `file`.  
It depends on what the backend expects (e.g., `file`, `document`, `image`, `profilePic`).  
In Postman and RestAssured, you must use the same key name that the API requires.  

---

### 🔹 RestAssured (Java)

```java
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
                .multiPart("file", testFile, "text/plain") // key must match API (e.g., file, image, document)
                .contentType(ContentType.MULTIPART)
                .when()
                .post("/upload")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Response: " + response.asString());
    }
}
