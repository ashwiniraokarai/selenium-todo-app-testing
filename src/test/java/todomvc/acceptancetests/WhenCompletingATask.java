package todomvc.acceptancetests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import todomvc.pageactions.ToDoPage;

public class WhenCompletingATask {
    private ToDoPage toDoPage;
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        toDoPage = new ToDoPage(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    // TODO: Exercise 3
    @Test
    public void activeTasksShouldNotShowCompletedTasks() {
        // Add "Feed the cat" and "Walk the dog" to the list
        // Complete "Feed the cat"
        // Filter by "Active"
        // Check that only "Walk the dog" appears

        toDoPage.openToDoApp();
        toDoPage.addItemsCalled("Feed the cat", "Walk the dog");
        toDoPage.completeItemCalled("Feed the cat");
        toDoPage.filterBy("Active");

        Assertions.assertThat(toDoPage.listOfTextsOfToDoItems()).containsExactly("Walk the dog");
    }

    // TODO: Exercise 4
    @Test
    public void completedTasksShouldNotShowActiveTasks() {
        // Add "Feed the cat" and "Walk the dog" to the list
        // Complete "Feed the cat"
        // Filter by "Completed"
        // Check that only "Feed the cat" appears

        toDoPage.openToDoApp();
        toDoPage.addItemsCalled("Feed the cat", "Walk the dog");
        toDoPage.completeItemCalled("Feed the cat");
        toDoPage.filterBy("Completed");

        Assertions.assertThat(toDoPage.listOfTextsOfToDoItems()).containsExactly("Feed the cat");
    }
}
