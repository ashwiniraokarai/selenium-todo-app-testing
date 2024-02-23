package todomvc.acceptancetests;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public interface BrowserDriver {
    public RemoteWebDriver configure() throws MalformedURLException;
}
