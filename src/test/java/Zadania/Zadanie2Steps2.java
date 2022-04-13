package Zadania;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.time.Duration;


public class Zadanie2Steps2 {
    private WebDriver driver;


    @Given("user logs on to website")
    public void userLogsOnToWebsite() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        signInButton.click();

        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"login-form\"]/section/div[1]/div[1]/input"));
        emailInput.sendKeys("zadaniekoncowe@pierwsze.com.pl");
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input"));
        passwordInput.sendKeys("adminadmin");
        WebElement signinButtonNextPage = driver.findElement(By.id("submit-login"));
        signinButtonNextPage.click();

        driver.findElement(By.xpath("//*[@id=\"category-3\"]/a")).click();
    }

    @When("user check a Hummingbird Printed Sweater product")
    public void userCheckAHummingbirdPrintedSweaterProduct() {
        WebElement clickASweater = driver.findElement(By.cssSelector("#js-product-list > div.products.row > article:nth-child(2) > div > div.product-description > h2 > a"));
        clickASweater.click();
    }

    @And("user check a Medium size")
    public void userCheckAMediumSize() {
        WebElement sizeInput = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
        sizeInput.clear();
        sizeInput.sendKeys("M");
    }

    @When("user chooses {int} item of product")
    public void userChoosesItemOfProduct(int arg0) {
        WebElement quantityInput =driver.findElement(By.id("quantity_wanted"));
        quantityInput.clear();
        quantityInput.sendKeys("5");


    }

    @And("user add a product to shopping cart")
    public void userAddAProductToShoppingCart() {
        WebElement addProductButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        addProductButton.click();
    }

    @When("user go to option checkout")
    public void userGoToOptionCheckout() {
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")).click();
    }

    @And("user confirm address")
    public void userConfirmAddress() {
      driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button")).click();
    }

    @When("user chooses payment option")
    public void userChoosesPaymentOption() {
        driver.findElement(By.id("delivery_option_1")).click();
        driver.findElement(By.xpath("//*[@id=\"js-delivery\"]/button")).click();
    }

    @And("user clicks on order with payment obligation")
    public void userClicksOnOrderWithPaymentObligation() {
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.xpath("//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();
    }

    @Then("user take a screenshot of order confirmation")
    public void userTakeAScreenshotOfOrderConfirmation() {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}