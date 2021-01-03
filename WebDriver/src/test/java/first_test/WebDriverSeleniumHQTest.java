package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebDriverSeleniumHQTest {
    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test (description = "First test")
    public void commonSearchTermResultsNotEmpty() {

        driver.get("https://by.wildberries.ru/");

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("tbSrch")));

        WebElement searchInput = waitForElementLocatedBy(driver,By.id("tbSrch"));
        searchInput.sendKeys("book");

        List<WebElement> searchBtn = driver.findElements(By.id("btnSrch"));
        searchBtn.get(0).click();

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("btnSrch")));


        List<WebElement>searchResults = driver.findElements(By.xpath("//*[@id=\"catalog-content\"]/div[3]"));

        Assert.assertTrue(searchResults.size()>0);
    }

    @AfterMethod (alwaysRun = true)
    public void browserDawn(){
        driver.quit();
        driver = null;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver,By by) {
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
