package com.qualitestgroup.serenity.cucumber.features.pages;

import com.qualitestgroup.serenity.cucumber.features.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class StoreSearchPage extends BasePageClass {

// Android works -->    private By BY_FIELD_geoSearch = MobileBy.AccessibilityId("field-search-stores");
    private By BY_FIELD_geoSearch = isAndroid()
                                        ? MobileBy.AccessibilityId("field-search-stores")
                                        : MobileBy.AccessibilityId("\uE820 CITY, STATE OR ZIP SEARCH");
    public StoreSearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSearchFieldPresent() {
        try {
            new WebDriverWait(getDriver(), 20).until(ExpectedConditions.presenceOfElementLocated(BY_FIELD_geoSearch));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void enterSearchToken(String token) {
        if (isSearchFieldPresent()) {
            if (isIOS()) {
                token = token + "\n";
            }
            getDriver().findElement(BY_FIELD_geoSearch).clear();
            getDriver().findElement(BY_FIELD_geoSearch).sendKeys(token);
            if (isAndroid()) {
                clickSearchButtonOnly();
            }
        } else {
            throw new IllegalStateException("Search Store field not present!");
        }
//        return new StoreSearchPage(driver);
    }

    private By BY_FIELD_searchButton = MobileBy.AccessibilityId("button-search-stores");
//    private By BY_FIELD_searchButton = MobileBy.AccessibilityId("\uE820 \uE5C9 SEARCH");
    public boolean isSearchButtonPresent() {
        try {
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(BY_FIELD_searchButton));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickSearchButton() {
        if (isSearchButtonPresent()) {
            clickSearchButtonOnly();
        } else {
            throw new IllegalStateException("Search Store button not present!");
        }
    }
    public void clickSearchButtonOnly() {
        getDriver().findElement(BY_FIELD_searchButton).click();
    }

    public void selectStore(String storeFragment) {
        String xpath = String.format("(//XCUIElementTypeOther[contains(@name,'%s')])", storeFragment);
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath(xpath)));
        int index = getDriver().findElements(By.xpath(xpath)).size();
        System.out.println(">>> Select Store index = " + index);
        String suffix = String.format("[%s]", index);
        getDriver().findElement(By.xpath(xpath+suffix)).click();
//        return new StoreDetailPage(driver);
    }

    private String XPATH_storeNumberPattern = "(//android.widget.Button[@content-desc=\"touchable-store-detail\"])[%d]/android.widget.TextView[1]";
    public void selectStore(int storeNumber) {
        String xpath = String.format(XPATH_storeNumberPattern, storeNumber);
        new WebDriverWait(getDriver(), 25)
                .until(ExpectedConditions
                        .presenceOfElementLocated(MobileBy.xpath(xpath)))
                .click();
//        return new StoreDetailPage(driver);
    }
}

