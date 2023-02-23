Feature: searchbox

  Scenario: verify search box
    Given open browser
    Then launch site "https://www.google.com"
    Then search a word "starship"
    When page title shoud be "starship"
    Then close site

 