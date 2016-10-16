package pages;

import Util.WaitUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sadiq on 16/10/16.
 */
public class ProductDetailsPage extends BasePage{

    /**
     * Product Details Page Elements
     */

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    public WebElement breadCrumbHomeLink;

    @FindBy(xpath = "//h1")
    public WebElement productTitle;

    @FindBy(xpath = ".//div[@class='_1vC4OE _37U4_g']")
    public WebElement productPrice;

    @FindBy(id = "sellerName")
    public WebElement productSellerName;


    /**
     * Methods for the Product Details Page
     */


    public void init(){
        PageFactory.initElements(driver, this);
    }


    public void validateProductTitleExists(){
        WaitUtil.sleep(1000);
        productTitle.isDisplayed();
        WaitUtil.sleep(100);
    }

    public void validateProductPriceExists(){
        WaitUtil.sleep(2000);
        productPrice.isDisplayed();
        WaitUtil.sleep(100);
    }

    public void validateProductSellerNameExists(){
        WaitUtil.sleep(1000);
        productSellerName.isDisplayed();
        WaitUtil.sleep(100);
    }


}
