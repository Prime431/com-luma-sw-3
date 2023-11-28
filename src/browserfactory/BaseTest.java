package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    static String browser = "Chrome"; //selecting Browser
    public static WebDriver driver; // defining webDriver

    public void openBrowser(String baseUrl) { //using if else for choosing the browser
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong driver name");
        }
        driver.get(baseUrl); //launching the browser
        driver.manage().window().maximize(); //Maximise the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Implicit the time
    }
    public void closeBrowser() {
        driver.quit(); //closing the browser
    }
}


