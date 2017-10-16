package com.qualitestgroup.serenity.cucumber.features.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import net.serenitybdd.core.annotations.findby.FindBy;


public class LoyaltyPage extends BasePageClass {

//    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"text-page-heading\"]/android.widget.TextView")
////    @androidfindby(xpath = "//android.view.ViewGroup[@content-desc=\"text-page-heading\"]/android.widget.TextView")
//    @iOSFindBy(accessibility = "text-page-heading")
////    @iosfindby(accessibility = "text-page-heading")
//    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"text-page-heading\"]/android.widget.TextView")
////    private MobileElement TEXT_heading;
    private By BY_TEXT_heading = isAndroid()
                                    ? MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"text-page-heading\"]/android.widget.TextView")
                                    : MobileBy.AccessibilityId("text-page-heading");

    public String getHeader() {
        String result = getDriver().findElement(BY_TEXT_heading).getText();
        return result;
    }

    String expectedHeading = "REWARDING LOYALTY";
    public boolean headingMatches() {
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(BY_TEXT_heading), expectedHeading));
        return (getHeader().equals(expectedHeading));
    }

    private By BY_BUTTON_joinNow = MobileBy.AccessibilityId("button-confirm");

    public boolean isJoinNowButtonPresent() {
        try {
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(BY_BUTTON_joinNow));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickJoinNowButton() {
        if (isJoinNowButtonPresent()) {
            getDriver().findElement(BY_BUTTON_joinNow).click();
        } else {
            throw new IllegalStateException(expectedHeading + ": Join Now button not present!");
        }
    }

    private By BY_BUTTON_signIn = MobileBy.AccessibilityId("button-confirm2");

    public boolean isSignInButtonPresent() {
        try {
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(BY_BUTTON_signIn));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickSignInButton() {
        if (isJoinNowButtonPresent()) {
            getDriver().findElement(BY_BUTTON_signIn).click();
        } else {
            throw new IllegalStateException(expectedHeading + ": Sign In button not present!");
        }
    }

    private By BY_LINK_declineLoyalty = MobileBy.AccessibilityId("link-decline");
    public boolean isDeclineLinkPresent() {
        try {
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(BY_LINK_declineLoyalty));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickDeclineLink() {
        if (isDeclineLinkPresent()) {
            getDriver().findElement(BY_LINK_declineLoyalty).click();
        } else {
            throw new IllegalStateException(expectedHeading + ": decline link not present!");
        }
    }

//    public LoyaltyPage(AppiumDriver driver) {
    public LoyaltyPage(WebDriver driver) {
        super(driver);
//ls         PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }
}
