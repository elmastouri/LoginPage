package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Iframes {
    public static void main(String[] args) throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(3, SECONDS);
            driver.get("https://demo-project.wedevx.co/");
            driver.manage().window().fullscreen();
            driver.manage().window().maximize();

            Thread.sleep(500);

            WebElement window = driver.findElement(By.id("panel3bh-header"));
            window.click();

            Thread.sleep(500);

            WebElement iframes = driver.findElement(By.id("iframes_page"));
            iframes.click();

            Thread.sleep(500);

            WebElement secondBrowser = driver.findElement(By.id("//h1"));
            System.out.println(secondBrowser.getText());

        }
    }

