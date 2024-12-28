package com.roadreadywheels.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.roadreadywheels.utils.PropertyReader;

public final class WebDriverProvider {

    private WebDriverProvider() {
    }

    public static WebDriver driver;

    public static WebDriver getWebDriver() {
        String browserName = PropertyReader.getConfigProperty("browserName");

        if (driver == null) {
            switch (browserName.toLowerCase()) {
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                   
                    // firefoxOptions.addArguments("--headless");          // Run Firefox in headless mode
                    // firefoxOptions.addArguments("--width=1920");        // Set window width
                    // firefoxOptions.addArguments("--height=1080");       // Set window height
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
//                    chromeOptions.addArguments("--headless");           // Run Chrome in headless mode
//                    chromeOptions.addArguments("--disable-gpu");        // Disable GPU for headless mode
//                    chromeOptions.addArguments("--window-size=1920,1080"); // Set window size
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "ie":
                    driver = new InternetExplorerDriver();
                    break;

                default:
                    // Default to Chrome with headless mode
                    ChromeOptions defaultOptions = new ChromeOptions();
//                    defaultOptions.addArguments("--headless");
//                    defaultOptions.addArguments("--disable-gpu");
//                    defaultOptions.addArguments("--window-size=1920,1080");
                    driver = new ChromeDriver(defaultOptions);
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}