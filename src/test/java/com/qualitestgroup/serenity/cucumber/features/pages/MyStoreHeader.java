package com.qualitestgroup.serenity.cucumber.features.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class MyStoreHeader extends BasePageClass {

    private By TOUCHABLE_TEXT_storeData = MobileBy.AccessibilityId("touchable-store-data");
    public boolean isTouchableStoreDataPresent() {
        try {
            getDriver().findElement(TOUCHABLE_TEXT_storeData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickTouchableStoreData() {
//        if (isTouchableStoreDataPresent()) {

            new WebDriverWait(getDriver(), 5)
                    .until(ExpectedConditions
                    .presenceOfElementLocated(TOUCHABLE_TEXT_storeData)).click();
//            return new StoreDetailPage(driver);
//        } else {
//            throw new IllegalStateException("Touchable Store Data not present!");
//        }
    }
    public String getTouchableStoreData() {
//        if (isTouchableStoreDataPresent()) {
            String result = getDriver().findElement(TOUCHABLE_TEXT_storeData).getText();
            return result;
//        } else {
//            throw new IllegalStateException("Touchable Store Data not present!");
//        }
    }
    // >>> start Android only!
    private String XPATH_storeDataPattern = "//android.widget.Button[@content-desc=\"touchable-store-data\"]/android.widget.TextView[%s]";
    private String XPATH_storeTitle = String.format(XPATH_storeDataPattern, "1");
    private By TEXT_storeTitle = MobileBy.xpath(XPATH_storeTitle);
    public String getTouchableStoreDataTitle() {
        String result = getDriver().findElement(TEXT_storeTitle).getText();
        return result;
    }
    private String XPATH_storeLocation = String.format(XPATH_storeDataPattern, "2");
    private By TEXT_storeLocation = MobileBy.xpath(XPATH_storeLocation);
    public String getTouchableStoreDataLocation() {
        String result = getDriver().findElement(TEXT_storeLocation).getText();
        return result;
    }
    private String XPATH_storeOpenData = String.format(XPATH_storeDataPattern, "3");
    private By TEXT_storeOpenData = MobileBy.xpath(XPATH_storeOpenData);
    public String getTouchableStoreOpenData() {
        String result = getDriver().findElement(TEXT_storeOpenData).getText();
        return result;
    }
    // >>> end Android only!


    private By BUTTON_changeStore = MobileBy.AccessibilityId("button-change-store");
    public boolean isChangeStoreButtonPresent() {
        try {
            getDriver().findElement(BUTTON_changeStore);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickChangeStoreButton() {
//        if (isChangeStoreButtonPresent()) {
            new WebDriverWait(getDriver(), 10)
                    .until(ExpectedConditions
                            .presenceOfElementLocated(BUTTON_changeStore))
                    .click();
//        } else {
//            throw new IllegalStateException("Change Store button not present!");
//        }
//        return new StoreSearchPage(driver);
    }


    public MyStoreHeader(WebDriver driver) {
        super(driver);
    }
}
