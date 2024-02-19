package todomvc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import todomvc.pageselectors.ToDoPageSelectors;

import java.util.List;

/*
    Methods that wrap over selenium methods for better code readability and separation of concerns
    Callers of these methods are pageactions
*/

public class SeleniumWrapper {
    private  WebDriver driver;

    public SeleniumWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url){
        driver.get(url);
    }

    public WebElement getWebElementFor(By selector){
        return driver.findElement(selector);
    }

    public List<WebElement> getWebElementsFor(By selector){
        return driver.findElements(selector);
    }
}
