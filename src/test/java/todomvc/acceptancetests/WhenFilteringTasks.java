package todomvc.acceptancetests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import todomvc.pageactions.ToDoPage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
* Write a data-driven test to test the following scenarios:
When you add the items "Feed the cat" and "Walk the dog", and complete "Feed the cat", and then filter by "Completed", you should only see "Feed the cat"
When you add the items "Feed the cat" and "Walk the dog", and complete "Feed the cat", and then filter by "Active", you should only see "Walk the dog"
When you add the items "Feed the cat" and "Walk the dog", and complete "Feed the cat", and then filter by "All", you should all the items
*
* */
public class WhenFilteringTasks {

    private WebDriver driver;
    private ToDoPage toDoPage;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        toDoPage = new ToDoPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @ParameterizedTest(name="Complete task: {0},Filter by {1}, See tasks: {2}")
    @MethodSource("testDataProvider")
    public void canFilterByTaskStatus(String toDoItemToComplete, String filterLinkText, List<String> expectedToDoItems){
        toDoPage.openToDoApp();
        toDoPage.addItemsCalled("Feed the cat", "Walk the dog");
        toDoPage.completeItemCalled(toDoItemToComplete);

        toDoPage.filterBy(filterLinkText);

        Assertions.assertThat(toDoPage.listOfTextsOfToDoItems()).isEqualTo(expectedToDoItems);
    }

/* Return a Stream of Arguments
     Each Argument is a container for a set of String arguments (like a row of data in a csv source with each cell representing one argument)
     Each String is consumed as a parameter on the receiving end (by the Test Method), row by row
 */
    public static Stream<Arguments> testDataProvider(){
        return Stream.of(
                Arguments.of("Feed the cat", "Completed", Arrays.asList("Feed the cat") ),
                Arguments.of("Feed the cat", "Active", Arrays.asList("Walk the dog") ),
                Arguments.of("Feed the cat", "All", Arrays.asList("Feed the cat", "Walk the dog" ))
        );
    }
}
