package org.example.pages;

import org.example.constants.Timeouts;
import org.example.utils.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy(name = "username")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement btnLogIn;

    @FindBy(id = "accountTable")
    WebElement tblAccount;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(Timeouts.WAIT_ELEMENT));
        PageFactory.initElements(webDriver, this);
    }

    public void fillLogin(String username, String password) {
        Actions.sendKeysWithWait(wait, txtUsername, username);
        Actions.sendKeysWithWait(wait, txtPassword, password);
    }

    public void clickBtnLogIn() {
        Actions.clickWithWait(wait, btnLogIn);
    }


    public void viewTblAccount() {
        wait.until(ExpectedConditions.visibilityOf(tblAccount));
        Assert.assertTrue(tblAccount.isDisplayed());
    }
}
