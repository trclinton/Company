package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Manager.WebDriverManager.getDriver;

public class WikiPage {

    WebDriver driver;

    public WikiPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement searchTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//select[@id='searchLanguage']")
    private WebElement selectDropdown;

    public void setSearchTextBox(String str){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(searchTextBox));
        searchTextBox.sendKeys(str);
    }

    public void clickSubmitButton(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }

    public void setSelectDropdown(String value){
        Select select = new Select(selectDropdown);
        select.selectByValue(value);
    }
}