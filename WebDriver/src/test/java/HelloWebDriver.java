import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://by.wildberries.ru/");

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("tbSrch")));

        //WebElement searchInput = driver.findElement(By.id("tbSrch"));
        WebElement searchInput = waitForElementLocatedBy(driver,By.id("tbSrch"));
        searchInput.sendKeys("book");

        List<WebElement> searchBtn = driver.findElements(By.id("btnSrch"));
        searchBtn.get(0).click();

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("btnSrch")));

        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver,By by) {
        return new WebDriverWait(driver,10)
                    .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
