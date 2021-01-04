package page;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected Actions actions;

    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage()
    {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
        driverWait = new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS);
        actions = new Actions(driver);
    }

    protected abstract AbstractPage openPage();
}
