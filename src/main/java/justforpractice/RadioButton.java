package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RadioButton {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(3, SECONDS);
        driver.get("https://demo-project.wedevx.co/");
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();

       WebElement radioButtonPage = driver.findElement(By.id("radioButton_page"));
       radioButtonPage.click();

        WebElement impressiveButton = driver.findElement(By.xpath("//input[@value= 'Impressive']"));
        impressiveButton.click();

        System.out.println(impressiveButton.isSelected());
        System.out.println(impressiveButton.isEnabled());


    }
}
