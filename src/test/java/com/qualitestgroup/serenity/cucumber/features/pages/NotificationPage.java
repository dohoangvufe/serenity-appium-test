package com.qualitestgroup.serenity.cucumber.features.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class NotificationPage extends BasePageClass {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"text-page-heading\"]/android.widget.TextView")
    @iOSFindBy(accessibility = "text-page-heading")
//    private MobileElement TEXT_heading;
    private WebElement TEXT_heading;

    public String getHeader() {
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.textToBePresentInElement((WebElement) TEXT_heading, expectedHeading));
        String header = TEXT_heading.getText();
        return header;
    }

    String expectedHeading = "STAY CONNECTED";

    public boolean headingMatches() {
        String actual = getHeader();
        System.out.println(">>> In NotificationPage, actual header = " + actual);
        return (actual.equals(expectedHeading));
    }

    private By BY_BUTTON_enableNotifications = MobileBy.AccessibilityId("button-confirm");

    public boolean isConfirmButtonPresent() {
        try {
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(BY_BUTTON_enableNotifications));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickConfirmButton() {
        if (isConfirmButtonPresent()) {
            getDriver().findElement(BY_BUTTON_enableNotifications).click();
        } else {
            throw new IllegalStateException(expectedHeading + ": confirm button not present!");
        }
    }

    private By BY_LINK_declineEnableNotifications = MobileBy.AccessibilityId("link-decline");

    public boolean isDeclineLinkPresent() {
        try {
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(BY_LINK_declineEnableNotifications));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickDeclineLink() {
        if (isDeclineLinkPresent()) {
            getDriver().findElement(BY_LINK_declineEnableNotifications).click();
//            return new LoyaltyPage(driver);
        } else {
            throw new IllegalStateException(expectedHeading + ": decline link not present!");
        }
    }

    public NotificationPage(WebDriver driver) {
        super(driver);
    }
}
