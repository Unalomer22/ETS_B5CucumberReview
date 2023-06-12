package com.demoblaze.step_definitions;

import com.demoblaze.pages.LoginPage;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_StepDefs {

    LoginPage loginPage=new LoginPage();

    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.login_mtd();
    }
    @Then("verify {string}")
    public void verify(String expectedMessage) {
        loginPage.verifyWelcomeMessage_mtd(expectedMessage);
    }

    @When("The user enters with {string} and {string} credentials")
    public void theUserEntersWithAndCredentials(String username, String password) {
        loginPage.loginWithParameter_mtd(username,password);
    }

    @When("The user enters valid username and password")
    public void the_user_enters_valid_username_and_password(Map<String,String> userInfo) {
        loginPage.loginWithParameter_mtd(userInfo.get("username"),userInfo.get("password"));
    }

    @Then("verify invalid credential {string}")
    public void verifyInvalidCredential(String expectedMessage) {
        loginPage.verifyWithPopUpMessage_mtd(expectedMessage);
    }
}
