package Zadania;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    private WebDriver driver;
    @FindBy (xpath ="//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")
    private WebElement alias;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/form/section/div[6]/div[1]/input")
    private WebElement address;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")
    private WebElement city;

    @FindBy (xpath ="//*[@id=\"content\"]/div/div/form/section/div[9]/div[1]/input")
    private WebElement zip;

    @FindBy (xpath = "//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select")
    private WebElement country;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/form/section/div[11]/div[1]/input")
    private WebElement phone;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void fillAddress(String alias, String address, String city, String zip, String country, String phone){
        this.alias.sendKeys(alias);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.zip.sendKeys(zip);
        this.country.sendKeys(country);
        this.phone.sendKeys(phone);
    }
}
