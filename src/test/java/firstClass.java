import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class firstClass {

   @Test
   public void InitialisingDriver() throws MalformedURLException {

      /*
       android sdk path added as its not getting it by itself
       */
       String sdkPath = "/Users/E2274/Library/Android/sdk";
       HashMap <String,String >env = new HashMap<>();
       env.put("ANDROID_HOME", sdkPath);
       env.put("ANDROID_SDK_ROOT", sdkPath);

       /*
        To automate appium server so that it can start or program run and end when program ends
        Either you can manually start appium server and skip this or automate it
        */
       String jsPath = "//opt//homebrew//lib//node_modules//appium//build//lib//main.js";
       AppiumDriverLocalService appiumServiceRunner = new AppiumServiceBuilder().withAppiumJS(new File(jsPath))
               .withIPAddress("192.168.1.20").usingPort(4723).withEnvironment(env).build();
       appiumServiceRunner.start();



       String appPath = "/Users/E2274/AppiumAutomation/src/test/resources/apps/ApiDemos-debug.apk";
       //capabilities
       UiAutomator2Options options = new UiAutomator2Options();
       options.setUdid("emulator-5554");
       options.setApp(appPath);



       /*two arguments drivers constructor needs
        1 - local service (server address/url)
        2 - capabilities (means every device details using uiAutomator2 class)
        */
       AndroidDriver android = new AndroidDriver(
               appiumServiceRunner.getUrl(), options
       );

       AndroidBatteryInfo batteryInfo = android.getBatteryInfo();
       System.out.println(batteryInfo.getState());

       appiumServiceRunner.stop();


   }


}
