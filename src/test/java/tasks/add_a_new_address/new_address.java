package tasks.add_a_new_address;

import common.utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class new_address {

    private WebDriver driver;
    private Select SelectByValue;

    @Given("user is logged in to Presta-Shop")
    public void userIsLoggedInToPrestaShop() {
        driver = utils.openChromeAndLoginInPrestaShop();
    }

    @When("user goes to Addresses")
    public void userGoesToAddresses() {
        WebElement addresses = driver.findElement(By.cssSelector("a[title='Addresses']"));
        addresses.click();
    }

    @And("user clicks add new address")
    public void userClicksAddNewAddress() {
        WebElement createNewAddress = driver.findElement(By.cssSelector("a[data-link-action='add-address']"));
        createNewAddress.click();
    }

    @Then("user fills {string} as Alias, {string} as Address, {string} as Zip, {string} as City, {string} as Phone")
    public void userFillsAddressData(String Alias, String Address, String Zip, String City, String Phone) {
        driver.findElement(By.name("alias")).sendKeys(Alias);
        driver.findElement(By.name("address1")).sendKeys(Address);
        driver.findElement(By.name("postcode")).sendKeys(Zip);
        driver.findElement(By.name("city")).sendKeys(City);
        SelectByValue = new Select(driver.findElement(By.name("id_country")));
        SelectByValue.selectByValue("17");
        driver.findElement(By.name("phone")).sendKeys(Phone);
    }
    @And("user clicks 'Save' button")
    public void userClicksSaveButton(){
        driver.findElement(By.cssSelector("button.btn-primary.float-xs-right")).click();
    }
    @Then("{string} is displayed")
    public void userSeesMessage(String message){
        String successAlertText = driver.findElement(By.id("notifications")).getText();
        Assertions.assertEquals(message, successAlertText, "Error!");
    }
}