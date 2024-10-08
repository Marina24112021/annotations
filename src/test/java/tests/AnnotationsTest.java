package tests;

import components.NamesOfMenu;
import components.OutPutResult;
import components.PageObjectMethod;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Hashtable;
import java.util.stream.Stream;

public class AnnotationsTest extends TestBase{
    PageObjectMethod pageObject = new PageObjectMethod();
    OutPutResult res = new OutPutResult();

    @Tag("WEB")
    @ParameterizedTest(name="Тест проверяет что список не пустой на тему {0}")
    @ValueSource( strings = {"Selenide" , "JUnit 5" , "Allure"})
    void checkTagForArticleTest(String whatTofind){
        pageObject.opendMainPage();
        pageObject.setValueToSearch(whatTofind);
        res.checkListIsNotEmpty();
    }

    @Tag("SMOKE")
    @CsvSource(value = {
            "Тестирование API | Как устроены API: разбираемся на примере REST API",
            "Тестирование UI | Как тестировщики проверяют, что программа делает то, что нужно",
            "Что такое тестирование | Как тестировщики проверяют, что программа делает то, что нужно"
    }, delimiter = '|')
    @ParameterizedTest(name="Тест проверяет поиск что на запрос по теме {0} есть статьи на сайте")
    void checkSearchButton(String inputStr, String outputStr){
        pageObject.opendMainPage();
        pageObject.setValueToSearch(inputStr);
        res.shouldCorrectSearch(outputStr);
    }

    static Stream<Arguments> selenideSiteShouldDisplayCorrectMenuButtons() {
        return Stream.of(
                Arguments.of(new NamesOfMenu()));
    }
    @MethodSource
    @Tag("SMOKE")
    @ParameterizedTest(name = "Тест по проветке меню. ")
    void selenideSiteShouldDisplayCorrectMenuButtons( NamesOfMenu namesOfMenu){
        pageObject.opendMainPage();
        Hashtable<String, String> tableOfMenu = namesOfMenu.getMenuAndDescription();
        tableOfMenu.forEach((key, value) -> {
            pageObject.getListOfMenuButtons(key);
            res.ShouldDisplayCorrectArticle(value);
        });
    }
}
