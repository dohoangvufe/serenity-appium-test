@Complete
Feature: App Access
  As a Total Wine app user, I would like to get to the home screen.

  @login
  Scenario: Proceed through the onboarding pages to the home screen
    Given I am at the Splash page
    When I start the onboarding process
    And I decline the Location option
    And I decline the Notification option
    And I decline the Loyalty option
    Then I see the default store on the homepage

