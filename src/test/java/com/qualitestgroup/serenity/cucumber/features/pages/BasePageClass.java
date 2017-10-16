package com.qualitestgroup.serenity.cucumber.features.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.thucydides.core.pages.PageObject;


//public abstract class BasePageClass extends PageObject {
public class BasePageClass extends PageObject {
    public static final Logger LOGGER = LoggerFactory.getLogger(BasePageClass.class);
    private static boolean isIOS;
    private static boolean isAndroid;
//    protected final AppiumDriver driver;

    public static void setAndroid(boolean android){
        isAndroid = android;
    }
    public static boolean isAndroid(){ return isAndroid; }

    public static void setIOS(boolean iOS){
        isIOS = iOS;
    }
    public static boolean isIOS(){
        return isIOS;
    }

//    public BasePageClass(AppiumDriver driver) {
    public BasePageClass(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
