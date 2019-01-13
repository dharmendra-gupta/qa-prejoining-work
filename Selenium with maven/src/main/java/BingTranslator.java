import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingTranslator {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "/opt/google/chrome/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bing.com/translator");



        driver.findElement(By.id("t_sv")).sendKeys("こんにちは");


    }
}
