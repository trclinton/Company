package Tests;

import Pages.NextPage;
import Pages.WikiPage;
import org.testng.annotations.Test;
import utils.JSONReader;

import java.io.IOException;
import java.util.Map;

import static Manager.WebDriverManager.getDriver;

public class WikiTest {

    JSONReader jsonMap = new JSONReader();
    String dir = System.getProperty("user.home");
    String filePath = dir +"/IdeaProjects/Wiki/src/test/resources/Data/data.json";

    @Test(priority = 2)
    public void searchTest() throws IOException {
        WikiPage page1 = new WikiPage(getDriver());
        NextPage page2 = new NextPage(getDriver());
        Map<String, String> map = jsonMap.JSONDataReader(filePath);
        page1.setSearchTextBox(map.get("searchText"));
        page1.clickSubmitButton();
        page2.getHeadingByText("Pommes");
    }

    @Test(priority = 1)
    public void changeLanguageTest() throws IOException {
        WikiPage page1 = new WikiPage(getDriver());
        Map<String, String> map = jsonMap.JSONDataReader(filePath);
        page1.setSelectDropdown(map.get("languageCode"));
    }
}
