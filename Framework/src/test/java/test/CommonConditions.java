package test;

import driver.DriverSingleton;
import org.testng.annotations.AfterMethod;

public class CommonConditions {
    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
