package com.qualitestgroup.serenity.cucumber.features.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class CustomTouch extends PageObject{

//    public enum Direction {UP, DOWN, LEFT, RIGHT};
//    public static boolean swipeToDirection_iOS(Direction direction) {
//        return swipeToDirection_iOS(null, direction);
//    }
//
//    public static boolean swipeToDirection_iOS(MobileElement element, Direction direction) {
//        try {
//            JavascriptExecutor js = (JavascriptExecutor) getDriver();
//            HashMap<String, String> swipeObject = new HashMap<String, String>();
//            swipeObject.put("direction", direction.toString().toLowerCase());
//            if (element != null) {
//                swipeObject.put("element", element.getId());
//            }
//            js.executeScript("mobile:swipe", swipeObject);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public static void scrollToElement_iOS(MobileElement element, Direction direction) {
//        int i = 0;
//        int max = 6;
//        boolean visible = element.isDisplayed();
//        while (i<max && !visible) {
//            swipeToDirection_iOS(direction);
//            i++;
//            visible = element.isDisplayed();
//        }
//        if (!visible) {
//            throw new IllegalStateException("Unable to scroll to iOS off-screen element!");
//        }
//    }
//
//    public static void swipeToDirection_Android(Direction direction) {
//        //TODO: fix
////        getDriver().context("NATIVE_APP");
////        Dimension winSize = getDriver().manage().window().getSize();
////        int xOffset = 0;
////        int yOffset = 0;
////        switch (direction) {
////            case UP:    yOffset = -4;
////                        break;
////            case DOWN:  yOffset = 4;
////                        break;
////            case RIGHT: xOffset = 4;
////                        break;
////            case LEFT:  xOffset = -4;
////                        break;
////        }
////        int startX = getX(winSize,50);
////        int endX = getX(winSize,xOffset);
////        int startY = getY(winSize,80);
////        int endY = getY(winSize,yOffset);
////        TouchAction touchAction = new TouchAction(driver);
////
////        int x = driver.findElementsByAccessibilityId("button-reserve-event-now").size();
////        touchAction.press(startX, startY).moveTo(endX, endY).release();
////        driver.performTouchAction(touchAction);
//    }
//    private static int getX (Dimension winSize, int x) {
//        return (int) ((winSize.width * x) / 100);
//    }
//    private static int getY (Dimension winSize, int y) {
//        return (int) ((winSize.height * y) / 100);
//    }
//
////    public static void scrollToElement_Android(By byDescriptor, Direction direction) {
////        int i = 0;
////        int max = 6;
////        boolean onScreen = (getDriver().findElements(byDescriptor).size() == 1);
////        while (i<max && !onScreen) {
////            swipeToDirection_Android(direction);
////            i++;
////            onScreen = (getDriver().findElements(byDescriptor).size() == 1);
////        }
////        if (!onScreen) {
////            throw new IllegalStateException("Unable to scroll to Android off-screen element!");
////        }
////    }

}
