package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.util.concurrent.TimeUnit.SECONDS;


public class JavaScriptExecutor {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(3, SECONDS);
        driver.get("https://demo-project.wedevx.co/");
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.location= 'https://etsy.com/'");

        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,-1000)");

        WebElement privacy = driver.findElement(By.linkText("Privacy"));
        js.executeScript("arguments[0].scrollIntoView()", privacy);


    }
}
