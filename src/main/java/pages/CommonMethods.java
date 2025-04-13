package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends CommonVariables{



    public CommonMethods(AndroidDriver androidDriver) {
        CommonMethods.androidDriver = androidDriver;
    }


    /**
     * this method waits for the presence of an exclusive element
     */
    public static void waitForAnExplicitElement(AndroidDriver driver,By element) {
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(element));

    }

}
