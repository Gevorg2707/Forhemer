package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ForhemerPage {
    public ForhemerPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    BasePage basePage;


    public void getForhemer() {
        basePage = new BasePage(driver);
        basePage.getUrl("https://forhemer.github.io/React-Todo-List/");
        basePage.checkPageTitle("React App");
    }

    public void addEl(int i) {
        basePage = new BasePage(driver);
        basePage.insertInto("css", "input[name=\"title\"]", "task" + i);
        basePage.clickOnElement("css", "button.input-submit");
    }

    public void ifCountOfElements() {
        basePage = new BasePage(driver);
        List<WebElement> elements = basePage.getElements("css", "li.TodoItem_item__iFWQW");
        int count = elements.size();
        System.out.println(count);
        Assert.assertEquals(count, 3);
    }

    public void clickOnCheckbox() {
        basePage = new BasePage(driver);
        List<WebElement> checkboxes = basePage.getElements("css", "input[type=\"checkbox\"]");
        if (!checkboxes.isEmpty()) {
            WebElement firstCheckbox = checkboxes.get(0);
            firstCheckbox.click();
        }
    }

    public void isTextStruckThrough() {
        basePage = new BasePage(driver);
        WebElement elemToCheck = basePage.getElement(
                "css",
                "span[style=\"font-style: italic; color: " +
                        "rgb(89, 89, 89); opacity: 0.5; " +
                        "text-decoration: " +
                        "line-through;\"]");
        String textDecortaion = elemToCheck.getCssValue("text-decoration");
        System.out.println(textDecortaion);
        Assert.assertEquals(textDecortaion, "line-through solid rgb(89, 89, 89)");
    }

    public void deleteEl() {
        basePage = new BasePage(driver);
        List<WebElement> deleteElements = basePage.getElements("css", "button[type=\"button\"]");
        WebElement firstEL = deleteElements.get(0);
        firstEL.click();
    }

    public void checkDeleteEl() {
        basePage = new BasePage(driver);
        List<WebElement> deleteElements = basePage.getElements("css", "button[type=\"button\"]");
        Assert.assertEquals(deleteElements.size(), 2);
    }
}
