package androidTests;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;


public class GestureClassTest extends BaseTest {

    /*
     For gestures such as long click double tap scroll and all  we actually have to
     inject javascript
     */



    @Test
    public void gestureLongPressTest()
    {


        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
      WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));

    //   driver.executeScript( "mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement) element).getId()));


     util.longPress(element);



    }







}
