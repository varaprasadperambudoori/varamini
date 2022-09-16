package StepDefs;

import POM.SaleForce;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
    String username;
    String password;
    SaleForce sales;
    @Given("I know my {string} and {string}")
    public void iKnowMyAnd(String arg0, String arg1) {
        if(arg1 != null && arg0 != null){
            this.username = arg0;
            this.password = arg1;
            sales = new SaleForce();
            sales.goToPage();
        }
    }

    @When("I enter my information")
    public void iEnterMyInformation() {
        sales.fillInfo(username,password);
    }

    @And("I press the login button")
    public void iPressTheLoginButton() {
        sales.login();
    }

    @Then("I will see a successful login screen")
    public void iWillSeeASuccessfulLoginScreen() {
        sales.checkLogin();
    }
}
