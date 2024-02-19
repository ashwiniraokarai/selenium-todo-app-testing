package todomvc.pageactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import todomvc.SeleniumWrapper;
import todomvc.pageselectors.ToDoPageSelectors;

import java.util.List;
import java.util.stream.Collectors;

public class ToDoPage extends SeleniumWrapper {
    private  WebDriver driver;
    public ToDoPage(WebDriver driver) {
        super(driver);
       // this.driver = driver;
    }

    public void openToDoApp() {
        openPage("https://todomvc.com/examples/angular/dist/browser/#/all");
    }

    public void addItemCalled(String toDoText) {
        //With call to a static  method, that returns a By Object
        getWebElementFor(ToDoPageSelectors.TODO_INPUTBOX()).sendKeys(toDoText);
        getWebElementFor(ToDoPageSelectors.TODO_INPUTBOX()).sendKeys(Keys.RETURN);
    }

    public List<String> listOfTextsOfToDoItems() {
        return  getWebElementsFor(ToDoPageSelectors.LIST_OF_TODO_ITEMS()).stream()
                .map(toDoItem -> toDoItem.getText())
                .collect(Collectors.toList());
    }

    public void addItemsCalled(String... texts) {
        for(String text: texts){
            addItemCalled(text);
        }
    }

    public void completeItemWith(String text) {
        //click on the checkbox associated the todo item to complete
        getWebElementFor(ToDoPageSelectors.TODO_ITEM_CHECKBOX(text)).click();
    }

    public void filterBy(String linkText) {
        //click on the filter
        getWebElementFor(ToDoPageSelectors.FILTER_LINK(linkText)).click();
    }
}
