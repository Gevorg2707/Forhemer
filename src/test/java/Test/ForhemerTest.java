package Test;

import Base.SeleniumBase;
import Page.BasePage;
import Page.ForhemerPage;

import org.testng.annotations.Test;

public class ForhemerTest extends SeleniumBase {
    BasePage basePage;
    ForhemerPage forhemerPage;

    @Test
    public void ForhemTest() {
        basePage = new BasePage(driver);
        forhemerPage = new ForhemerPage(driver);
        forhemerPage.getForhemer(); // Шаг 1: Перейти на сайт
        for (int i = 1; i <= 3; i++) {
            forhemerPage.addEl(i); // Шаг 2: Добавить элемент
        }
        forhemerPage.ifCountOfElements(); // Шаг 3: Проверить количество элементов
        forhemerPage.clickOnCheckbox(); // Шаг 4: Выбрать первий чекбокс
        forhemerPage.isTextStruckThrough(); // Шаг 5: Проверить текст
        forhemerPage.deleteEl();// Шаг 6: Удалить элемент
        forhemerPage.checkDeleteEl();// Шаг 7: Проверить удаление
    }

}
