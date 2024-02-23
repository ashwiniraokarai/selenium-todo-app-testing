package todomvc.acceptancetests.crossbrowsertests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import todomvc.acceptancetests.BaseTest;
import todomvc.pageactions.ToDoPage;

import java.net.MalformedURLException;

//The individual Test Method can be  parameterized to run on different driver types, sequentially
//The JUnit concurrency execution mode annotation can power  the iterations to run in parallel as opposed to sequential
//@Execution(ExecutionMode.CONCURRENT)
public class SauceLabsCrossBrowserTesting extends BaseTest {
    RemoteWebDriver driver;
    ToDoPage toDoPage;

    @Override
    @BeforeEach
    public void setUp(){
        //Do nothing for now. Cross browser testing is powered by ParameterizedTest directly.
    }

    @Override
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void addingASingleTask() throws MalformedURLException {
        driver = remoteDriverForSauceLabsOn("Chrome");
        toDoPage = new ToDoPage(driver);
        // Add "Feed The Cat" to the list
        // Check that "Feed The Cat" appears in the list

        toDoPage.openToDoApp();
        toDoPage.addItemCalled("Feed the cat");

        Assertions.assertThat(toDoPage.listOfTextsOfToDoItems()).contains("Feed the cat");

        driver.quit();
    }

    @Test
    public void addingMultipleTasks() throws MalformedURLException {
        driver = remoteDriverForSauceLabsOn("Firefox");
        toDoPage = new ToDoPage(driver);

        // Add "Feed The Cat" and "Walk the dog" to the list
        // Check that they all appear in the list
        toDoPage.openToDoApp();
        toDoPage.addItemsCalled("Feed the cat", "Walk the dog");

        Assertions.assertThat(toDoPage.listOfTextsOfToDoItems())
                .containsExactly("Feed the cat", "Walk the dog");
    }
}
