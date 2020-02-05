Feature: Verify Admin View Tab Functionality Of Traffic Homepage

  Background: User Has Traffic Homepage Access
    Given Launch browser and Application
    When  Navigate to Admin view Tab

  @Sanity
  Scenario: Validate All Widget Of Admin View Tab
    Then  Validate All widget of Admin View tab

  @Sanity
  Scenario: Verify  Channel Responsibilities Widget Column name
     Then  Verify That Channel Responsibilities Contain Following Column
      |DATE|
      |CHANNEL TERRITORY|
      |USER NAME|


  @Sanity
  Scenario: Verify  Channel Asingh  Pass#12345
  Responsibilities Widget contain minimum Five Records
    And   Set Date as "01 JAN 2020" and "31 JAN 2020" in Channel Responsibilities
    And   Click On View Button
    Then  Channel Responsibilities Widget Contain Minimum <5> Records


  @Sanity
  Scenario: Verify Auto_Generate Functionalities of Channel Responsibilites screen
    And   Set Date as "01 JAN 2020" and "15 JAN 2020" in Channel Responsibilities
    And   Click On View All/Update Button
    And   Click On AutoGenerate Button
    Then  Verify The System Warning Message_And_Confirm
    Then  Corresponding Data Should be Generated


  @Sanity
  Scenario: Verify Channel Responsibilities Widget Total View Record Count
    And   Set Date as "01 Mar 2019" and "15 Mar 2019" in Channel Responsibilities
    And   Click On View Button

  @Sanity
  Scenario: Verify View All/Update Channel Responsibilities Widget
    And   Set Date as "01 Mar 2019" and "30 Mar 2019" in Channel Responsibilities
    And   Click On View All/Update Button
    Then  Corresponding Data Should be populated


  @Sanity
  Scenario: Verify Update Username in channel Responsibilites  Screen
    And   Set Date as "01 Mar 2019" and "15 Mar 2019" in Channel Responsibilities
    And   Click On View All/Update Button
    Then  ViewAll channel Responsibilites Screen Open
    And   Select an user as "Lisa Aldred" and Save
    Then  Verify that "Lisa Aldred" display in View Mode
    And   Verify that "Lisa Aldred" display in ViewAll Mode


