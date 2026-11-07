package androidTests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidBatteryInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class firstClassTest extends BaseTest{

   @Test
   public void appiumBasics()  {



       AndroidBatteryInfo batteryInfo = driver.getBatteryInfo();
       System.out.println(batteryInfo.getState());


       //accesseblity id, id, class name, android UiAutomator,  X path - These are the locators this supports

       /*
       How do we write Xpath  ??  It follows standard syntax

       //tagName[@attribute='value']

       //tagName is also valid xPath
        */

       driver.findElement(AppiumBy.accessibilityId("Preference")).click();
       driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
       driver.findElement(AppiumBy.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]")).click();
       driver.findElement(AppiumBy.xpath("(//android.widget.RelativeLayout)[2]")).click();

       String wifiName = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]")).getText();
       Assert.assertEquals(wifiName,"WiFi settings");
       driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"android:id/edit\"]")).sendKeys("Aditya is Best");
       driver.findElement(AppiumBy.id("android:id/button1")).click();

   }


}
