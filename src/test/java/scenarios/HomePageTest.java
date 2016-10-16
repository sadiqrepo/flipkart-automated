package scenarios;

import Util.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

/**
 * Created by sadiq on 16/10/16.
 */
public class HomePageTest extends BaseTest {

    String sTestCaseName=this.getClass().getSimpleName().trim();
    //LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();




    @BeforeClass
    public void init(){

        //loginPage.login();
        homePage.init();
        LogUtil.info("Before Login");
        LogUtil.startTestCase(sTestCaseName);

    }

    @Test(description = "Validate Header components",priority = 0)
    public void validateHeaderComponents(){
        homePage.verifyHeaderComponentsDisplayed();
    }


    @Test(description = "Validate Footer components",priority = 1)
    public void validateFooterComponents(){
        homePage.verifyFooterComponentsDisplayed();
    }

    @Test(description = "Search for a Product",priority = 2)
    public void searchProduct(){
        homePage.productSearch();
        WaitUtil.sleep(500);
        AssertUtil.assertTruePageText("rucksack", "Text not present");
    }

    @Test(description = "LeftRail Filters ",priority = 3)
    public void leftRailFiltersExists(){
        homePage.filterByCategoryTitle();
        homePage.filterByPriceTitle();
    }

    @Test(description = "Navigate to product details page", priority = 4)
    public void clickOnProductLink(){
        homePage.clickProductLink();
    }







}
