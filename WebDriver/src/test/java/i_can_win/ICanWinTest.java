package i_can_win;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ICanWinTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void testICanWin(){
        driver.get("https://pastebin.com/");

        WebElement textArea = driver.findElement(By.id("postform-text"));
        textArea.sendKeys("Hello from WebDriver");

        WebElement pasteExpiration = driver.findElement(By.xpath("//*[@id='w0']/div[5]/div[1]/div[2]/div/span/span[1]/span"));
        pasteExpiration.click();

        WebElement chooseExpiration = driver.findElement(By.xpath("//*[contains(@id,'select2-postform-expiration-result-') and contains(@id,'-10M')]"));
        chooseExpiration.click();

        WebElement name = driver.findElement(By.id("postform-name"));
        name.sendKeys("helloweb");

        WebElement createPaste = driver.findElement(By.xpath("//*[@id=\"w0\"]/div[5]/div[1]/div[8]/button"));
        createPaste.click();

        WebElement result = driver.findElement(By.linkText("body > div.wrap > div.container > div.content > div.post-view > div.highlighted-code > div.source > ol > li > div"));
        String v = result.getText();

        System.out.println(v);
        Assert.assertEquals(v, "Hello from WebDriver");
    }

    @AfterMethod
    public void setDown(){
        driver.quit();
        driver = null;
    }
}
