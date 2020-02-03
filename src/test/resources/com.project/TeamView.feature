Feature: Verify  Team View Functionality of Traffic Homepage

  Background: User Has Traffic Homepage Access
    Given Launch browser and Application
    When  User In TeamView Tab

   @Sanity
    Scenario: Verify Traffic Homepage Title
    Then  Validate Traffic Homepage Title

   @Sanity
    Scenario: Verify Refresh Button Should Available
    Then  Verify Refresh Button Should Available

   @Sanity
    Scenario: Validate All Widget of Team View tab
     When "Asit Singh" Has Access of Traffic Homepage
      Then  Verify That Team View Tab Has Following Widgets
         #Worklist
         #Channel Progress
         #ReserveList
         #Copy Assignment
         #Copy Approved Delivered
         #Copy Summary
         #Outstanding As RunLogs
         #Product Awaiting Approval
         #CRI Pending For Processing
         #Contentious Programme

    @Sanity
    Scenario: Validate Top Menu Item of Team View Tab
    Then  Verify that Team View Tab Contain Following Menu
      |SET UP|
      |FIND|
      |ACTION|
      |SEQUENCE BREAKS|
      |GENERATE PLAYLISTS|
      |APPLICATION|

   @Sanity
    Scenario: Verfiy Sub-Menu Of Set up
      And   Click on Set Up Menu
      Then  Verify Sub-Menu Of Setup Menu
        #New Copy
        #New Rotation
        #Process Companies


   @Sanity
    Scenario: Verify Sub-Menu Of Find
      And   Click on Find Menu
      Then  Verify Sub-Menu Of Find Menu
        #FIND ROTATION
        #FIND CRI
        #Find Break
        #Find Copy
        #Find Product
        #Fins Spot
        #Find Traffic Super Advanced
        #Find Common Rotations

   @Sanity
    Scenario: Validate Action Menu contain sub menu
      And   Click on Action Menu
      Then  Verify Sub-Menu Of Action Menu
        #ASSIGN COPY
        #ASSIGN CREDIT COPY
        #AMEND AIRTIME STATUS
        #GENERATE TRANSMISSION LOG
        #CERTIFICATE VIOLATION – COPY
        #CERTIFICATE VIOLATION – PRODUCT
        #Request Privilege

   @Sanity
    Scenario: Verify The Sub-menu Of Application Menu
      And   Click on Application Menu
      Then  Verify Sub-Menu Of Application Menu
        #ADSTREAM
        #HONEYCOMB
        #COPYCENTRAL

