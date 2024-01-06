package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.get("https://dbank-qa.wedevx.co/bank/");

        WebElement signupButton =  driver.findElement(By.xpath("//a[text()= ' Sign Up Here']"));
        signupButton.click();

        driver.navigate().back();

        driver.navigate().forward();

        WebElement firstNameButton = driver.findElement(By.id("firstName"));

        firstNameButton.sendKeys("Abdelmoula");

        WebElement lastNameButton = driver.findElement(By.id("lastName"));

        lastNameButton.sendKeys("Elmastouri");

        driver.navigate().refresh();

        driver.navigate().to("https://dbank-qa.wedevx.co/bank/");


    }
}
