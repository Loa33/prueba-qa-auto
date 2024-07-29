package org.example.pages;

import ch.qos.logback.classic.Logger;
import org.example.config.ConfigProperties;
import org.example.constants.Timeouts;
import org.example.models.User;
import org.example.utils.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class RegisterPage {
    private WebDriver webDriver;
    private WebDriverWait wait;


    @FindBy(id = "customerForm")
    private WebElement frmCustomer;
    @FindBy(xpath = "//a[text()='Register']")
    private WebElement lnkRegister;

    @FindBy(id = "customer.firstName")
    private WebElement txtFirstName;

    @FindBy(id = "customer.lastName")
    private WebElement txtLastName;

    @FindBy(id = "customer.address.street")
    private WebElement txtAddress;

    @FindBy(id = "customer.address.city")
    private WebElement txtCity;

    @FindBy(id = "customer.address.state")
    private WebElement txtState;

    @FindBy(id = "customer.address.zipCode")
    private WebElement txtZipCode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement txtPhoneNumber;

    @FindBy(id = "customer.ssn")
    private WebElement txtSSN;

    @FindBy(id = "customer.username")
    private WebElement txtUsername;

    @FindBy(id = "customer.password")
    private WebElement txtPassword;

    @FindBy(id = "repeatedPassword")
    private WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement btnRegister;

    @FindBy(xpath = "//div[@id='rightPanel']//p")
    private WebElement pSuccessMessage;

    @FindBy(css = "span.error, p.error")
    private List<WebElement> webElmErrorMessages;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(Timeouts.WAIT_ELEMENT));
        PageFactory.initElements(webDriver, this);
    }

    public void navigateUrl() {
        webDriver.get(ConfigProperties.getProperty("BASE_URL"));
    }

    public void redirectRegisterPage() {
        wait.until(ExpectedConditions.visibilityOf(frmCustomer));
        Assert.assertTrue(frmCustomer.isDisplayed());
    }

    public void clickLinkRegister() {
        Actions.clickWithWait(wait, lnkRegister);
    }

    public void fillFormRegister(User user) {
        Actions.sendKeysWithWait(wait, txtFirstName, user.getFirstName());
        Actions.sendKeysWithWait(wait, txtLastName, user.getLastName());
        Actions.sendKeysWithWait(wait, txtAddress, user.getAddress());
        Actions.sendKeysWithWait(wait, txtCity, user.getCity());
        Actions.sendKeysWithWait(wait, txtState, user.getState());
        Actions.sendKeysWithWait(wait, txtZipCode, user.getZipCode());
        Actions.sendKeysWithWait(wait, txtPhoneNumber, user.getPhoneNumber());
        Actions.sendKeysWithWait(wait, txtSSN, user.getSsn());
        Actions.sendKeysWithWait(wait, txtUsername, user.getUsername());
        Actions.sendKeysWithWait(wait, txtPassword, user.getPassword());
        Actions.sendKeysWithWait(wait, txtConfirmPassword, user.getPasswordConfirmation());
    }

    public void clickBtnRegister() {
        Actions.clickWithWait(wait, btnRegister);
    }

    public void viewSuccessMessage(String mensaje) {
        wait.until(ExpectedConditions.visibilityOf(pSuccessMessage));
        Assert.assertEquals(pSuccessMessage.getText(), mensaje);
    }


    public void viewErrorMessage(String mensaje) {
        boolean isErrorMessageDisplayed = false;
        for (WebElement message : webElmErrorMessages) {
            if (Objects.equals(message.getText(), mensaje)) {
                isErrorMessageDisplayed = true;
                break;
            }
        }
        Assert.assertTrue(isErrorMessageDisplayed);
    }
}
