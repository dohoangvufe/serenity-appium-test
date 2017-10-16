package com.qualitestgroup.serenity.cucumber.features.pages;

import com.qualitestgroup.serenity.cucumber.features.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import net.serenitybdd.core.annotations.findby.FindBy;


public class LocationPage extends BasePageClass {

   @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"text-page-heading\"]/android.widget.TextView")
   @iOSFindBy(accessibility = "text-page-heading")
   @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"text-page-heading\"]/android.widget.TextView")
   private MobileElement TEXT_heading;

    public String getHeader() {
        String header = TEXT_heading.getText();
        return header;
    }

    String expectedHeading = "FIND MY STORE";
    public boolean headingMatches() {
        String actual = getHeader();
        return (actual.equals(expectedHeading));
    }

//    private By BY_BUTTON_allowLocation = MobileBy.AccessibilityId("button-confirm");
    private String XPATH_iosAllowLocation = "//XCUIElementTypeButton[@name=\"FIND MY STORE\"]";
    private By BY_BUTTON_allowLocation = isAndroid()
                                            ? MobileBy.AccessibilityId(expectedHeading)
                                            : MobileBy.xpath(XPATH_iosAllowLocation);
    public boolean isConfirmButtonPresent() {
        try {
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(BY_BUTTON_allowLocation));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private By BY_BUTTON_confirmAllow = MobileBy.AccessibilityId("Allow");
    public void clickConfirmButton() {
        if (isConfirmButtonPresent()) {
            getDriver().findElement(BY_BUTTON_allowLocation).click();
            try {
                new WebDriverWait(getDriver(), 2)
                        .until(ExpectedConditions.presenceOfElementLocated(BY_BUTTON_confirmAllow))
                        .click();
            } catch (Exception e) {
                System.out.println("Allow Location -- no confirm!");
            }
        } else {
            throw new IllegalStateException(expectedHeading + ": confirm button not present!");
        }
//        return new NotificationPage(driver);
    }

    private By BY_LINK_declineAllowLocation = MobileBy.AccessibilityId("link-decline");
    public boolean isDeclineLinkPresent() {
        try {
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(BY_LINK_declineAllowLocation));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickDeclineLink() {
        if (isDeclineLinkPresent()) {
            getDriver().findElement(BY_LINK_declineAllowLocation).click();
            try {
                if (isAndroid()) {
                    Thread.sleep(750);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            return new NotificationPage(driver);
        } else {
            throw new IllegalStateException(expectedHeading + ": decline link not present!");
        }
    }

    public LocationPage(WebDriver driver) {
        super(driver);
    }
}
