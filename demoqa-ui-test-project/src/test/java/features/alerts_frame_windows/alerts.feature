Feature: Handling Alerts

  Scenario: Handling a simple alert
    Given the user is on the Alerts page
    When the user clicks the Click me button to trigger a simple alert
    Then an alert should appear with the message "You clicked a button"
    When the user clicks the Click me button to trigger a timed alert
    Then after 5 seconds an alert should appear with the message This alert appeared after 5 seconds
    When the user clicks the Click me button to trigger a confirmation alert
    And the user accepts the alert

