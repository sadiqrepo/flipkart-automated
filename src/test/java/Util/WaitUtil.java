package Util;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by sadiq on 15/10/16.
 */
public class WaitUtil extends BaseUtil {

    public static void fluentWait(final WebElement element, final long timeout, final long polltime) {

        new FluentWait<WebElement>(element).
                withTimeout(10, TimeUnit.SECONDS).
                pollingEvery(100,TimeUnit.MILLISECONDS).
                until(new Function<WebElement, Boolean>() {

                          public Boolean apply(WebElement element) {
                              return element.getText().endsWith("04");
                          }
                      }
                );
    }


    //Explicit Wait
    public static WebElement isElementVisible(WebElement element, final long timeout){

        try{
            new WebDriverWait(driver,10).
                    until(ExpectedConditions.visibilityOf(element));

        }catch(ElementNotVisibleException e){
            e.printStackTrace();
        }

        return element;
    }

    // Thread.sleep()
    public static void sleep(Integer timeInMillis) {
        try {
            Thread.sleep(timeInMillis);
        } catch (InterruptedException ignored) {
        }
    }

    public static void sleep() {
        sleep(2000);
    }


}
