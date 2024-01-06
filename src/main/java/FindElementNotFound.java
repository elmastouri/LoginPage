import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FindElementNotFound {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new SafariDriver();
            driver.get("https://demo-project.wedevx.co/");
            driver.findElement(By.xpath("//div[@class= 'Abdelmoula']"));

    }
}
