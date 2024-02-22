package todomvc.acceptancetests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import todomvc.pageactions.ToDoPage;

import java.util.stream.Stream;

public class BaseTest {
    WebDriver driver;
    ToDoPage toDoPage;

    @BeforeEach
    public void setUp(){
        this.driver = new ChromeDriver();
        toDoPage = new ToDoPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    //Method source for each Test method in the Child Test Classes
    //This base class does not use this method
    public static Stream<Arguments> browserDriverProvider() {
        return Stream.of(
                Arguments.of(new ChromeDriver()),
                Arguments.of(new FirefoxDriver())
        );
    }
}
