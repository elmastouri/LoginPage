package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    private WebDriver driver;
    public LoginPage (WebDriver driver) {
       this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement usernameTxtBox;

    @FindBy(id = "password")
    private WebElement passwordTxBox;

    @FindBy(id = "remember-me")
    private WebElement remember_meCheckBox;

    @FindBy(xpath = "//button")
    private WebElement submitBtn;

    @FindBy(xpath = "//a[contains(text(),'Sign Up Here')]")
    private WebElement signUpHereLink;

    public void login(String username,String password ) {
        usernameTxtBox.sendKeys(username);
        passwordTxBox.sendKeys(password);
        submitBtn.click();
    }



}
