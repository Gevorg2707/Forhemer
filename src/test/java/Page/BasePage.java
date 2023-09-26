package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public By getByType(String locatorType, String locator){
        if (locatorType.toLowerCase(Locale.ROOT).equals("css")){
            return By.cssSelector(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("xpath")) {
            return By.xpath(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("id")){
            return By.id(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("name")){
            return By.name(locator);
        } else if (locatorType.toLowerCase(Locale.ROOT).equals("text")){
            return By.linkText(locator);
        } else {
            return null;
        }
    }

    public WebElement getElement(String locatorType, String locator) {
        WebElement elem = null;
        try {
            By byType = getByType(locatorType, locator);
            elem = driver.findElement(byType);
            return elem;
        } catch (Exception e) {
//            helpers.loging().error("Unable to get " + locator + " element from Dom");
        }
        return elem;
    }


    public List<WebElement> getElements(String locatorType, String locator){
        By byType = getByType(locatorType, locator);
        List<WebElement> elems = driver.findElements(byType);
        return elems;
    }

    public void clickOnElement(String locatorType, String locator){
        getElement(locatorType, locator).click();
    }

    public void insertInto(String locatorType, String locator, String text){
        WebElement elem = getElement(locatorType, locator);
        elem.clear();
        elem.sendKeys(text);
    }
    public void checkPageTitle(String expectedTitle) {
        Assert.assertTrue(driver.getTitle().equals(expectedTitle));
    }

    public boolean customTry(String locatorType, String locator) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 5) {
            try {
                getElement(locatorType, locator).click();
                result = true;
                break;
            } catch (Exception e) {
            }
            attempts++;
        }
        return result;
    }
    public void delay(int seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    public void getUrl(String URL){
        driver.get(URL);
    }
}
