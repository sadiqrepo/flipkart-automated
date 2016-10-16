package scenarios;


import Util.ConfigReader;
import Util.ConfigWriter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;



/**
 * Created by sadiq on 15/10/16.
 */
public class BaseTest {

    protected BasePage selenium;

    @BeforeSuite
    public void init() {
        selenium = BasePage.getInstance();
    }

    @BeforeSuite
    public void Config() {
        ConfigWriter.setPropertyValue("logger.file", "webLogger", ConfigReader.get("config.path"));
    }
}
