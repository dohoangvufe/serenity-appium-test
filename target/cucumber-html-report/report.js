$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/login/login.feature");
formatter.feature({
  "line": 2,
  "name": "App Access",
  "description": "As a Total Wine app user, I would like to get to the home screen.",
  "id": "app-access",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Complete"
    }
  ]
});
formatter.before({
  "duration": 129590610,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Proceed through the onboarding pages to the home screen",
  "description": "",
  "id": "app-access;proceed-through-the-onboarding-pages-to-the-home-screen",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@login"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "I am at the Splash page",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I start the onboarding process",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "I decline the Location option",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I decline the Notification option",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I decline the Loyalty option",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I see the default store on the homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "OnboardingStepDefinitions.iAmOnTheSplashPage()"
});
formatter.result({
  "duration": 67487280060,
  "status": "passed"
});
formatter.match({
  "location": "OnboardingStepDefinitions.iStartTheOnboardingProcess()"
});
formatter.result({
  "duration": 672168819,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Location",
      "offset": 14
    }
  ],
  "location": "OnboardingStepDefinitions.iDeclineAnOption(String)"
});
formatter.result({
  "duration": 12256201000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Notification",
      "offset": 14
    }
  ],
  "location": "OnboardingStepDefinitions.iDeclineAnOption(String)"
});
formatter.result({
  "duration": 15668862376,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Loyalty",
      "offset": 14
    }
  ],
  "location": "OnboardingStepDefinitions.iDeclineAnOption(String)"
});
formatter.result({
  "duration": 12649202753,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "default",
      "offset": 10
    }
  ],
  "location": "OnboardingStepDefinitions.iSeeTheDefaultStoreOnTheHomepage(String)"
});
formatter.result({
  "duration": 421172056,
  "status": "passed"
});
});