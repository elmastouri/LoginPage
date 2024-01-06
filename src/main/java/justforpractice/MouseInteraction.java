package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MouseInteraction {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5, SECONDS);
        driver.get("https://demo-project.wedevx.co/");
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();

      WebElement buttonsKey =   driver.findElement(By.id("buttons_page"));
      buttonsKey.click();

        WebElement doubleClickButton =   driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();

        WebElement rightClickButton =   driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickButton).perform();

        WebElement clickMeButton = driver.findElement(By.id("TiIX0"));
        actions.click(clickMeButton).perform();

            }

    }

