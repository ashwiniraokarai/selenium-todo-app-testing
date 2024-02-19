package todomvc.acceptancetests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import todomvc.pageactions.ToDoPage;

public class WhenAddingTasks {
    private ToDoPage toDoPage;
    WebDriver driver;
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        toDoPage = new ToDoPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    // TODO: Exercise 1
    @Test
    public void addingASingleTask() {
        // Add "Feed The Cat" to the list
        // Check that "Feed The Cat" appears in the list

        toDoPage.openToDoApp();
        toDoPage.addItemCalled("Feed the cat");

        Assertions.assertThat(toDoPage.listOfTextsOfToDoItems()).contains("Feed the cat");
    }

    // TODO: Exercise 2
    @Test
    public void addingMultipleTasks() {
        // Add "Feed The Cat" and "Walk the dog" to the list
        // Check that they all appear in the list

        toDoPage.openToDoApp();
        toDoPage.addItemsCalled("Feed the cat", "Walk the dog");

        Assertions.assertThat(toDoPage.listOfTextsOfToDoItems())
                                                                    .containsExactly("Feed the cat", "Walk the dog");
    }
}
