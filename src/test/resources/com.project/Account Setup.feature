Feature: Verify Logged In User for Launch Traffic Application


  @Sanity
  Scenario: Launch Traffic Homepage Without Mapping
    Given  User does not have Mapping
    When Launch browser and Application
    When  User does not have Mapping
    Then  System should warn that "No Stellar User is mapped with ASingh"

  @Sanity
  Scenario: Launch Traffic Homepage With Proper Mapping
    Given User should have proper mapping
    When  Launch browser and Application
    And   Assign Role and Team Name As "Traffic"
    Then  Traffic homepage should Launch and verify user name as "Asit Singh"
