import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class firstClass extends BaseTest{

   @Test
   public void InitialisingDriver() throws MalformedURLException {


       startAppiumServer();
       AndroidBatteryInfo batteryInfo = driver.getBatteryInfo();
       System.out.println(batteryInfo.getState());


       //accesseblity id, id, class name, android UiAutomator,  X path - These are the locators this supports



       driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Access'ibility\"]")).click();

       
       stopAppiumServer();

   }


}
