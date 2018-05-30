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
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(BlockJUnit4ClassRunner.class)
public class ReviewPageTest extends BaseTest {
    private static WebDriver driver;

    private static final By SEARCH_RESULT_DIV_AREA = By.xpath("/html/body/div[2]/div[3]");
    private static final By SIGNUP_XPATH = By.xpath("//*[@id=\"nav-login\"]/a[1]");
    private static final By REG_HEADING_PATH = By.xpath("/html/body/div[2]/form/fieldset/legend[1]");
    private static final By LOGIN_XPATH = By.xpath("//*[@id=\"nav-login\"]/a[2]");
    private static final By CREATE_YOUR_FREE_ACCOUNT_XPATH = By.xpath("/html/body/div[2]/div[1]/a");
    private static final By LOGIN_HEADING_PATH = By.xpath("//*[@id=\"formLogin\"]/legend[1]");
    private static final By WRITE_REVIEW_LINK_PATH = By.xpath("/html/body/div[1]/div/div/div[2]/ul/li/a");
    private static final By WRITE_REVIEW_HEADING_PATH = By.xpath("//*[@id=\"list\"]/legend");
    private static final By SMART_SUBSCRIBE_LINK_PATH = By.xpath("/html/body/div[1]/div/div/a");
    private static final By MARKETING_TEXT_PATH = By.xpath("/html/body/div[2]/div[1]/h1");
    private static final By SIGNUP_NAME_PATH = By.xpath("//*[@id=\"name\"]");
    private static final By SIGNUP_EMAIL_PATH = By.xpath("//*[@id=\"email\"]");
    private static final By SIGNUP_PASSWORD_PATH = By.xpath("//*[@id=\"password\"]");
    private static final By SIGNUP_CONFIRM_PASSWORD_PATH = By.xpath("//*[@id=\"confirmPassword\"]");
    private static final By SIGNUP_PHONE_PATH = By.xpath("//*[@id=\"phone\"]");
    private static final By SIGNUP_SAVE_PATH = By.xpath("//*[@id=\"saveuser\"]");
    private static final By SIGNUP_SUCCESS_DIALOG_DISMISS_BUTTON_PATH = By.xpath("//*[@id=\"myModal\"]/div[3]/a");



    private static final By READ_REVIEW_BUTTON_PATH = By.xpath("//*[@id=\"readReview\"]/p[1]/a");
    private static final By READ_REVIEW_RATING_PATH = By.xpath("/html/body/div[2]/div[1]/div[3]/h3");
    private static final By READ_REVIEW_EASY_TO_USE_PATH  = By.xpath("//*[@id=\"star5\"]/img[3]");
    private static final By READ_REVIEW_FLEXIBLE_CONTRACT_PATH = By.xpath("//*[@id=\"star7\"]/img[3]");
    private static final By READ_REVIEW_PRICE_PATH = By.xpath("//*[@id=\"star6\"]/img[3]");
    private static final By READ_REVIEW_CUSTOMER_SERVICE_PATH = By.xpath("//*[@id=\"star6\"]/img[3]");

    private static final By READ_REVIEW_NEED_PROFESSIONAL_ADVICE_BUTTON_PATH = By.xpath("/html/body/div[2]/div[2]/div[4]/a");





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
    public void testHomePageSearch() {
        searchByCategory();
        //validate search results
        WebElement resultDiv = locateElement(driver, SEARCH_RESULT_DIV_AREA, 2);
        Assert.assertNotNull(resultDiv);


    }

    @Test
    public void testButtonLinks() {
        driver.get("http://tasq.starpathit.cloudbees.net");



        //Find the signUp button on home page and click
        WebElement signUpButton = locateElement(driver, SIGNUP_XPATH, 2);
        signUpButton.click();
        WebElement heading = locateElement(driver, REG_HEADING_PATH, 2);
        Assert.assertNotNull(heading);
        Assert.assertEquals("Register", heading.getText());

        WebElement loginButton = locateElement(driver, LOGIN_XPATH, 2);
        loginButton.click();

        WebElement loginHeading = locateElement(driver, LOGIN_HEADING_PATH, 2);
        Assert.assertNotNull(loginHeading);
    }

