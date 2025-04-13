package pages;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.URL;
import java.util.Arrays;


public class AndroidDriverCreation {
    AndroidDriver<WebElement> driver;


    public AndroidDriverCreation(AndroidDriver<WebElement> driver) {
        this.driver = driver;
    }

    /**
     * This method will generate the Android Driver instance for the Appium
     *
     * @param appActivity - app activity of app
     * @param appPackage  - app package of app
     * @param deviceId    - device uuid/id
     * @return AndroidDriver instance
     */

    public AndroidDriver generateTheAndroidDriverForAndroidMobile(
            String appPackage,
            String deviceId,
            String appActivity
    ) throws Exception {
        try {
            URL appiumServerURL =new URL ("http://localhost:4723/wd/hub");
            System.out.println("Starting to create the Android driver to execute some automation.");

            DesiredCapabilities cap = new DesiredCapabilities();

            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 6 * 60);
            cap.setCapability(MobileCapabilityType.UDID, deviceId);
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceId);
            cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
            cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
            cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
            cap.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
            cap.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, false);

           try{
               driver = new AndroidDriver<>(appiumServerURL,cap);
           }catch(Exception e){
               System.out.println(e);
           }
            return driver;
        } catch (Exception e) {
            throw new Exception("Terminating the driver creation, unable to start server\n\t\t" +
                    String.join("\n\t\t", Arrays.stream(Arrays.copyOfRange(e.getStackTrace(),
                                    0, Math.min(3, e.getStackTrace().length)))
                            .map(StackTraceElement::toString)
                            .toArray(String[]::new)), e);
        }
    }
}
