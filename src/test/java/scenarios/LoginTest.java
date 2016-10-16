package scenarios;

import Util.*;
import Util.DataUtil.LoginDataUtil;
import org.testng.annotations.*;
import pages.LoginPage;

/**
 * Created by sadiq on 15/10/16.
 */
public class LoginTest extends BaseTest{

    String sTestCaseName=this.getClass().getSimpleName().trim();
    LoginPage loginPage = new LoginPage();



    @BeforeClass
    public void init(){

        loginPage.init();
        LogUtil.info("Before Login");
        LogUtil.startTestCase(sTestCaseName);
    }

    @Test(description = "Native App LoginPage Displayed",priority = 0)
    public void testLoginPageDisplayed(){

        loginPage.openWebApp();
        loginPage.loginOverlayIsDisplayed();
        loginPage.closeLoginOverlay();
    }

    @Test(dataProvider="userLogin",description = "Successful Login",priority = 1)
        public void testLoginSuccess(String userName, String password) throws Exception{
        try {
            loginPage.openWebApp();
            loginPage.loginOverlayIsDisplayed();
            loginPage.login(userName, password);
            AssertUtil.assertTruePageText("Hi", "Text not present");
            LogUtil.info("Successfully Logged In");
        }catch (IllegalStateException e){
            LogUtil.error(e.getMessage());
        }catch (NullPointerException e){
            LogUtil.error(e.getMessage());
        }
    }

    @DataProvider

    public Object[][] userLogin() throws Exception{

        Object[][] arrayExcelData = LoginDataUtil.getTableArray("/Users/sadiq/logistimo-assessment/src/test/resources/testdata.xls", "Sheet1");

        return arrayExcelData;

    }




/*
    @AfterClass
    protected void tearDown(){

        // Close the app

        selenium.quit();
        LogUtil.info("After Quit");
    }*/
}
