package justforpractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(3, SECONDS);
        driver.get("https://demo-project.wedevx.co/");
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();

        Thread.sleep(500);

        WebElement window = driver.findElement(By.id("panel3bh-header"));
        window.click();
        Thread.sleep(5000);

        WebElement alerts_page = driver.findElement(By.id("alerts_page"));
        alerts_page.click();

        WebElement firstAlert = driver.findElement(By.id("alertButton"));
        firstAlert.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        Thread.sleep(5000);

        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        System.out.println(alert.getText());
        alert.accept();

        Thread.sleep(5000);


        WebElement dismissConfirmBoxButton = driver.findElement(By.id("confirmButton"));
        dismissConfirmBoxButton.click();
        System.out.println(alert.getText());
        alert.dismiss();

        Thread.sleep(5000);

        WebElement okConfirmBoxButton = driver.findElement(By.id("confirmButton"));
        okConfirmBoxButton.click();
        System.out.println(alert.getText());
        alert.accept();

            Thread.sleep(5000); 

        //promptButton
        WebElement promptButton = driver.findElement(By.id("promptButton"));
        promptButton.click();
        System.out.println(alert.getText());
        alert.sendKeys("Abdelmoula");
        alert.accept();


    }
}
