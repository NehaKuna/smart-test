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
public class HomePageTest extends BaseTest {
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
    private static final By COMPARE_BUTTON_PATH = By.xpath("//*[@id=\"compare\"]");
    private static final By POST_REVIEW_BUTTON_PATH = By.xpath("//*[@id=\"postReview\"]/p/a");
    private static final By READ_REVIEW_BUTTON_PATH = By.xpath("//*[@id=\"readReview\"]/p[1]/a");
    private static final By POST_REVIEW_PAGE_HEADING_PATH = By.xpath("//*[@id=\"saveReviewForm\"]/fieldset/legend");
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

    @org.junit.Test
    public void testHomePageSearch() {
        searchByCategory();
        //validate search results
        WebElement resultDiv = locateElement(driver, SEARCH_RESULT_DIV_AREA, 2);
        Assert.assertNotNull(resultDiv);


    }

    @org.junit.Test
    public void testButtonLinks() {
        driver.get("http://tasq.starpathit.cloudbees.net");

        WebElement createyourfreeaccountButton = locateElement(driver, CREATE_YOUR_FREE_ACCOUNT_XPATH, 2);
        createyourfreeaccountButton.click();

        WebElement registerHeading = locateElement(driver, REG_HEADING_PATH, 2);
        Assert.assertNotNull(registerHeading);
        Assert.assertEquals("Register", registerHeading.getText());

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

    @org.junit.Test
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
        WebElement dismissButton = locateElement(driver, DISMISS_BUTTON, 2);
        Assert.assertNotNull(dismissButton);
        dismissButton.click();


    }

    @org.junit.Test
    public void testHomePageLinks() {
        driver.get("http://tasq.starpathit.cloudbees.net");
        WebElement writeReviewLink = locateElement(driver, WRITE_REVIEW_LINK_PATH, 2);
        Assert.assertNotNull(writeReviewLink);
        writeReviewLink.click();

        WebElement writeReviewHeading = locateElement(driver, WRITE_REVIEW_HEADING_PATH, 2);
        Assert.assertNotNull(writeReviewHeading);
        Assert.assertEquals("Write a Review", writeReviewHeading.getText());

        WebElement smartSubscribeLink = locateElement(driver, SMART_SUBSCRIBE_LINK_PATH, 2);
        Assert.assertNotNull(smartSubscribeLink);
        smartSubscribeLink.click();

        WebElement marketingText = locateElement(driver, MARKETING_TEXT_PATH, 2);
        Assert.assertNotNull(marketingText);
        Assert.assertEquals("Smart Subscribe", marketingText.getText());

    }

    @org.junit.Test
    public void testCompareButtons() {
        searchByCategory();
        List<WebElement> compareButtons = locateElements(driver, COMPARE_BUTTON_PATH, 10);
        Assert.assertTrue(compareButtons.size() > 0);
        for (WebElement button : compareButtons) {
            Assert.assertNotNull(button);
            Assert.assertEquals("Add To Compare", button.getText());
            button.click();
        }

    }

    @org.junit.Test
    public void testPostReviewButtons() {
        searchByCategory();
        List<WebElement> postReviewButtons = locateElements(driver, POST_REVIEW_BUTTON_PATH, 10);
        Assert.assertTrue(postReviewButtons.size() > 0);
        WebElement firstButton = postReviewButtons.get(0);

        Assert.assertNotNull(firstButton);
        Assert.assertEquals("Post review", firstButton.getText());
        firstButton.click();

        WebElement postReviewPageHeading = locateElement(driver, POST_REVIEW_PAGE_HEADING_PATH, 3);
        Assert.assertNotNull(postReviewPageHeading);
        Assert.assertTrue(postReviewPageHeading.getText().startsWith("Write Your Review On"));


    }

    @org.junit.Test
    public void testReadReviewButtons() {
        searchByCategory();
        List<WebElement> readReviewButtons = locateElements(driver, READ_REVIEW_BUTTON_PATH, 10);
        Assert.assertNotNull(readReviewButtons.size() > 0);
        WebElement firstButton = readReviewButtons.get(0);

        Assert.assertNotNull(firstButton);
        Assert.assertEquals("Read reviews", firstButton.getText());
        firstButton.click();
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
