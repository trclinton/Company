package Manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    private static WebDriver driver;

    private WebDriverManager(){}

    public static synchronized WebDriver createDriver(String browser){
        String dir = System.getProperty("user.home");
        switch(browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", dir+"/IdeaProjects/Company/src/test/resources/drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", dir+"/IdeaProjects/Company/src/test/resources/drivers/geckodriver");
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser " + browser + " not supported");
        }
        return driver;
    }

    public static synchronized WebDriver getDriver(){
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }
}
