package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "login2")
    public WebElement loginHomePage_loc;
    @FindBy(id = "loginusername")
    public WebElement username_loc;
    @FindBy(id = "loginpassword")
    public WebElement password_loc;
    @FindBy(css = "[onclick='logIn()']")
    public WebElement loginBtn_loc;
    @FindBy(id = "nameofuser")
    public WebElement welcomeUsername_loc;


    public void login_mtd(){
        String username= ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        loginHomePage_loc.click();
        username_loc.sendKeys(username);
        password_loc.sendKeys(password);
        loginBtn_loc.click();
        BrowserUtils.waitFor(2);
    }

    public void verifyWelcomeMessage_mtd(String expectedMessage){
        String actualMessage = welcomeUsername_loc.getText();
        Assert.assertEquals("username does NOT match",expectedMessage,actualMessage);
        System.out.println("expectedMessage = " + expectedMessage);
        System.out.println("actualMessage = " + actualMessage);
    }

    public void loginWithParameter_mtd(String username, String password){

        BrowserUtils.waitForClickablility(loginHomePage_loc,4).click();
        username_loc.sendKeys(username);
        password_loc.sendKeys(password);
        loginBtn_loc.click();
        BrowserUtils.waitFor(3);
    }
    public void verifyWithPopUpMessage_mtd(String expectedMessage){
        Alert alert= Driver.get().switchTo().alert();
        String actualMessage=alert.getText();
        System.out.println("actualMessage = " + actualMessage);
        System.out.println("expectedMessage = " + expectedMessage);
        Assert.assertEquals("Message does NOT match", expectedMessage,actualMessage);
    }



}
