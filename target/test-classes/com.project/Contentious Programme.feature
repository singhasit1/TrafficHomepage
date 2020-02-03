Feature: Verify Contentious Programme Widget Of Team View Tab

  Background: User Has Traffic Homepage Access
    Given Launch browser and Application

  @Sanity
  Scenario: Verify Column Name Of Contentious Programme Widget
    When  User In Team View Tab
    Then  Verify The Following Column List In Contentious Programme
    |CONTRACT NO|
    |EPISODE NO|
    |SCHEDULED EPISODE NAME|
    |TRANSMISSION DATES|


  @Sanity
  Scenario: Verify Data Of Contentious Programme Widget In View Mode
    Given Launch browser and Application
    When  User In Team View Tab
    And   User Set Date Range As "27 Aug 2018" and "31 Aug 2018" in Contentious Programme Widget
    And   Click On View button
    Then  Verify That Total <5> Records Display when NextPage Button is Enable
    And   Verify that Transmission Dates should be "31 Aug 2018"


  @Sanity
  Scenario: Verify Data Of Contentious Programme Widget In View All Mode
    Given Launch browser and Application
    When  User In Team View Tab
    And   User Set Date Range As "27 Aug 2018" and "31 Aug 2018" in Contentious Programme Widget
    And   Click On View All button
    Then  Verify That Transmission Date should be contain date as "31 Aug 2018"










