Feature: Verify CRI Pending For Processing Widget Of Team View Tab

  Background: User Has Traffic Homepage Access
    Given Launch browser and Application
    When  User In TeamView Tab
    And   Select Contentious Programme Widget

    Scenario: Verify Column Name Of CRI Pending For Processing Widget
       Then  Verify The Following Column List In Contentious Programme
       |NAME|
       |COUNT|

    Scenario: Verify Data Of CRI Pending For Processing In View Mode
       And   Click On View button
       Then  Verify That Total <5> Records Display when NextPage Button is Enable
       Then  Verify that <"NAME"> Column contain User As <"Sven Alexander">

    Scenario: Verify Data Of Contentious Programme Widget In View All Mode
      And   Click On View All button
      And   View All Verify that <""> Column contain User As <"Sven Alexander">
