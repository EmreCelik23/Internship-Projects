Feature: This feature includes tests for getting access to Sirv by token

  Scenario: Getting token
    Given url "https://api.sirv.com/v2/token"
    * def requestBody =
    """
    {
      "clientId": #(myClientId),
      "clientSecret": #(myClientSecret)
    }
    """
    * configure retry = {count: 5, interval: 1000}
    * retry until responseStatus == 200
    And request requestBody
    When method POST
    Then status 200
    And match response.token == '#present'
    And match response.expiresIn == 1200