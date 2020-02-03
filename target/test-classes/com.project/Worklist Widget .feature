Feature: Verify Worklist Widget Functionalities Of Team View Tab

  Background: User Has Traffic Homepage Access
    Given Launch browser and Application

  @Sanity
  Scenario: Validate Column Name In Worklist Widget
     When  User In Team View Tab and Select Worklist Widget
     Then  Verify That Worklist Widget Have Following Column Name
      |CRI ID|
      |VERSION|
      |EFFECTIVE DATE|
      |CRI CLIENT|
      |CRI PRODUCT|
      |PRODUCT CODE|
      |PRODUCT NAME|
      |SPOT LENGTH|
      |CRI START DATE|
      |CRI END DATE|
      |CRI STATUS|
      |RECEIVED ON|
      |ASSIGNEE|
      |        |


  @Sanity
  Scenario: Verify Assignee Name in Worklist Widget
    When  User In Team View Tab and Select Worklist Widget
    And   Select an Assign "Hannah Forrest"
    When  Click on Third Row
    And   Click on Assign Button
    Then  Verify that "Hannah Forrest" selected as Assign name in worklist third record

  @Sanity
    Scenario: Worklist Record Remove From The WorkList
    When  User In Team View Tab and Select Worklist Widget
    When  Click on Third Row
    And   Click on RemoveFromList Button
    Then  Then CRI Remove From Worklist




