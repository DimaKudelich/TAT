package util;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<String> getStringsFromListOfWebElements(List<WebElement>webElements){
        List<String>strings = new ArrayList<>();

        for(WebElement element:webElements){
            strings.add(element.getText());
        }

        return strings;
    }
}
