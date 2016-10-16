package Util;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import scenarios.BaseTest;

/**
 * Created by sadiq on 15/10/16.
 */
public class BaseUtil {

    private static Logger _log = LoggerFactory.getLogger(BaseTest.class);

    protected static WebDriver driver = BasePage.driver;


    public static String getPageSource() {
        return driver.getPageSource();
    }

    public static boolean checkPageSourceContains(String text) {
        return getPageSource().contains(text);
    }




}
