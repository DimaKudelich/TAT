package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Utils;

import java.util.List;

public class MainPage extends AbstractPage {
    private static final String ADRESS = "https://by.wildberries.ru/";

    @FindBy(xpath = "//*[@id=\"tbSrch\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"btnSrch\"]")
    private WebElement searchButton;

    private final static By searchResultPath = By.xpath("//div[@class = 'dtlist-inner-brand-name']");
    @FindBy(xpath = "//div[@class = 'dtlist-inner-brand-name']")
    private List<WebElement> searchResult;

    public MainPage(){
        super();
    }

    @Override
    public MainPage openPage(){
        driver.navigate().to(ADRESS);
        return this;
    }

    public MainPage enterTextToSearch(String text){
        searchInput.sendKeys(text);
        return this;
    }

    public MainPage searchForText(){
        searchButton.click();
        return this;
    }

    public List<String> getResultsOfSearch(){
        driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultPath));
        return Utils.getStringsFromListOfWebElements(searchResult);
    }
}
