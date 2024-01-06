package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WindowHandel {
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

        WebElement bowserWindow = driver.findElement(By.id("browserWindows_page"));
        bowserWindow.click();
        Thread.sleep(500);

        String uniqueIdOfTheCurrentTab = driver.getWindowHandle();
        System.out.println(uniqueIdOfTheCurrentTab);

        WebElement newTap = driver.findElement(By.id("tabButton"));
        newTap.click();

        Set<String> allOpenTapIds = driver.getWindowHandles();
       for (String tabId: allOpenTapIds) {
           if(!tabId.equals(uniqueIdOfTheCurrentTab)) {
               driver.switchTo().window(tabId);
               break;
           }
       }

        WebElement nextTap = driver.findElement(By.xpath("//h1"));
        System.out.println(nextTap.getText());

    }
}
