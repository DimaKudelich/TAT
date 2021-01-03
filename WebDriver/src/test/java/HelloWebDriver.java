import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://by.wildberries.ru/");
        WebElement searchInput = driver.findElement(By.id("tbSrch"));
        searchInput.sendKeys("book");
        WebElement searchBtn = driver.findElement(By.id("btnSrch"));
        searchBtn.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
