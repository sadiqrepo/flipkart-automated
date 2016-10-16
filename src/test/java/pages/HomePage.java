package pages;

import Util.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sadiq on 16/10/16.
 */
public class HomePage extends BasePage {

    public static String PRODUCT_NAME = "rucksack";

    /** Header Components
     * UI Elements
     */

    @FindBy(xpath = "//span[contains(text(),'Electronics')]")
    public WebElement electronicsDropDown;

    @FindBy(xpath = "//span[contains(text(),'Appliances')]")
    public WebElement appliancesDropDown;

    @FindBy(xpath = "//span[contains(text(),'Men')]")
    public WebElement menDropDown;

    @FindBy(xpath = "//span[contains(text(),'Women')]")
    public WebElement womenDropDown;

    @FindBy(xpath = "//span[contains(text(),'Baby & Kids')]")
    public WebElement babyandkidsDropDown;

    @FindBy(xpath = "//span[contains(text(),'Home & Furniture')]")
    public WebElement homeandfurnitureDropDown;

    @FindBy(xpath = "//span[contains(text(),'Books & More')]")
    public WebElement booksandmoreDropDown;

    @FindBy(xpath = "//span[contains(text(),'Offer Zone')]")
    public WebElement offerzoneDropDown;


    /** Footer
     * Component Elements
     */


    @FindBy(xpath = "//div[contains(text(),'HELP')]")
    public WebElement footerHelpSection;

    @FindBy(xpath = ".//div[contains(text(),'FLIPKART')]")
    public WebElement footerFlipkartSection;

    @FindBy(xpath = ".//div[contains(text(),'MISC')]")
    public WebElement footerMiscSection;


    /**
     * Product Search UI Elements
     */

    @FindBy(name = "q")
    public WebElement queryBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchIcon;


    /**
     * Left Rail Elements
     */

    @FindBy(css = "._3y61_q>span>span")
    public WebElement filterByCategoryTitle;

    @FindBy(css = "._1nunVC._2GQLOX>span>span")
    public WebElement filterByPriceTitle;


    /**
     * Random Product selecting element
     */
    @FindBy(xpath = "/descendant::a[470]")
    public WebElement clickOnRandomProduct;

    /**
     * Methods for the HomePage
     */


    public void init(){
        PageFactory.initElements(driver, this);
    }


    public void verifyHeaderComponentsDisplayed(){
        WaitUtil.sleep(100);
        electronicsDropDown.isDisplayed();
        WaitUtil.sleep(100);
        appliancesDropDown.isDisplayed();
        WaitUtil.sleep(100);
        menDropDown.isDisplayed();
        WaitUtil.sleep(100);
        womenDropDown.isDisplayed();
        WaitUtil.sleep(100);
    }

    public void verifyFooterComponentsDisplayed(){
        WaitUtil.sleep(100);
        footerHelpSection.isDisplayed();
        WaitUtil.sleep(100);
        footerFlipkartSection.isDisplayed();
        WaitUtil.sleep(100);
        footerMiscSection.isDisplayed();
        WaitUtil.sleep(100);
    }


    public void productSearch(){
        sendKeysByWebElement(queryBox,PRODUCT_NAME);
        WaitUtil.sleep(100);
        searchIcon.click();
    }

    public void filterByCategoryTitle(){
        filterByCategoryTitle.isDisplayed();
        WaitUtil.sleep(100);
    }

    public void filterByPriceTitle(){
        filterByPriceTitle.isDisplayed();
        WaitUtil.sleep(100);
    }


    public void clickProductLink(){
        WaitUtil.sleep(100);
        clickOnRandomProduct.isDisplayed();
        WaitUtil.sleep(100);
        clickOnRandomProduct.click();
        WaitUtil.sleep(500);

    }


}
