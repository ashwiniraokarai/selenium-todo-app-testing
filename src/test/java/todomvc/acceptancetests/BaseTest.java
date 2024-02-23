package todomvc.acceptancetests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import todomvc.pageactions.ToDoPage;

import java.net.MalformedURLException;
import java.util.stream.Stream;

public class BaseTest {
    WebDriver driver;
    ToDoPage toDoPage;

    @BeforeEach
    public void setUp() {
        this.driver = new ChromeDriver();
        toDoPage = new ToDoPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }



    //Method source for each Test method in the Child Test Classes
    //This base class does not use this method
    public static Stream<Arguments> browserDriverProvider() {
        return Stream.of(
                Arguments.of(new ChromeDriver()),
                Arguments.of(new FirefoxDriver())
        );
    }


    /*
    * SAUCE LABS
    * */
    //Method to connect to SauceLabs and run tests
    //Called by at least by one child test. Not called within this BaseTest.
    public RemoteWebDriver remoteDriverForSauceLabsOn(String browserName) throws MalformedURLException {
        BrowserDriver browserDriver = getRemoteDriverForBrowser(browserName);
        return browserDriver.configure();
    }

    private BrowserDriver getRemoteDriverForBrowser(String browserName) {
        switch(browserName){
            case "Firefox": return new FirefoxBrowser();
            case "Chrome":
            default: return new ChromeBrowser();
        }
    }
}
