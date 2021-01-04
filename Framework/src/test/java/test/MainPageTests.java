package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

import java.util.List;

public class MainPageTests extends CommonConditions {
    @Test
    public void isSearchNotEmpty(){
        String text = "куртка";
        List<String>result = new MainPage()
                .openPage()
                .enterTextToSearch(text)
                .searchForText()
                .getResultsOfSearch();

        Assert.assertTrue(result.stream().allMatch(search->search.toLowerCase().contains(text.toLowerCase())));
    }
}
