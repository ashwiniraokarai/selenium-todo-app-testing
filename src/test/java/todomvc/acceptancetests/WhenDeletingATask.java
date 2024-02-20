package todomvc.acceptancetests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import todomvc.pageactions.ToDoPage;

public class WhenDeletingATask extends BaseTest{
    // Set up and tear down methods offloaded to a BaseTest which manages driver object and page object

    // TODO: Exercise 5
    @Test
    public void deletedItemsShouldDisappearFromTheList() {
        // Add "Feed the cat" and "Walk the dog" to the list
        // Delete "Feed the cat"
        // Check that only "Walk the dog" appears
        toDoPage.openToDoApp();
        toDoPage.addItemsCalled("Feed the cat", "Walk the dog");
        toDoPage.removeItemCalled("Feed the cat");

        Assertions.assertThat(toDoPage.listOfTextsOfToDoItems()).containsExactly("Walk the dog");
    }
}
