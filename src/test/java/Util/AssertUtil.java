package Util;

import static org.testng.Assert.assertTrue;

/**
 * Created by sadiq on 15/10/16.
 */
public class AssertUtil extends BaseUtil{



    public static void assertTruePageText(String text) {
        assertTruePageText(text, null);
    }

    public static void assertTruePageText(String text, String failMessage) {
        WaitUtil.sleep(500);
        assertTrue(BaseUtil.checkPageSourceContains(text), failMessage);

    }
}
