package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class PageNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://dbank-qa.wedevx.co/bank/");
        Thread.sleep(2000);

       WebElement signupButton =  driver.findElement(By.xpath("//a[text()= ' Sign Up Here']"));
       signupButton.click();
       Thread.sleep(2000);

       driver.navigate().back();
        Thread.sleep(2000);

       driver.navigate().forward();
        Thread.sleep(2000);

       WebElement firstNameButton = driver.findElement(By.id("firstName"));
       firstNameButton.sendKeys("Abdelmoula");
        Thread.sleep(2000);

        WebElement lastNameButton = driver.findElement(By.id("lastName"));
        lastNameButton.sendKeys("Elmastouri");
        Thread.sleep(2000);

        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.navigate().to("https://dbank-qa.wedevx.co/bank/");
        Thread.sleep(2000);
    }
}
