package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import models.AccountCard;
import models.BankTransaction;
import models.NewCheckingAccountInfo;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CheckingAccountSteps {

    WebDriver driver = new ChromeDriver();

   private LoginPage loginPage =new LoginPage(driver);
@BeforeAll

   @Before
    public void the_user_on_dbank_homepage() {

        driver.get("https://dbank-qa.wedevx.co/bank/login");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Given("the user logged in as {string} {string}")
    public void the_user_logged_in_as(String username, String password) {
    loginPage.login(username, password);

    }


    @When("the user creates a new checking account with the following data")
    public void the_user_creates_a_new_checking_account_with_the_following_data(List<NewCheckingAccountInfo> CheckingAccountInfoList) {
       NewCheckingAccountInfo testDataForOneCheckinAccount = CheckingAccountInfoList.get(0);

        //the user clicks on checking button
        WebElement checkingButton = driver.findElement(By.id("checking-menu"));
        checkingButton.click();

        //the user clicks on the new checking button
        WebElement newCheckinButton = driver.findElement(By.id("new-checking-menu-item"));
        newCheckinButton.click();

        //the user selects the account type
        WebElement accountTypeRadioButton = driver.findElement(By.id(testDataForOneCheckinAccount.getCheckingAccountType()));
        accountTypeRadioButton.click();

        //the user selects  Account Ownership
        WebElement ownerShipButton = driver.findElement(By.id(testDataForOneCheckinAccount.getAccountOwnership()));
        ownerShipButton.click();

        //the user names the account
        WebElement accountNameButton = driver.findElement(By.id("name"));
        accountNameButton.sendKeys(testDataForOneCheckinAccount.getAccountName());

        //the user makes the initial deposit
        WebElement depositButton = driver.findElement(By.id("openingBalance"));
        depositButton.sendKeys(String.valueOf(testDataForOneCheckinAccount.getInitialDepositAmount()));

        //the user click on submit
        WebElement newCheckingSubmitButton = driver.findElement(By.id("newCheckingSubmit"));
        newCheckingSubmitButton.click();

    }


    @Then("the user should see the green {string} message")
    public void the_user_should_see_the_green_message(String expectedConfMessage) {
      //new-account-msg
        WebElement newAccountConfAlertDiv = driver.findElement(By.id("new-account-conf-alert"));
        expectedConfMessage = "Confirmation " + expectedConfMessage + "\n×";
        assertEquals(expectedConfMessage, newAccountConfAlertDiv.getText());



    }
    @Then("the use should see newly added account card")
    public void the_use_should_see_newly_added_account_card(List<AccountCard> accountCardList) {

     List<WebElement> allFirstRowDivs = driver.findElements(By.xpath("//div[@id= 'firstRow']/div"));
      //We did this to get the last cart.
       WebElement lastAccountCart = allFirstRowDivs.get(allFirstRowDivs.size()-1);
        System.out.println(lastAccountCart.getText());
        String actualResult = lastAccountCart.getText();
        String actualAccountName = actualResult.substring(0,actualResult.indexOf("\n"));
        String actualAccountType = actualResult.substring(actualResult.indexOf("Account"), actualResult.indexOf("Ownership")).trim();
        String actualOwnership = actualResult.substring(actualResult.indexOf("Ownership:"), actualResult.indexOf("Account Number:")).trim();
        String actualAccountNumber = actualResult.substring(actualResult.indexOf("Account Number:"), actualResult.indexOf("Interest Rate:")).trim();
        String actualInterestRate = actualResult.substring(actualResult.indexOf("Interest Rate:"), actualResult.indexOf("Balance:")).trim();
        String actualBalance = actualResult.substring(actualResult.indexOf("Balance:"));

        AccountCard expectedResult = accountCardList.get(0);
        assertEquals(expectedResult.getAccountName(),actualAccountName);
        assertEquals("Account: " + expectedResult.getAccountType(), actualAccountType);
        assertEquals("Ownership: " + expectedResult.getOwnership(), actualOwnership);
        assertEquals("Interest Rate: " + expectedResult.getInterestRate(), actualInterestRate);

        String expectedBalance = String.format("%.2f", expectedResult.getBalance());
        assertEquals("Balance: $" + expectedBalance, actualBalance);

    }
    @Then("the user should see the following transactions")
    public void the_user_should_see_the_following_transactions(List<BankTransaction> expectedTransactions) {

       WebElement firstRawOfTransaction = driver.findElement(By.xpath("//table[@id= 'transactionTable']/tbody/tr"));

        List<WebElement> firstRawColumns =firstRawOfTransaction.findElements(By.xpath("td"));

        String actualCategory = firstRawColumns.get(1).getText();
        String actualDescription = firstRawColumns.get(2).getText();
        double actualAmount = Double.parseDouble(firstRawColumns.get(3).getText().substring(1));
        double actualBalance = Double.parseDouble(firstRawColumns.get(4).getText().substring(1));

        assertEquals(expectedTransactions.get(0).getCategory(), actualCategory, "transaction category mismatch");
        //assertEquals(expectedTransactions.get(0).getDescription(), actualDescription, "transaction description mismatch");
        assertEquals(expectedTransactions.get(0).getAmount(), actualAmount, "transaction amount mismatch");
        assertEquals(expectedTransactions.get(0).getBalance(), actualBalance, "transaction balance mismatch");





    }
}