    @Test
    public void testSignUp() {
        driver.get("http://tasq.starpathit.cloudbees.net");
        WebElement createyourfreeaccountButton = locateElement(driver, CREATE_YOUR_FREE_ACCOUNT_XPATH, 2);
        createyourfreeaccountButton.click();

        WebElement registerHeading = locateElement(driver, REG_HEADING_PATH, 2);
        Assert.assertNotNull(registerHeading);
        Assert.assertEquals("Register", registerHeading.getText());

        WebElement signupNameField = locateElement(driver, SIGNUP_NAME_PATH, 2);
        Assert.assertNotNull(signupNameField);
        signupNameField.sendKeys("nagalakshmi");

        WebElement signupEmailField = locateElement(driver, SIGNUP_EMAIL_PATH, 2);
        Assert.assertNotNull(signupEmailField);
        signupEmailField.sendKeys("nlmulukutla2@gmail.com");

        WebElement signupPasswordField = locateElement(driver, SIGNUP_PASSWORD_PATH, 2);
        Assert.assertNotNull(signupPasswordField);
        signupPasswordField.sendKeys("password");

        WebElement signupConfirmPasswordField = locateElement(driver, SIGNUP_CONFIRM_PASSWORD_PATH, 2);
        Assert.assertNotNull(signupConfirmPasswordField);
        signupConfirmPasswordField.sendKeys("password");


        WebElement signupPhoneField = locateElement(driver, SIGNUP_PHONE_PATH, 2);
        Assert.assertNotNull(signupPhoneField);
        signupPhoneField.sendKeys("7202802753");

        WebElement signUpSaveButton = locateElement(driver, SIGNUP_SAVE_PATH, 2);
        Assert.assertNotNull(signUpSaveButton);

        signUpSaveButton.click();
        driver.switchTo().frame("Smart Subscribe Message");
        WebElement successDialogDismissButton = locateElement(driver, SIGNUP_SUCCESS_DIALOG_DISMISS_BUTTON_PATH, 2);
        Assert.assertNotNull(successDialogDismissButton);
        successDialogDismissButton.click();


    }



    @Test
    public void testReadReviewButtons() {
        searchByCategory();
       List<WebElement>  readReviewButtons = locateElements(driver, READ_REVIEW_BUTTON_PATH, 10);
        Assert.assertNotNull(readReviewButtons.size() > 0);
        WebElement firstButton = readReviewButtons.get(0);

        Assert.assertNotNull(firstButton);
        Assert.assertEquals("Read reviews", firstButton.getText());
        firstButton.click();

        WebElement ratingsHeadingPath = locateElement(driver, READ_REVIEW_RATING_PATH, 5);
        Assert.assertNotNull(ratingsHeadingPath);


        WebElement easyToUsePath = locateElement(driver,READ_REVIEW_EASY_TO_USE_PATH,5);
        Assert.assertNotNull(easyToUsePath);
        WebElement flexibleContractPath = locateElement(driver,READ_REVIEW_FLEXIBLE_CONTRACT_PATH,5);
        Assert.assertNotNull(flexibleContractPath);
        WebElement pricePath = locateElement(driver,READ_REVIEW_PRICE_PATH,5);
        Assert.assertNotNull(pricePath);
        WebElement customerServicePath = locateElement(driver,READ_REVIEW_CUSTOMER_SERVICE_PATH,5);
        Assert.assertNotNull(customerServicePath);
        easyToUsePath.click();
        pricePath.click();
        flexibleContractPath.click();
        customerServicePath.click();


        WebElement needProfessionalAdviceButton = locateElement(driver,READ_REVIEW_NEED_PROFESSIONAL_ADVICE_BUTTON_PATH,5);
        Assert.assertNotNull(needProfessionalAdviceButton);
        needProfessionalAdviceButton.click();


    }




    //this method is used by two tests
    public void searchByCategory() {
        driver.get("http://tasq.starpathit.cloudbees.net");
        // Check the title of the page
        Assert.assertEquals("Smart Subscribe", driver.getTitle());

        // Find the text input element by its name
        WebElement element = locateElement(driver, By.xpath("/html/body/div[1]/div/div/div[2]/form/input"), 2);
        Assert.assertNotNull(element);

        // Enter something to search for
        element.sendKeys("accounting");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
    }


}
