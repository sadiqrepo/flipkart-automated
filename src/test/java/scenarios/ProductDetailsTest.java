package scenarios;

import Util.LogUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;

/**
 * Created by sadiq on 16/10/16.
 */
public class ProductDetailsTest {

    String sTestCaseName = this.getClass().getSimpleName().trim();
    //LoginPage loginPage = new LoginPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();


    @BeforeClass
    public void init() {


        productDetailsPage.init();
        LogUtil.info("Before Login");
        LogUtil.startTestCase(sTestCaseName);

    }


    @Test(description = "productDetailsPage")
    public void productDetailsPage(){
        productDetailsPage.validateProductTitleExists();
        productDetailsPage.validateProductPriceExists();
        productDetailsPage.validateProductSellerNameExists();
    }

}
