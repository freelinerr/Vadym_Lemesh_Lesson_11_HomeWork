package com.project.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class YourLogoLogInPage {

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy (xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a/span")
    private WebElement customerAccountButton;

    @FindBy (className = "logout")
    private WebElement signOutButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")
    private WebElement myPersonalInformationButton;

    @FindBy(id = "firstname")
    private WebElement nameField;

    @FindBy(id = "old_passwd")
    private WebElement oldPasswordField;

    @FindBy(id = "passwd")
    private WebElement newPasswordField;

    @FindBy(id = "confirmation")
    private WebElement confirmationPasswordField;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button/span")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/a/span")
    private WebElement bactToAccountButton;

    @FindBy(id = "firstname")
    private WebElement nameFieldValue;

    @FindBy(id = "email_create")
    private WebElement signUpEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    //error handling
    @FindBy(xpath = "//*[@id=\"create_account_error\"]/ol/li")
    private WebElement errorMessage;

    private static final Logger LOG = LogManager.getLogger(YourLogoLogInPage.class);





    public YourLogoLogInPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }


    public void typeUsername(String email) {
        LOG.info("Entering user name value : " + email);
        emailAddress.sendKeys(email);
    }

    public void typePassword(String passwordValue) {
        LOG.info("Entering password value : " + passwordValue);
        password.sendKeys(passwordValue);
    }

    public void submitLogin() {
        LOG.info("Clicking on sign in button");
        loginButton.click();
    }

    public String getAccountName() {
        return customerAccountButton.getText();
    }

    public void clickSignOutButton(){
        signOutButton.click();
    }
    public void typeSignUpEmail(String email) {
        signUpEmail.sendKeys(email);
    }

    public void createAccount() {
        createAccountButton.click();
    }

    public void openPersonalInformation() {
        myPersonalInformationButton.click();
    }

    public void nameFieldEdit(String newName) {
        nameField.clear();
        nameField.sendKeys(newName);
    }

    public void oldPasswordFieldEdit(String oldPassword) {
        oldPasswordField.sendKeys(oldPassword);
    }

    public void newPasswordFieldEdit(String newPassword) {
        newPasswordField.sendKeys(newPassword);
    }

    public void confirmationPasswordFieldEdit(String confirmationPassword) {
        confirmationPasswordField.sendKeys(confirmationPassword);
    }

    public void saveChanges() {
        saveButton.click();
    }

    public void backToAccount() {
        bactToAccountButton.click();
    }

    public String getNameFieldValue() {
        return nameFieldValue.getAttribute("value");
    }

    public void signOut() {
        signOutButton.click();
    }


    //error handling
    public String getErrorMessageText() {
        return errorMessage.getText();
        //
    }

}


