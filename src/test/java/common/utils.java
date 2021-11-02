package common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class utils {

    public static WebDriver openChromeAndLoginInPrestaShop() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        WebElement signIn = driver.findElement(By.id("_desktop_user_info"));
        signIn.click();

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("brodie1@freeallapp.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("qwerty1234");

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();
        return driver;
    }
    public static void screenShot(WebDriver webdriver, String pathToFile) throws Exception {
        TakesScreenshot screenshot = ((TakesScreenshot) webdriver);
        File screen = screenshot.getScreenshotAs(OutputType.FILE);
        File file = new File(pathToFile);
        FileHandler.copy(screen,file);
    }
}

