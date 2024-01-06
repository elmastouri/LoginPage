package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, SECONDS);
        driver.get("https://demo-project.wedevx.co/");
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();


        WebElement widgetButton = driver.findElement(By.id("panel4bh-header"));
        widgetButton.click();

        Thread.sleep(5000);


        WebElement sliderButton = driver.findElement(By.id("slider_page"));
        sliderButton.click();

        Thread.sleep(5000);

        WebElement slider = driver.findElement(By.xpath("//input"));
       Actions actions = new Actions(driver);
       actions.clickAndHold(slider).moveByOffset(100,30).perform();

       actions.dragAndDropBy(slider, 250, 30).perform();

    }
}
