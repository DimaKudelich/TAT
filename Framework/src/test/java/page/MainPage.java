package page;

public class MainPage extends AbstractPage {

    public static final String ADRESS = "https://by.wildberries.ru/";
    public MainPage(){
        super();
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(ADRESS);
        return this;
    }

    public MainPage enterSearchText(String text){
        return this;
    }
}
