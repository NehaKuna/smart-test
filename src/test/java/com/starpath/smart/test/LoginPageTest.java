package com.starpath.smart.test;

import com.starpath.smart.base.BaseTest;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@RunWith(BlockJUnit4ClassRunner.class)
public class LoginPageTest extends BaseTest {
    private static ChromeDriverService service;
    private static WebDriver driver;

    private static final By LOGIN_XPATH = By.xpath("//*[@id=\"nav-login\"]/a[2]");
    private static final By LOGIN_HEADING_PATH = By.xpath("//*[@id=\"formLogin\"]/legend[1]");
    private static final By LOGIN_EMAIL_TEXT_FIELD_PATH = By.xpath("//*[@id=\"formLogin\"]/div[1]/div/input");
    private static final By LOGIN_PASSWORD_TEXT_FIELD_PATH = By.xpath("//*[@id=\"formLogin\"]/div[2]/div/input");
    private static final By LOGIN_LOGIN_BUTTON_PATH = By.xpath("//*[@id=\"login\"]");
    private static final By LOGIN_EDIT_LINK_PATH = By.xpath("//*[@id=\"nav-logout\"]/div/ul/li[1]/a");
    private static final By LOGIN_EDIT_LINK_REGISTER_PATH = By.xpath("/html/body/div[2]/form/fieldset/legend");
    private static final By LOGOUT_DROP_DOWN_PATH = By.xpath("//*[@id=\"nav-logout\"]/div/a");
    private static final By LOGIN_EDIT_PROFILE_PHONE_FIELD_PATH = By.xpath("//*[@id=\"phone\"]");
    private static final By LOGIN_EDIT_PROFILE_SAVE_PATH = By.xpath("//*[@id=\"saveuser\"]");
    private static final By LOGIN_SIGN_OUT_PATH = By.xpath("//*[@id=\"nav-logout\"]/div/ul/li[3]/a");
    private static final By LOGIN_FORGOT_PASSWORD_LINK_PATH = By.xpath("//*[@id=\"formLogin\"]/a");
    private static final By LOGIN_RECOVER_PASSWORD_PATH = By.xpath("/html/body/div[2]/legend");
    private static final By LOGIN_RECOVER_PASSWORD_EMAIL_PATH = By.xpath("//*[@id=\"forgotPassword\"]/div[1]/div/input");
    private static final By LOGIN_FORGOT_PASSWORD_SEND_ME_INSTRUCTIONS_BUTTON_PATH = By.xpath("//*[@id=\"forgot\"]");
    public static final By EMAIL_TEXT = By.xpath("//input[contains(@name,'email')]");
    public static final By FORGOT_BUTTON = By.xpath("//button[contains(@id,'forgot')]");
    public static final By DISMISS_BUTTON = By.xpath("//div[contains(@class,'modal-footer')]/a[contains(@class,'btn-primary')]");


    @BeforeClass
    public static void createAndStartService() throws IOException {
        DesiredCapabilities capabillities = DesiredCapabilities.chrome();
        capabillities.setCapability("platform", Platform.ANY);
        capabillities.setCapability("name", "Smart Tests");

        driver = new RemoteWebDriver(
                new URL("http://starpathit:43ff0b08-3569-4e73-aec2-50d5d079ff37@ondemand.saucelabs.com:80/wd/hub"),
                capabillities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void createAndStopService() {
        driver.quit();
    }




    @Test
    public void testLogin() {
        //validate search results
        goToLoginPage();
        login(driver);
        WebElement logoutDropDownPath = locateElement(driver, LOGOUT_DROP_DOWN_PATH, 2);
        Assert.assertNotNull(logoutDropDownPath);
        logoutDropDownPath.click();
        WebElement loginEditPath = locateElement(driver, LOGIN_EDIT_LINK_PATH, 10);
        Assert.assertNotNull(loginEditPath);
        loginEditPath.click();
        WebElement loginRegisterPath = locateElement(driver, LOGIN_EDIT_LINK_REGISTER_PATH, 5);
        Assert.assertNotNull(loginRegisterPath);
        Assert.assertEquals("Register", loginRegisterPath.getText());
        WebElement editProfilePhoneFieldPath = locateElement(driver, LOGIN_EDIT_PROFILE_PHONE_FIELD_PATH, 2);
        Assert.assertNotNull(editProfilePhoneFieldPath);
        editProfilePhoneFieldPath.clear();
        editProfilePhoneFieldPath.sendKeys("7202802753");
        WebElement editProfileSaveButtonPath = locateElement(driver, LOGIN_EDIT_PROFILE_SAVE_PATH, 2);
        Assert.assertNotNull(editProfileSaveButtonPath);
        editProfileSaveButtonPath.click();
        WebElement dismissButton = locateElement(driver, DISMISS_BUTTON, 2);
        Assert.assertNotNull(dismissButton);
        dismissButton.click();
        /*logoutDropDownPath.click();
        WebElement loginSignOutPath = locateElement(driver, LOGIN_SIGN_OUT_PATH, 10);
        Assert.assertNotNull(loginSignOutPath);
        loginSignOutPath.click();*/



    }


    @Test
    public void testForgotPassword() {
        goToLoginPage();
        WebElement forgotPasswordPath = locateElement(driver, LOGIN_FORGOT_PASSWORD_LINK_PATH, 5);
        Assert.assertNotNull(forgotPasswordPath);
        forgotPasswordPath.click();

        WebElement recoverPasswordPath = locateElement(driver, LOGIN_RECOVER_PASSWORD_PATH, 5);
        Assert.assertNotNull(recoverPasswordPath);

        Assert.assertEquals("Recover Password", recoverPasswordPath.getText());
        WebElement recoverPasswordEmail = locateElement(driver, LOGIN_RECOVER_PASSWORD_EMAIL_PATH, 10);
        Assert.assertNotNull(recoverPasswordEmail);
        recoverPasswordEmail.sendKeys("nlmulukutla@gmail.com");
        WebElement sendMeInstructionsButton = locateElement(driver, LOGIN_FORGOT_PASSWORD_SEND_ME_INSTRUCTIONS_BUTTON_PATH, 5);
        Assert.assertNotNull(sendMeInstructionsButton);
        sendMeInstructionsButton.click();
        WebElement dismissButtonOnModalWindow = locateElement(driver,DISMISS_BUTTON,10);
        Assert.assertNotNull(dismissButtonOnModalWindow);
        dismissButtonOnModalWindow.click();


    }


    protected void login(WebDriver driver) {
        WebElement email = locateElement(driver, LOGIN_EMAIL_TEXT_FIELD_PATH, 10);
        // Assert.assertNotNull(email);
        WebElement password = locateElement(driver, LOGIN_PASSWORD_TEXT_FIELD_PATH, 10);
        // Assert.assertNotNull(password);
        WebElement loginButton = locateElement(driver, LOGIN_LOGIN_BUTTON_PATH, 10);
        Assert.assertNotNull(loginButton);

        email.sendKeys("test2@test2.com");
        password.sendKeys("Password");
        loginButton.click();

    }

    protected void goToLoginPage() {
        driver.get("http://tasq.starpathit.cloudbees.net");
        locateElement(driver, LOGIN_XPATH, 2).click();
        WebElement loginHeadingPath = locateElement(driver, LOGIN_HEADING_PATH, 2);
        Assert.assertNotNull(loginHeadingPath);
        Assert.assertEquals("Login", loginHeadingPath.getText());
    }
}
