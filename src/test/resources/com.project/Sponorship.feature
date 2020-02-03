Feature: Verify The Sponorship Tab Functionalities

  Background: User Has Traffic Homepage Access
   Given Launch browser and Application
   When  Navigate To sponorship tab

  @Sanity
  Scenario: Validate Top Menu Item Of Sponorship Tab
    Then  Verify That Sponorship Tab Contain Following Menu
    |FIND|
    |APPLICATION|

  @Sanity
  Scenario: Verfiy Sub-Menu Of Sponorship Find
    And   Click on Find  Menu Of Sponorship Tab
    Then  Verify The Sub-Menu Of Sponorship Find Menu
    #LFT BREAKS WITH AVAILABILITY
    #LFT BREAKS WITH CERTIFICATE

   @Sanity
   Scenario: Verify The Sub-menu Of Application Menu
    And   Click on Application Menu Of Sponorship Tab
    Then  Verify Sub-Menu Of Sponorship Application Menu
    #ADSTREAM
    #HONEYCOMB
    #COPYCENTRAL

  @Sanity
  Scenario: Validate All Widget of Sponorship tab
    When "Asit Singh" Has Access of Traffic Homepage
    Then  Verify That Sponorship Tab Has Following Widgets
       #Sponorship Credits And Breaks
       #Final Credit Pattern
       #Sponorship Campaigns
