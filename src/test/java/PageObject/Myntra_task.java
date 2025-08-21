package PageObject;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Myntra_task {
	WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.myntra.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        
    }

    @Test
    public void addAndRemoveFromCart() throws InterruptedException {
        
        // Search for "plant"
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
        searchBox.sendKeys("Doll");
        driver.findElement(By.className("desktop-submit")).click();

        // Pick nth item dynamically 
        int itemNumber = 5;   // You can change this to any nth item dynamically
        List<WebElement> allItems = driver.findElements(By.cssSelector("li.product-base"));

        if (allItems.size() >= itemNumber) {
            WebElement nthItem = allItems.get(itemNumber - 1); // index starts from 0
            nthItem.click();
        } else {
            Assert.fail("Less than " + itemNumber + " items found in search results");
        }

        // Switch to product tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        // Click Add to Bag
        WebElement addToBagBtn = driver.findElement(By.xpath("//body/div[@id='mountRoot']/div/div/main[@class='pdp-pdp-container']/div[@class='pdp-details common-clearfix']/div[@class='pdp-description-container']/div/div[2]/div[1]/div[1]"));
        addToBagBtn.click();

        // Go to Bag
        driver.findElement(By.xpath("//span[normalize-space()='Bag']")).click();

        // Remove item from Bag
        WebElement removeBtn = driver.findElement(By.xpath("//button[normalize-space()='REMOVE']"));
        removeBtn.click();

        // Confirm Remove
        WebElement confirmRemove = driver.findElement(By.xpath("//div[contains(@role,'dialog')]//div[contains(@class,'inlinebuttonV2-base-actions')]//div[1]"));
        confirmRemove.click();

        // Assertion: Verify Bag is empty
        Thread.sleep(2000); // for bag update
        WebElement bagMsg = driver.findElement(By.xpath("//div[@class='emptyCart-base-emptyDesc']"));
        Assert.assertTrue(bagMsg.isDisplayed(), "There is nothing in your bag. Let's add some items.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

