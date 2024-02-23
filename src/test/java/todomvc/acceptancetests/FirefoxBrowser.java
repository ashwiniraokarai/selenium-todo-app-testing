package todomvc.acceptancetests;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FirefoxBrowser implements BrowserDriver {

    @Override
    public RemoteWebDriver configure() throws MalformedURLException {
        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, fireFoxOptions());
        return driver;
    }

    private FirefoxOptions fireFoxOptions() {
        FirefoxOptions browserOptions = new FirefoxOptions();
        browserOptions.setPlatformName("macOs 13");
        browserOptions.setBrowserVersion("latest");
        browserOptions.setCapability("sauce:options", sauceOptions());

        return browserOptions;
    }

    private Map<String, Object> sauceOptions() {
        Map<String, Object> sauceOptionsMap = new HashMap<>();
        sauceOptionsMap.put("username", System.getenv("SAUCE_USERNAME"));
        sauceOptionsMap.put("accessKey", System.getenv("SAUCE_ACCESS_KEY"));

        return sauceOptionsMap;
    }
}
