package Zadania;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Zadanie1Steps {
    private WebDriver driver;

    @Given("user is logged into website")
    public void userIsLoggedIntoWebsite() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
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

    }

    @When("user clicks an Addresses button")
    public void userClicksAnAddressesButton() {
        WebElement addressesButton = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span"));
        addressesButton.click();

    }

    @And("user clicks an Create new address button")
    public void userClicksAnCreateNewAddressButton() {
        WebElement createnewAddressButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span"));
        createnewAddressButton.click();
    }

    @When("user fills form with data {string}, {string}, {string}, {string},{string}, {string}")
    public void userFillsFormWithData(String alias, String address, String city, String zip, String country, String phone) {


        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillAddress(alias, address, city, zip, country, phone);

    }

    @Then("user add a new address")
    public void userAddANewAddress() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button")).click();
    }

    @And("user check correctness of fills form")
    public void userCheckCorrectnessOfFillsForm() {
        WebElement alert = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article"));
        Assertions.assertTrue(alert.isDisplayed());

    }
}
