package justforpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumIntro1 {
    public static void main(String[] args) {
        WebDriver driver = new SafariDriver();
        driver.get("https://www.wedevx.co/");

   }
}
