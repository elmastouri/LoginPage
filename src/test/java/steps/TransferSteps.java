package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TransferSteps {
    @Given("User with account number {int} is registered")
    public void user_with_account_number_is_registered(Integer int1) {

    }
    @Given("User with account number {int} deposited ${int}")
    public void user_with_account_number_deposited_$(Integer int1, Integer int2) {

    }
    @When("User with account number {int} transfers ${int}")
    public void user_with_account_number_transfers_$(Integer int1, Integer int2) {

    }
    @Then("User with account number 4210should have ${int} in balance")
    public void user_with_account_number_4210should_have_$_in_balance(Integer int1) {

    }
    @Then("User should see Insufficient Funds message")
    public void user_should_see_insufficient_funds_message() {

    }

}
