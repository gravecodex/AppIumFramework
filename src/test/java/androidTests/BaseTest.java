package androidTests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.internal.Utils;
import utils.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {


    /*
    android sdk path added as its not getting it by itself
    */
     String sdkPath = "/Users/E2274/Library/Android/sdk";
    HashMap<String,String > env = new HashMap<>();


    utils util;

   // URL appiumServiceRunner =null;

    String ipAddress = "192.168.1.20";

    AppiumDriverLocalService appiumServiceRunner;
       /*
        To automate appium server so that it can start or program run and end when program ends
        Either you can manually start appium server and skip this or automate it
        */
       String jsPath = "//opt//homebrew//lib//node_modules//appium//build//lib//main.js";




    String appPath = "/Users/E2274/AppiumAutomation/src/test/resources/apps/ApiDemos-debug.apk";
    //capabilities
    UiAutomator2Options options = new UiAutomator2Options();




    /*two arguments drivers constructor needs
     1 - local service (server address/url)
     2 - capabilities (means every device details using uiAutomator2 class)
     */
     AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {}


    @BeforeClass
    public void startAppiumServer() throws MalformedURLException {

        env.put("ANDROID_HOME", sdkPath);
        env.put("ANDROID_SDK_ROOT", sdkPath);

        options.setUdid("emulator-5554");
        options.setApp(appPath);


        appiumServiceRunner   = new AppiumServiceBuilder().withAppiumJS(new File(jsPath))
                .withIPAddress(ipAddress).usingPort(4723).withEnvironment(env).build();
        appiumServiceRunner.start();


        driver   = new AndroidDriver(
                appiumServiceRunner.getUrl(), options
        );

        //Global wait which driver will carry
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        util = new utils(driver);
    }


    @AfterClass
    public void stopAppiumServer(){

        driver.quit();
        appiumServiceRunner.stop();


    }


}
