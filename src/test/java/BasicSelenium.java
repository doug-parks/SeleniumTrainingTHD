import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

/**
 * Created by djp4830 on 5/16/17.
 */
public class BasicSelenium {
    //instantiate the utilities class
    SeleniumUtils utils = new SeleniumUtils();

    //All my DOM objects
    public static final String HOME_PAGE = "http://www.homedepot.com";
    public static final String SEARCHBOX = ".//*[@id='headerSearch']";
    public static final String SEARCHBUTTON = ".//*[@id='headerSearchButton']";
    public static final String LANDING_PAGE = ".//span[@class='original-keyword " +
            "u__regular' and contains(text(),'hammer')]";



    @Test
    public void openBrowser() {

        String item = "hammer";

        Assert.assertTrue("Could not validate main page.", utils.navigateURL(HOME_PAGE));
        Assert.assertTrue("Could not validate search box", utils.validateTextBox(SEARCHBOX));
        Assert.assertTrue("Could not enter text into search box", utils.enterTextIntoTextBox(SEARCHBOX, "hammer"));
        Assert.assertTrue("Could not validate search button", utils.validateButton(SEARCHBUTTON));
        Assert.assertTrue("Could not validate landing page", utils.verifyLandingPage(LANDING_PAGE));

        utils.driver.close();
    }
}
