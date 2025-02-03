package Base;

import Manager.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

import static Manager.WebDriverManager.getDriver;
import static Manager.WebDriverManager.quitDriver;

public class BaseTest {

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browser){
        WebDriverManager.createDriver(browser);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().get("https://www.wikipedia.org/");
    }

    @AfterMethod
    public void tearDown(){
        if(getDriver() != null){
            quitDriver();
        }
    }
}
