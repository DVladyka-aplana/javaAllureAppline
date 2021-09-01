package steps;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestProperties;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BaseSteps {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }
    @Step("<<<Проверка на наличие всплывающего сообщения Cookies>>>")
    public void checkCookieButton() {
        if (!driver.findElements(By.xpath("//div[contains(@class,'kitt-cookie-warning')][contains(@style,'display: block;')]//button[contains(@class,'kitt-cookie-warning__close')]")).isEmpty()) {
            driver.findElement(By.xpath("//button[contains(@class,'kitt-cookie-warning__close')]")).click();
        }
    }
    @Step("Проверка заголовка - {2}")
    public void checkHead(By by, int seconds, String exp){
        Wait<WebDriver> wait = new WebDriverWait(driver, seconds, 1000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        assertEquals(exp,driver.findElement(by).getText());
    }
    @Before
    public void startScenario(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.sberbank.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void afterMethod(){
        driver.quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
