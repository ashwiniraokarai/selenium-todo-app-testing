package todomvc.pageselectors;

import org.openqa.selenium.By;

/*
    Houses Selectors (in the form of By Objects) to help locate WebElements
    Typically accessed by pageactions

    By designing your methods to return a By object instead of a WebElement:
    You eliminate the need to receive and access the driver in this class.
    Plus you get to make these methods static

*/
public class ToDoPageSelectors {

    public static By TODO_INPUTBOX(){
        return By.cssSelector(".new-todo");
    }

    public static By LIST_OF_TODO_ITEMS() {
        return By.cssSelector("ul.todo-list li");
    }
}
