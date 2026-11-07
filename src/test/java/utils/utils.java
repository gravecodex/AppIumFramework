package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class utils {

    AndroidDriver driver;

   public utils( AndroidDriver driver) {
       this.driver = driver;
   }

  public String getId(WebElement element)
   {
     return ((RemoteWebElement) element).getId();
   }



   public void longPress(WebElement element){

       driver.executeScript("mobile: longClickGesture", ImmutableMap.of("element", getId(element)));
   }







}
