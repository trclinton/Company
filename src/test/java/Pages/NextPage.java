package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Manager.WebDriverManager.getDriver;

public class NextPage {

    WebDriver driver;

    public NextPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getHeadingByText(String header){
        By byXpath = By.xpath("//h1[@id='firstHeading']//span[contains(text(), '"+header+"')]");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(byXpath));
        return driver.findElement(byXpath);
    }
}
