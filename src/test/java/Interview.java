import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Interview {

    public static void main(String[] args) {
        String dir = System.getProperty("user.home");
        System.setProperty("webdriver.chrome.driver", dir+"/IdeaProjects/Company/src/test/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
}
