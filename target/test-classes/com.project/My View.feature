Feature: Verify  My view Tab Functionality Of Traffic Homepage

     Background: User Has Traffic Homepage Access
      Given Launch browser and Application
      When  Navigate to My View Tab

   @Sanity
    Scenario: Validate all widget of MyView tab
      When "Asit Singh" Has Access of Traffic Homepage
      Then  Verify That My View Tab Has Following Widgets
       #Worklist
       #Channel Progress
       #Copy Assignment
       #ReserveList
       #Copy Approved Delivered
       #Chaneel/Channel Group Responsibilities
       #My Channel
       #Contentious Programme
       #Copy Summary

    @Sanity
    Scenario: Validate Top Menu Item of My View Tab
      Then  Verify That My View Tab Has Following Menu
        |Set Up|
        |FIND|
        |ACTION|
        |SEQUENCE BREAKS|
        |GENERATE PLAYLISTS|
        |Application|

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



