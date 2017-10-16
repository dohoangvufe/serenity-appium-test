package com.qualitestgroup.serenity.cucumber.features.pages;

import com.qualitestgroup.serenity.cucumber.features.utils.CustomTouch;
import com.qualitestgroup.serenity.cucumber.features.utils.ScheduleParser;
import com.qualitestgroup.serenity.cucumber.features.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

import java.time.DayOfWeek;

public class StoreDetailPage extends BasePageClass {

    private By TOUCHABLE_ICON_callStore = MobileBy.AccessibilityId("touchableIcon-call-store");
//    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='touchableIcon-call-store']/android.widget.TextView[1]")
//    @iOSFindBy(accessibility = "text-page-heading")
//    private MobileElement ICON_callStore;
    public boolean isCallStoreIconPresent() {
        try {
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(TOUCHABLE_ICON_callStore));
            getDriver().findElement(TOUCHABLE_ICON_callStore);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickCallStore() {
//        if (isCallStoreIconPresent()) {
            getDriver().findElement(TOUCHABLE_ICON_callStore).click();
//        } else {
//            throw new IllegalStateException("Touchable Call Store icon not present!");
//        }
    }

    private By TOUCHABLE_ICON_getDirections = MobileBy.AccessibilityId("touchableIcon-get-directions");
//            Utils.isAndroidPlatform(driver)
//                    ? MobileBy.xpath("(//android.widget.Button[@content-desc='touchableIcon-get-directions'])[1]/android.widget.TextView[1]")
//                    : MobileBy.xpath("//*[@name='touchableIcon-get-directions']");
    public boolean isGetDirectionsIconPresent() {
        try {
            getDriver().findElement(TOUCHABLE_ICON_getDirections);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickGetDirections() {
//        if (isGetDirectionsIconPresent()) {
        getDriver().findElement(TOUCHABLE_ICON_getDirections).click();
//        } else {
//            throw new IllegalStateException("Get Directions icon not present!");
//        }
    }

    private By TOUCHABLE_ICON_myStore = MobileBy.AccessibilityId("touchableIcon-bookmark-myStore");
//    private By TOUCHABLE_ICON_myStore =
//        Utils.isAndroidPlatform(driver)
//                ? MobileBy.xpath("//android.widget.Button[@content-desc='touchableIcon-bookmark-myStore']/android.widget.TextView[1]")
////                : MobileBy.xpath("//*[@name='touchableIcon-bookmark-myStore']");
//                : MobileBy.AccessibilityId("touchableIcon-bookmark-myStore");
    public boolean isMyStoreIconPresent() {
        try {
            getDriver().findElement(TOUCHABLE_ICON_myStore);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickMyStore() {
//        if (isMyStoreIconPresent()) {
        getDriver().findElement(TOUCHABLE_ICON_myStore).click();
//        } else {
//            throw new IllegalStateException("My Store icon not present!");
//        }
    }

    private By TEXT_storeData = MobileBy.AccessibilityId("text-store-data");
    public boolean isStoreDataPresent() {
        try {
            getDriver().findElement(TEXT_storeData);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private By TEXT_storeDataTitle = MobileBy.xpath("//android.view.ViewGroup[@content-desc='text-store-title']/android.widget.TextView");
    private By TEXT_storeDataAddress = MobileBy.xpath("//android.widget.TextView[@content-desc='text-store-address']");
    private By TEXT_storeDataCityStateZip = MobileBy.xpath("//android.view.ViewGroup[@content-desc='text-store-cityStateZip']/android.widget.TextView");
    private By TEXT_storeDataOpenCloseHour = MobileBy.xpath("//android.view.ViewGroup[@content-desc='text-store-openCloseHour']/android.widget.TextView");
    public String getStoreData() {
        String result = "NOT FOUND!";
        if (isStoreDataPresent()) {
            if (isIOS()) {
                result = getDriver().findElement(TEXT_storeData).getText();
            } else {
                result = getDriver().findElement(TEXT_storeDataTitle).getText();
                try {
                    result = result + " " + getDriver().findElement(TEXT_storeDataAddress).getText();
                } catch (Exception e) {
                    System.out.println("No address found.");
                }
                result = result + " " + getDriver().findElement(TEXT_storeDataCityStateZip).getText();
                result = result + " " + getDriver().findElement(TEXT_storeDataOpenCloseHour).getText();
            }
        } else {
            throw new IllegalStateException("Store Data not present!");
        }
        return result;
    }

    private By TOUCHABLE_IMAGE_storeMap = MobileBy.AccessibilityId("touchableImage-store-map");
//    MobileElement storeMap = (MobileElement) driver.findElement(TOUCHABLE_IMAGE_storeMap);
    public boolean isStoreMapPresent() {
        try {
            getDriver().findElement(TOUCHABLE_IMAGE_storeMap);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickStoreMap() {
//        if (isStoreMapPresent()) {
//            storeMap.click();
        getDriver().findElement(TOUCHABLE_IMAGE_storeMap).click();
//        } else {
//            throw new IllegalStateException("Store Map (image) not present!");
//        }
    }

    private String id = isAndroid() ? "Tap to speak" : "Tracking";
    private By ICON_mapIdentifier = MobileBy.AccessibilityId(id);
    public boolean isStoreMapLoaded() {
        return new WebDriverWait(getDriver(), 5)
                .until(ExpectedConditions.presenceOfElementLocated(ICON_mapIdentifier))
                .isDisplayed();
    }

    //---- S T O R E   H O U R S ------------------------------------------------------------------------v
    private By TEXT_TABNAME_storeHours = isAndroid()
                    ? MobileBy.xpath("//*[@text='STORE HOURS']")
                    : MobileBy.xpath("//*[@name='STORE HOURS']");
    public boolean isStoreHoursTabPresent() {
        try {
            getDriver().findElement(TEXT_TABNAME_storeHours);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickStoreHoursTab() {
        if (isStoreHoursTabPresent()) {
            getDriver().findElement(TEXT_TABNAME_storeHours).click();
        } else {
            throw new IllegalStateException("Store Hours tab not present!");
        }
    }
    private By TEXT_GRID_storeHours =
            isAndroid()
                    ? MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"grid-store-hours\"]")
                    : MobileBy.AccessibilityId("grid-store-hours");
    public boolean isStoreHoursGridPresent() {
        try {
            getDriver().findElement(TEXT_GRID_storeHours);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private final String XPATH_androidStoreGridElement = "//android.view.ViewGroup[@content-desc='grid-store-hours']/android.widget.TextView";
    public String getAllStoreHoursData() {
        String result = "";
        if (isAndroid()) {
            result = getAllAndroidGridData(XPATH_androidStoreGridElement);
        } else {
            result = getDriver().findElement(TEXT_GRID_storeHours).getText();
        }
        return result;
    }
    public String getStoreHours(DayOfWeek day) {
        String result = "";
        String stream = getAllStoreHoursData();
        result = ScheduleParser.getHoursForDay(stream, day);
        return result;
    }

    //---- S P I R I T S   H O U R S ---------------------------------------------------------------------v
    private By TEXT_TABNAME_spiritsHours = isAndroid()
                    ? MobileBy.xpath("//*[@text='SPIRITS HOURS']")
                    : MobileBy.xpath("//*[@name='SPIRITS HOURS']");
    public boolean isSpiritsHoursTabPresent() {
        try {
            getDriver().findElement(TEXT_TABNAME_spiritsHours);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickSpiritsHoursTab() {
        if (isSpiritsHoursTabPresent()) {
            getDriver().findElement(TEXT_TABNAME_spiritsHours).click();
        } else {
            throw new IllegalStateException("Spirits Hours tab not present!");
        }
    }
    private By TEXT_GRID_spiritsHours =
            isAndroid()
                    ? MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"grid-spirits-hours\"]")
                    : MobileBy.AccessibilityId("grid-spirits-hours");
    public boolean isSpiritsHoursGridPresent() {
        try {
            getDriver().findElement(TEXT_GRID_spiritsHours);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    private final String XPATH_androidSpiritsGridElement = "//android.view.ViewGroup[@content-desc='grid-spirits-hours']/android.widget.TextView";
    public String getAllSpiritsHoursData() {
        String result = "";
        if (isAndroid()) {
            result = getAllAndroidGridData(XPATH_androidSpiritsGridElement);
        } else {
            result = getDriver().findElement(TEXT_GRID_spiritsHours).getText();
        }
        return result;
    }
    public String getSpiritsHours(DayOfWeek day) {
        String result = "";
        String stream = getAllSpiritsHoursData();
        result = ScheduleParser.getHoursForDay(stream, day);
        return result;
    }

    //---- T A S T I N G   H O U R S ---------------------------------------------------------------------v
    private By TEXT_TABNAME_tastingHours = isAndroid()
        ? MobileBy.xpath("//*[@text='TASTING HOURS']")
        : MobileBy.xpath("//*[@name='TASTING HOURS']");
    public boolean isTastingHoursTabPresent() {
        try {
            new WebDriverWait(getDriver(), 10)
                    .until(ExpectedConditions.presenceOfElementLocated(TEXT_TABNAME_tastingHours));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickTastingHoursTab() {
        if (isTastingHoursTabPresent()) {
            getDriver().findElement(TEXT_TABNAME_tastingHours).click();
        } else {
            throw new IllegalStateException("Tasting Hours tab not present!");
        }
    }
    private By TEXT_GRID_tastingHours = MobileBy.AccessibilityId("grid-tasting-hours");
    public boolean isTastingHoursGridPresent() {
        try {
            new WebDriverWait(getDriver(), 15)
                    .until(ExpectedConditions
                            .presenceOfElementLocated(TEXT_GRID_tastingHours));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public enum TastingType {WINE, BEER, SPIRITS};
    private final String XPATH_androidTastingGridElement = "//android.view.ViewGroup[@content-desc='grid-tasting-hours']/android.widget.TextView";
    private String XPATH_androidTastingGridElementPattern = XPATH_androidTastingGridElement + "[%d]";
    public String getTastingHours(TastingType type, DayOfWeek day) {
        String result = "NOT FOUND!";
        boolean typeEnded = false;
        if (isAndroid()) {
            int totalGridItems = getDriver().findElements(MobileBy.xpath(XPATH_androidTastingGridElement)).size();
            int typeStartIndex = 0;
            int typeEndIndex = 0;
            for (int i=1; i<=(totalGridItems-2); i+=3) {
                String xpath = String.format(XPATH_androidTastingGridElementPattern, i);
                int x = getDriver().findElements(MobileBy.xpath(xpath)).size();
                String col1 = getDriver().findElement(MobileBy.xpath(xpath)).getText();
                if (col1.equalsIgnoreCase(type.toString())) {
                    typeStartIndex = i;
                } else if ((typeStartIndex > 0) && (col1.isEmpty())) {
                    typeEndIndex = i;
                }
            }
            for (int i=typeStartIndex; i<=typeEndIndex; i+=3) {
                String xpath = String.format(XPATH_androidTastingGridElementPattern, i+1);
                int x = getDriver().findElements(MobileBy.xpath(xpath)).size();
                String col2 = getDriver().findElement(MobileBy.xpath(xpath)).getText();
                if (col2.equalsIgnoreCase(day.toString())) {
                    xpath = String.format(XPATH_androidTastingGridElementPattern, i+2);
                    result = getDriver().findElement(MobileBy.xpath(xpath)).getText();
                    break;
                }
            }
        } else {
            String stream = getDriver().findElement(TEXT_GRID_tastingHours).getText();
            String parsedType = null;
            String parsedDay = null;
            while (!stream.isEmpty()) {
                if (ScheduleParser.isTypeDayTimeFound(stream)) {
                    parsedType = ScheduleParser.getTypeFromTypeDayTime(stream);
                    parsedDay = ScheduleParser.getDayFromTypeDayTime(stream);
                    if (parsedType.equalsIgnoreCase(type.toString())) {
                        if (parsedDay.equalsIgnoreCase(day.toString())) {
                            result = ScheduleParser.getHoursFromTypeDayTime(stream);
                            break;
                        }
                        stream = ScheduleParser.stripTypeDayTime(stream);
                        boolean dayTime = ScheduleParser.isDayTimeFound(stream);
                        while (dayTime && !stream.isEmpty()) {
                            parsedDay = ScheduleParser.getDayFromDayTime(stream);
                            if (parsedDay.equalsIgnoreCase(day.toString())) {
                                result = ScheduleParser.getHoursFromDayTime(stream);
                                break;
                            }
                            stream = ScheduleParser.stripDayTime(stream);
                            if (!stream.isEmpty()) {
                                dayTime = ScheduleParser.isDayTimeFound(stream);
                            }
                        }
                    } else {
                        stream = ScheduleParser.stripTypeDayTime(stream);
                    }
                } else if (ScheduleParser.isDayTimeFound(stream)) {
                        stream = ScheduleParser.stripDayTime(stream);
                }
            }

        }
        return result;
    }
//    public String getAllTastingData() {
//        String result = "";
//        if (Utils.isAndroidPlatform(driver)) {
//            int totalGridItems = driver.findElements(MobileBy.xpath(XPATH_androidTastingGridElement)).size();
//            for (int i=1; i<=(totalGridItems); i++) {
//                String xpath = String.format(XPATH_androidTastingGridElementPattern, i);
//                boolean itemExists = (driver.findElements(MobileBy.xpath(xpath)).size() > 0);
//                if (itemExists) {
//                    String text = driver.findElement(MobileBy.xpath(xpath)).getText() + " ";
//                    result = result + text;
//                }
//            }
//        } else {
//            result = driver.findElement(TEXT_GRID_tastingHours).getText();
//        }
//        return result;
//    }
    public String getAllTastingHoursData() {
        String result = "";
        if (isAndroid()) {
            result = getAllAndroidGridData(XPATH_androidTastingGridElement);
        } else {
            result = getDriver().findElement(TEXT_GRID_tastingHours).getText();
        }
        return result;
    }
    //---- end  H O U R S  methods ---------------------------------------------------------------------v








    private By BUTTON_floatingX = MobileBy.AccessibilityId("button-floating-return");
    public boolean isReturnButtonPresent() {
        try {
            getDriver().findElement(BUTTON_floatingX);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickReturnButton() {
//        if (isReturnButtonPresent()) {
        getDriver().findElement(BUTTON_floatingX).click();
//        } else {
//            throw new IllegalStateException("Return (X) button not present!");
//        }
    }

    private String reserveEventId = "button-reserve-event-now";
    private By BUTTON_reserveEvent = MobileBy.AccessibilityId(reserveEventId);
    public boolean isReserveEventButtonPresent() {
        try {
            getDriver().findElement(BUTTON_reserveEvent);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isReserveEventButtonVisible() {
        try {
            MobileElement reserveEventButton = (MobileElement) getDriver().findElement(BUTTON_reserveEvent);
            return reserveEventButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickReserveEventButton() {
//        if (isReserveEventButtonPresent()) {
        getDriver().findElement(BUTTON_reserveEvent).click();
//        } else {
//            throw new IllegalStateException("Reserve Event button not present!");
//        }
    }
//    public MobileElement moveToOffScreenElement(By byDescriptor, CustomTouch.Direction direction) {
//        MobileElement element = null;
//        if (isIOS()) {
//            element = (MobileElement) getDriver().findElement(byDescriptor);
//            CustomTouch.scrollToElement_iOS(element, direction);
//        } else if (isAndroid()) {
//            CustomTouch.scrollToElement_Android(byDescriptor, direction);
//            element = (MobileElement) new WebDriverWait(getDriver(), 3)
//                    .until(ExpectedConditions.presenceOfElementLocated(byDescriptor));
//        } else {
//            throw new IllegalStateException("Platform not found to be either iOS or Android!");
//        }
//        return element;
//    }
//    public void clickReserveEventButton(CustomTouch.Direction direction) {
//        MobileElement button = null;
//        if (Utils.isIosPlatform(driver)) {
////        MobileElement button = (MobileElement) driver.findElementByAccessibilityId(reserveEventId);
//            button = (MobileElement) driver.findElement(BUTTON_reserveEvent);
//            CustomTouch.scrollToElement_iOS(driver, button, CustomTouch.Direction.UP);
//        } else if (Utils.isAndroidPlatform(driver)) {
//            CustomTouch.scrollToElement_Android(driver, BUTTON_reserveEvent, CustomTouch.Direction.UP);
//            button = (MobileElement) new WebDriverWait(driver, 3)
//                    .until(ExpectedConditions.presenceOfElementLocated(BUTTON_reserveEvent));
//        } else {
//            throw new IllegalStateException("Platform not found to be either iOS or Android!");
//        }
//        button.click();
//        MobileElement button = moveToOffScreenElement(BUTTON_reserveEvent, CustomTouch.Direction.UP);
//        button.click();
//    }

    private By BUTTON_seeDeals = MobileBy.AccessibilityId("button-see-deals");
    public boolean isSeeDealsButtonPresent() {
        try {
            getDriver().findElement(BUTTON_seeDeals);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickSeeDealsButton() {
//        if (isSeeDealsButtonPresent()) {
        getDriver().findElement(BUTTON_seeDeals).click();
//        } else {
//            throw new IllegalStateException("See Deals button not present!");
//        }
    }
//    public void clickSeeDealsButton(CustomTouch.Direction direction) {
//
//    }

    private By BUTTON_seeAllCigars = MobileBy.AccessibilityId("button-see-all-cigars");
    public boolean isSeeAllCigarsButtonPresent() {
        try {
            getDriver().findElement(BUTTON_seeAllCigars);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickSeeAllCigarsButton() {
//        if (isSeeAllCigarsButtonPresent()) {
        getDriver().findElement(BUTTON_seeAllCigars).click();
//        } else {
//            throw new IllegalStateException("See All Cigars button not present!");
//        }
    }


    public String getAllAndroidGridData(String gridElementXpath) {
        String result = "";
        String gridElementXpathPattern = gridElementXpath + "[%d]";
        int totalGridItems = getDriver().findElements(MobileBy.xpath(gridElementXpath)).size();
        for (int i=1; i<=(totalGridItems); i++) {
            String xpath = String.format(gridElementXpathPattern, i);
            boolean itemExists = (getDriver().findElements(MobileBy.xpath(xpath)).size() > 0);
            if (itemExists) {
                String text = getDriver().findElement(MobileBy.xpath(xpath)).getText() + " ";
                result = result + text;
            }
        }
        return result;
    }

    public StoreDetailPage(WebDriver driver) {
        super(driver);
    }
}
