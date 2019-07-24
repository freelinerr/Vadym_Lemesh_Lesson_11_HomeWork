
import com.project.pages.YourLogoLogInPage;
import javafx.beans.property.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;


public class SignInTest {


    private WebDriver webDriver;

    @BeforeTest

    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver",
                "c:\\apache-maven-3.6.1\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }


    @Test(enabled = true)
    public void testSighInAccessVerification() {
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        YourLogoLogInPage logInPage = new YourLogoLogInPage(webDriver);

        logInPage.typeUsername("vadym.test123@gmail.com");
        logInPage.typePassword("12345");
        logInPage.submitLogin();

        logInPage.getAccountName();
        String expectedAccountName = "Vadym Lemesh";
        String actualAccountName = logInPage.getAccountName();
        Assert.assertEquals(expectedAccountName, actualAccountName);

        logInPage.clickSignOutButton();

    }

    @Test(enabled = false)
    public void testSighInNameChange() {
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        YourLogoLogInPage logInPage = new YourLogoLogInPage(webDriver);

        logInPage.typeUsername("vadym.test123@gmail.com");
        logInPage.typePassword("12345");
        logInPage.submitLogin();
        logInPage.openPersonalInformation();
        logInPage.nameFieldEdit("Vad");
        logInPage.oldPasswordFieldEdit("12345");
        logInPage.saveChanges();
        logInPage.backToAccount();
        logInPage.openPersonalInformation();
        logInPage.getNameFieldValue();

        String expectedName = "Vad";
        String actualName = logInPage.getNameFieldValue();
        Assert.assertEquals(expectedName, actualName);

        logInPage.clickSignOutButton();
    }

    @Test(enabled = false)
    public void testSighInPasswordChange() {
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        YourLogoLogInPage logInPage = new YourLogoLogInPage(webDriver);

        logInPage.typeUsername("vadym.test123@gmail.com");
        logInPage.typePassword("12345");
        logInPage.submitLogin();
        logInPage.openPersonalInformation();
        logInPage.oldPasswordFieldEdit("12345");
        logInPage.newPasswordFieldEdit("123456");
        logInPage.confirmationPasswordFieldEdit("123456");
        logInPage.saveChanges();
        logInPage.signOut();
        logInPage.typeUsername("vadym.test123@gmail.com");
        logInPage.typePassword("123456");
        logInPage.submitLogin();

        logInPage.getAccountName();
        String expectedAccountName = "Vad Lemesh";
        String actualAccountName = logInPage.getAccountName();
        Assert.assertEquals(expectedAccountName, actualAccountName);

        logInPage.clickSignOutButton();
    }

    @DataProvider(name = "signUpEmailAddressValidation")
    public Object[][] dataProviderMethod() {
        return new Object[][]
                {
                        {"invalidEmailAddress", "Invalid email address."},
                        {"vadym.test123@gmail.com", "An account using this email address has already been registered. Please enter a valid password or request a new one."}
                };
    }

    @Test(dataProvider = "signUpEmailAddressValidation", enabled = false)
    public void testSignInValidation(String emailAddressValue, String expectedErrorMessageText) {
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");


        YourLogoLogInPage logInPage = new YourLogoLogInPage(webDriver);

        logInPage.typeSignUpEmail(emailAddressValue);
        logInPage.createAccount();

        String actualText = logInPage.getErrorMessageText();
        Assert.assertEquals(expectedErrorMessageText, actualText);

    }
}






