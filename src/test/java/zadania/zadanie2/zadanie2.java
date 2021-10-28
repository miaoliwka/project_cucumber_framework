package zadania.zadanie2;

import common.utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class zadanie2 {

    private WebDriver driver;
    private Select SelectByValue;

    @Given("user logged in to Presta-Shop")
    public void userLoggedInToPrestaShop() {
        driver = utils.openChromeAndLoginInPrestaShop();
    }
    @When("user clicks 'clothes' button")
    public void userClicksClothesButton(){
        driver.findElement(By.id("category-3")).click();
    }
    @And("user selects product Hummingbird Printed Sweater")
    public void userSelectsSweater(){
        driver.findElement(By.xpath("//img[@alt='Brown bear printed sweater']")).click();
    }
    @And("user clicks 'size' button and selects 'm' size")
    public void userClicksSizeButton(){
        driver.findElement(By.id("group_1")).click();
        SelectByValue = new Select(driver.findElement(By.id("group_1")));
        SelectByValue.selectByValue("2");
    }
    @And("user selects five items")
    public void userSelectsFiveItems(){
        WebElement click5 = driver.findElement(By.id("quantity_wanted"));
        click5.click();
        click5.clear();
        click5.sendKeys("5");
    }
    @When("user adds product to cart and clicks 'proceed to checkout' twice")
    public void userAddsProductToCartAndChooseCheckoutOption(){
        driver.findElement(By.cssSelector("button.btn.btn-primary.add-to-cart")).click();

        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
    }
    @And("user confirm address by 'continue' button")
    public void userConfirmAddress() {
        driver.findElement(By.cssSelector("button.btn.btn-primary.continue.float-xs-right")).click();
    }
    @And("user selects shipping method 'pick up in store' and clicks 'continue' button")
    public void shippingMethodPickUpInStore(){
        WebElement pickUpInStoreCheckbox = driver.findElement(By.id("delivery_option_1"));
        if(!pickUpInStoreCheckbox.isSelected())
            pickUpInStoreCheckbox.click();

        driver.findElement(By.name("confirmDeliveryOption")).click();
    }
    @And("user selects payment option 'pay by check' and agree the terms")
    public void paymentOptionPayByCheck(){
        driver.findElement(By.id("payment-option-1")).click();

        WebElement termsCheckbox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        if(!termsCheckbox.isSelected())
            termsCheckbox.click();
    }
    @And("user clicks 'order with an obligatory to pay' button")
    public void orderWithAnObligatoryToPayButton(){
        driver.findElement(By.cssSelector("button.btn.btn-primary.center-block")).click();
    }
    @Then("user makes order screenshot")
    public void userMakesOrderScreenshot(){
        String filePath = "screenOfOrder" + System.currentTimeMillis() + ".jpg";
        try {
            utils.screenShot(driver, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
