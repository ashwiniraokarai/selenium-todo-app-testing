package todomvc.acceptancetests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import todomvc.pageactions.ToDoPage;

public class BaseTest {
    WebDriver driver;
    ToDoPage toDoPage;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        toDoPage = new ToDoPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
