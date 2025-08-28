import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Example TestNG Data-Driven Test using Selenium
 * Demonstrates two ways of providing test data with @DataProvider
 */
public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://example.com/login");  // Replace with actual login URL
    }

    /**
     * --- DataProvider (Way 1) ---
     * Define rows and columns explicitly, then return data.
     */
    @DataProvider(name = "loginDataExplicit")
    public Object[][] getExplicitData() {

        // 3 rows × 2 columns (username, password)
        Object[][] data = new Object[3][2];

        data[0][0] = "user1@example.com";
        data[0][1] = "password1";

        data[1][0] = "user2@example.com";
        data[1][1] = "password2";

        data[2][0] = "user3@example.com";
        data[2][1] = "password3";

        return data;
    }

    /**
     * --- DataProvider (Way 2) ---
     * Return data objects directly in a 2D array.
     */
    @DataProvider(name = "loginDataDirect")
    public Object[][] getDirectData() {
        return new Object[][]{
                {"user1@example.com", "password1"},
                {"user2@example.com", "password2"},
                {"user3@example.com", "password3"}
        };
    }

    /**
     * --- Test Method ---
     * Uses DataProvider to supply multiple username/password sets.
     */
    @Test(dataProvider = "loginDataDirect")   // Change to "loginDataExplicit" to try the 1st way
    public void loginTest(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginBtn")).click();

        // Dummy check: assume dashboard should appear after login
        boolean isLoggedIn = driver.findElements(By.id("dashboard")).size() > 0;
        Assert.assertTrue(isLoggedIn, "Login failed for user: " + username);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
