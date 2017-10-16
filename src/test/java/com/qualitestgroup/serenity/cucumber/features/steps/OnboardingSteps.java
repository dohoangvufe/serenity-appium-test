package com.qualitestgroup.serenity.cucumber.features.steps;

import com.qualitestgroup.serenity.cucumber.features.pages.*;
import io.appium.java_client.AppiumDriver;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class OnboardingSteps extends ScenarioSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnboardingSteps.class);

    private SplashPage splashPage;
    private LocationPage locationPage;
    private NotificationPage notificationPage;
    private LoyaltyPage loyaltyPage;
    private MyStoreHeader myStoreHeader;

    @Step
    public void verifySplashPageShown(){
//        WebDriver driver = getDriver();
//        splashPage = new SplashPage((AppiumDriver)driver);
        LOGGER.info("Verifying Splash page is displayed.");
        assertTrue("Start button not displayed!", splashPage.isStartButtonPresent());
    }

    @Step
    public void decline(String option){
        switch (option) {
            case "Location":
                LOGGER.info("Declining on " +option+ " page...");
                locationPage.clickDeclineLink();
                break;
            case "Notification":
                LOGGER.info("Declining on " +option+ " page...");
                notificationPage.clickDeclineLink();
                break;
            case "Loyalty":
                LOGGER.info("Declining on " +option+ " page...");
                loyaltyPage.clickDeclineLink();
                break;
            default:
                throw new IllegalStateException("Unknown onboarding option = " + option);
        }
    }

//    public void verifyLoggedIn() {
//        String myGoodybagsSection = mygiffgaffAccountPage.getTextForSection(0);
//        assertThat(myGoodybagsSection).as("Member is not logged in").containsIgnoringCase("my goodybags");
//    }
//
    public void startOnboardingProcess() {
        LOGGER.info("Clicking Start button on Splash page...");
        splashPage.clickStartButton();
    }

    public void verifyStoreOnHomepage(String storeName) {
        String actualTitle = myStoreHeader.getTouchableStoreDataTitle();
        assertThat(actualTitle.contains(storeName));
    }
}
