import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by djp4830 on 5/17/17.
 */
public class SeleniumUtils {

    public static final int MAX_TIME = 10;
    public WebDriver driver;
    public static final String DRIVER_PATH = "/Users/djp4830/Documents/Selenium/chromedriver";

    SeleniumUtils() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public boolean navigateURL(String url) {
        try {
            driver.get(url);
            System.out.println("Validated successful navigation to " + url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitElementDisplayed(String element) {
        int counter = 0;
        do {
            if (driver.findElement(By.xpath(element)).isDisplayed()) {
                return true;
            }
            syncElement("SECONDS", 1);
            counter++;
        } while (counter < MAX_TIME);
        return false;
    }

    public boolean verifyLandingPage(String xpath) {
        if (driver.findElement(By.xpath(xpath)).isDisplayed()) {
            System.out.println("landing page validated. xpath (" + xpath + ") was found!");
            return true;

        }

        return false;
    }


    public boolean validateButton(String element) {
        if (waitElementDisplayed(element)) {

            try {
                syncElement("MILLISECONDS", 100);
                driver.findElement(By.xpath(element)).click();
                System.out.println("Validated that the button is present and clickable");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public void syncElement(String time, int amount) {

        try {
            switch (time) {
                case "MILLI":
                case "MILLISECONDS":
                    TimeUnit.MILLISECONDS.sleep(amount);
                    break;
                case "SEC":
                case "SECONDS":
                    TimeUnit.SECONDS.sleep(amount);
                    break;
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    public boolean validateTextBox(String element) {
        if (waitElementDisplayed(element)) {
            System.out.println("Text box has been validated as visible");
            return true;
        }
        return false;
    }

    public boolean enterTextIntoTextBox(String element, String text) {
        if (waitElementDisplayed(element)) {
            try {
                syncElement("MILLISECONDS", 100);
                driver.findElement(By.xpath(element)).sendKeys(text);
                System.out.println("Text has been entered successfully");
                return true;
            } catch (Exception e) {

                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
