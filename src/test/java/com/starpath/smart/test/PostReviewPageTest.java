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
public class PostReviewPageTest extends BaseTest {
    private static int counter = 1;
    private static WebDriver driver;

    private static final By SEARCH_RESULT_DIV_AREA = By.xpath("/html/body/div[2]/div[3]");
    private static final By LOGIN_XPATH = By.xpath("//*[@id=\"nav-login\"]/a[2]");
    private static final By POST_REVIEW_BUTTON_PATH = By.xpath("//*[@id=\"postReview\"]/p/a");
    private static final By POST_REVIEW_PAGE_HEADING_PATH = By.xpath("//*[@id=\"saveReviewForm\"]/fieldset/legend");
    private static final By POST_REVIEW_PAGE_USABILITY_RATING_PATH = By.xpath("//*[@id=\"star1\"]");
    private static final By POST_REVIEW_PAGE_USABILITY_STAR4_PATH = By.xpath("//*[@id=\"star1\"]/img[4]");
    private static final By POST_REVIEW_PAGE_PRICING_RATING_PATH = By.xpath("//*[@id=\"star2\"]");
    private static final By POST_REVIEW_PAGE_PRICING_STAR3_PATH = By.xpath("//*[@id=\"star2\"]/img[3]");
    private static final By POST_REVIEW_PAGE_CONTRACT_RATING_PATH = By.xpath("//*[@id=\"star3\"]");
    private static final By POST_REVIEW_PAGE_CONTRACT_STAR2_PATH = By.xpath("//*[@id=\"star3\"]/img[2]");
    private static final By POST_REVIEW_PAGE_CUSTOMER_SERVICE_RATING_PATH = By.xpath("//*[@id=\"star4\"]");
    private static final By POST_REVIEW_PAGE_CUSTOMER_STAR1_PATH = By.xpath("//*[@id=\"star4\"]/img[1]");
    private static final By POST_REVIEW_PAGE_COMMENTS_PATH = By.xpath("//*[@id=\"text\"]");
    private static final By POST_REVIEW_POST_REVIEW_BUTTON_PATH = By.xpath("//*[@id=\"saveReviewForm\"]/fieldset/div[6]/a[1]");
    public static final By DISMISS_BUTTON = By.xpath("//div[contains(@class,'modal-footer')]/a[contains(@class,'btn-primary')]");
    public static final By SIGNUP_MODAL_NAME_FIELD = By.xpath("//*[@id=\"name\"]//div[contains(@class,'modal-body')]/input[contains(@class,'input-xlarge')]");




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
    public void testPostReviewButtons() {
        driver.get("http://tasq.starpathit.cloudbees.net");
        /*locateElement(driver,LOGIN_XPATH,2).click();
        LoginPageTest loginPageTests = new LoginPageTest();
        loginPageTests.login(driver);
        */searchByCategory(driver);
        List<WebElement> postReviewButtons = locateElements(driver, POST_REVIEW_BUTTON_PATH, 10);
        Assert.assertTrue(postReviewButtons.size() > 0);
        WebElement firstButton = postReviewButtons.get(0);

        Assert.assertNotNull(firstButton);
        Assert.assertEquals("Post review", firstButton.getText());
        firstButton.click();

        WebElement postReviewPageHeading = locateElement(driver, POST_REVIEW_PAGE_HEADING_PATH, 5);
        Assert.assertNotNull(postReviewPageHeading);
        Assert.assertTrue(postReviewPageHeading.getText().startsWith("Write Your Review On"));
        WebElement usabilityStar = locateElement(driver,POST_REVIEW_PAGE_USABILITY_STAR4_PATH,10);
        Assert.assertNotNull(usabilityStar);
        WebElement contractStar = locateElement(driver,POST_REVIEW_PAGE_CONTRACT_STAR2_PATH,10);
        Assert.assertNotNull(contractStar);
        WebElement pricingStar = locateElement(driver,POST_REVIEW_PAGE_PRICING_STAR3_PATH,10);
        Assert.assertNotNull(pricingStar);
        WebElement customerServiceStar = locateElement(driver,POST_REVIEW_PAGE_CUSTOMER_STAR1_PATH,10);
        Assert.assertNotNull(customerServiceStar);
        WebElement comments = locateElement(driver,POST_REVIEW_PAGE_COMMENTS_PATH,10);
        comments.sendKeys("Automation Review" + counter++);
        WebElement postReviewButton = locateElement(driver,POST_REVIEW_POST_REVIEW_BUTTON_PATH,10);
        usabilityStar.click();
        pricingStar.click();
        contractStar.click();
        customerServiceStar.click();
        postReviewButton.click();
        /*WebElement signUpModalDismissButton = locateElement(driver,DISMISS_BUTTON,5);
        Assert.assertNotNull(signUpModalDismissButton);
        signUpModalDismissButton.click();
      */
        WebElement signUpModalNameField = locateElement(driver,SIGNUP_MODAL_NAME_FIELD,5);

        Assert.assertNotNull(signUpModalNameField);
        signUpModalNameField.sendKeys("aa");

        //TODO verify the submit was successful



    }


    //this method is used by two tests
    public void searchByCategory(WebDriver driver) {
        // Find the text input element by its name
        WebElement element = locateElement(driver, By.xpath("/html/body/div[1]/div/div/div[2]/form/input"), 2);
        Assert.assertNotNull(element);

        // Enter something to search for
        element.sendKeys("accounting");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
    }


}
