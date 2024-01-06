package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.util.concurrent.TimeUnit.SECONDS;

public class KeyBordAction {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(3, SECONDS);
        driver.get("https://demo-project.wedevx.co/");
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();


        WebElement formsButton = driver.findElement(By.id("panel2bh-header"));
        formsButton.click();

        Thread.sleep(500);

        WebElement practiceFormsButton = driver.findElement(By.id("practiceForm_page"));
        practiceFormsButton.click();

        Thread.sleep(500);

        WebElement firstName = driver.findElement(By.id("firstName"));

        Actions actions = new Actions(driver);

        actions.sendKeys(firstName,"Abdelmoula").keyDown(Keys.COMMAND)
                .sendKeys("a").keyDown(Keys.COMMAND)
                .sendKeys("c").sendKeys(Keys.TAB).keyDown(Keys.COMMAND)
                .sendKeys("v").perform();

    }
}
