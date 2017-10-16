package com.qualitestgroup.serenity.cucumber.features.stepdefinitions;

import com.qualitestgroup.serenity.cucumber.features.pages.BasePageClass;
//import com.qualitestgroup.serenity.cucumber.features.steps.LoginSteps;
import com.qualitestgroup.serenity.cucumber.features.steps.OnboardingSteps;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.StepDefinition;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OnboardingStepDefinitions {

    public static final Logger LOGGER = LoggerFactory.getLogger(OnboardingSteps.class);

    @Steps
    OnboardingSteps onboardingSteps;

    @Before
    public  void setPlatform() {
        String platform =  System.getProperty("testEnvironment");
        LOGGER.info("The platform is " + platform);
        if (platform.compareToIgnoreCase("android") == 0) {
            BasePageClass.setAndroid(true);
            BasePageClass.setIOS(false);
        }
        else {
            BasePageClass.setAndroid(false);
            BasePageClass.setIOS(true);
        }
    }

    @Given("^I am at the Splash page$")
    public void iAmOnTheSplashPage(){
        LOGGER.info("Verifying I am on the Splash page");
        onboardingSteps.verifySplashPageShown();
    }

    @Given("^I start the onboarding process$")
    public void iStartTheOnboardingProcess(){
        LOGGER.info("Starting Onboarding process");
        onboardingSteps.startOnboardingProcess();
    }

    @When("^I decline the (.*) option$")
    public void iDeclineAnOption(String optionName){
        LOGGER.info("Declining the " +optionName+ " onboarding option...");
        onboardingSteps.decline(optionName);
    }

    @Then("^I see the (.*) store on the homepage$")
    public void iSeeTheDefaultStoreOnTheHomepage(String storeName) {
        LOGGER.info("Verify default store at top of home screen");
        onboardingSteps.verifyStoreOnHomepage(storeName);
    }

}
