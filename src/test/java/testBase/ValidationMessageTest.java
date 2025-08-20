package testBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidationMessageTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");

        // Locate Email field
        WebElement emailField = driver.findElement(By.id("input-email"));
        emailField.sendKeys("ankitlavhale@"); // Invalid email

        // Submit form without valid email
        driver.findElement(By.cssSelector("input[type='submit'][value='Continue']")).click();

        // Get HTML5 validation message
        String validationMsg = emailField.getAttribute("validationMessage");
        System.out.println("Validation Message: " + validationMsg);

        driver.quit();
    }
}

