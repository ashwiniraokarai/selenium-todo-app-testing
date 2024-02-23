package todomvc.acceptancetests.crossbrowsertests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import todomvc.acceptancetests.BaseTest;
import todomvc.pageactions.ToDoPage;

//The individual Test Methods is parameterized to run on different driver types, sequentially
//The JUnit concurrency execution mode annotation powers  the iterations to run in parallel as opposed to sequential
@Execution(ExecutionMode.CONCURRENT)
public class LocalCrossBrowserAndParallelTesting extends BaseTest {
    ToDoPage toDoPage;

    @Override
    @BeforeEach
    public void setUp(){
        //Do nothing for now. Cross browser testing is powered by ParameterizedTest directly.
    }

    @Override
    @AfterEach
    public void tearDown(){
        //Do nothing for now. Cross browser testing is powered by ParameterizedTest directly.
    }

    @ParameterizedTest
    @MethodSource("browserDriverProvider")
    public void addingASingleTask(WebDriver driver) {
        toDoPage = new ToDoPage(driver);
        // Add "Feed The Cat" to the list
        // Check that "Feed The Cat" appears in the list

        toDoPage.openToDoApp();
        toDoPage.addItemCalled("Feed the cat");

        Assertions.assertThat(toDoPage.listOfTextsOfToDoItems()).contains("Feed the cat");

        driver.quit();
    }
}
