import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class SendEmail {


    public static void main(String[] args){

        //setting chrome driver so we can automate chrome
        System.setProperty("webdriver.chrome.driver", "/opt/google/chrome/chromedriver");

        WebDriver driver = new ChromeDriver();

        //login process

        driver.get("https://mail.google.com/mail/");

        //for email
        driver.findElement(By.name("identifier")).sendKeys("youremailadrress@here.com");
        driver.findElement(By.id("identifierNext")).sendKeys(Keys.RETURN);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //for password
        driver.findElement(By.name("password")).sendKeys("Password_here");
        driver.findElement(By.id("passwordNext")).sendKeys(Keys.RETURN);

        //wait to load and avoid blocking of gmail account

        try {
            Thread.sleep(Long.parseLong("5000"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //for pressing compose button
        driver.findElement(By.cssSelector(".T-I.J-J5-Ji.T-I-KE.L3")).click();

        //for typing receiver email
        driver.findElement(By.name("to")).sendKeys("your email here");

        //for subject
        driver.findElement(By.name("subjectbox")).sendKeys("Test");

        //for message
        driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("this is a test");

        //for sending
        driver.findElement(By.xpath("//div[text()='Send']")).sendKeys(Keys.RETURN);

        //for logout
        driver.findElement(By.cssSelector(".gb_b.gb_hb.gb_R")).click();
        driver.findElement(By.id("gb_71")).click();

        //for closing chrome
        driver.close();


    }



}