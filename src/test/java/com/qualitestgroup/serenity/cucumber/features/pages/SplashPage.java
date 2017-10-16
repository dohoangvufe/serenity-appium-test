package com.qualitestgroup.serenity.cucumber.features.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class SplashPage extends BasePageClass {

    private By BY_BUTTON_continue = MobileBy.AccessibilityId("button-lets-begin");

    public SplashPage(WebDriver driver) {
        super(driver);
    }

    public boolean isStartButtonPresent() {
        try {
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(BY_BUTTON_continue));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickStartButton() {
        if (isStartButtonPresent()) {
            getDriver().findElement(BY_BUTTON_continue).click();
//            return new LocationPage(driver);
        } else {
            throw new IllegalStateException("Splash page continue button not present!");
        }
    }
}

