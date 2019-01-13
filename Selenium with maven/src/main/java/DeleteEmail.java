import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeleteEmail {

    public static void main(String[] args){

        //setting chrome driver so we can automate chrome
        System.setProperty("webdriver.chrome.driver", "/opt/google/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();

        //login process

        driver.get("https://mail.google.com/mail/");

        //for email
        driver.findElement(By.name("identifier")).sendKeys("email");
        driver.findElement(By.id("identifierNext")).sendKeys(Keys.RETURN);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //for password
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.id("passwordNext")).sendKeys(Keys.RETURN);

        //wait to load and avoid blocking of gmail account

        try {
            Thread.sleep(Long.parseLong("5000"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //for deletion
        List<WebElement> email = driver.findElements(By.cssSelector(".yX.xY"));

        for(WebElement emailSenders : email){
            System.out.print(emailSenders.getText());
            if(emailSenders.getText().equals("Senders Name") == true){
                Actions oAction = new Actions(driver);
                oAction.moveToElement(emailSenders);
                oAction.contextClick(emailSenders).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
                break;
            }
        }



        //for logout
        driver.findElement(By.cssSelector(".gb_b.gb_hb.gb_R")).click();
        driver.findElement(By.id("gb_71")).click();

        //for closing chrome
        driver.close();
    }

}
