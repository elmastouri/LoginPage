package justforpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class FindElements {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-project.wedevx.co/");

       WebElement webTableButtons = driver.findElement(By.id("webTables_page"));
       webTableButtons.click();


        List<WebElement> AllThElement = driver.findElements(By.xpath("//table//th"));
        System.out.println(AllThElement.size());

        for(WebElement th: AllThElement) {
            System.out.println(th.getText());
        }

        List<WebElement> AllTdElement = driver.findElements(By.xpath("//table//td"));
        System.out.println(AllTdElement.size());

        for(WebElement td: AllThElement) {
            System.out.println(td.getText());
        }

    }
}
