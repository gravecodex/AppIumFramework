package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

public class utils {

    AndroidDriver driver;
    HashMap<String, Object> arguments;

   public utils( AndroidDriver driver) {
       this.driver = driver;
   }

  public String getId(WebElement element)
   {
     return ((RemoteWebElement) element).getId();
   }


   public void longPress(WebElement element){
    //   driver.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", getId(element)));
       arguments = new HashMap<>();
       arguments.put("elementId",getId(element));
       driver.executeScript("mobile: longClickGesture",arguments );
   }


    public void longPressTillTime(WebElement element, int milliseconds){
        //   driver.executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", getId(element)));
        arguments = new HashMap<>();
        arguments.put("elementId",getId(element));
        arguments.put("milliseconds",milliseconds);
        driver.executeScript("mobile: longClickGesture",arguments );
    }

}
