Feature: HomePageFeature

  #Products Manager
  Scenario: Verify number of Products in Manager Page
    Given I navigate to the HomePage
    When Navigate to Products Manager Page
    Then I should see 4 Products to Edit

  Scenario: Verify new Product created in Product Manager Page
    Given I navigate to the HomePage
    When  Navigate to Products Manager Page
    And Create a new Product
    Then I should see the new Product

  Scenario: Verify edit  Product created in Product Manager Page
    Given I navigate to the HomePage
    When  Navigate to Products Manager Page
    And Edit a created a Product
    Then  I should see the new information of the new Product

  Scenario: Verify delet Product created in Product Manager Page
    Given I navigate to the HomePage
    When  Navigate to Products Manager Page
    And Delete a created a Product
    Then  I shouldn't the new information of the new Product



    #Products Customer
  Scenario: Verify number of Products in Customer Page
    Given I navigate to the HomePage
    When  Navigate to Products Customer Page
    Then I should see 4 Products to Book

  Scenario: Verify new booking created in Booking Customer Page
    Given I navigate to the HomePage
    When  Navigate to Products Customer Page
    And  Book a product
    Then  I should see the new User Booking

  #Booking Customer Scenarios
  Scenario: Verify number of Booking in Booking Customer Page
    Given I navigate to the HomePage
    When  Navigate to Booking Customer Page
    Then I should see 4 Bookings to Book

  Scenario: Verify edit created Booking in Booking Customer Page
    Given I navigate to the HomePage
    When  Navigate to Booking Customer Page
    And  Edit a created a Booking of a product
    Then  I should see the new information of the Booking

  Scenario: Verify cancel created Booking in Booking Customer Page
    Given I navigate to the HomePage
    When  Navigate to Booking Customer Page
    And  Cancel the created Booking of a product
    Then  I should see the new status of the Booking

  #Booking Manager Scenarios
  Scenario: Verify number of Booking in Booking Manager Page
    Given I navigate to the HomePage
    When  Navigate to Booking Manager Page
    Then I should see 4 Bookings to Edit

  Scenario: Verify Aprovve booking in Booking Manager Page
    Given I navigate to the HomePage
    When  Navigate to Booking Manager Page
    And  Approve a Booking
    Then  I should see the approve Status of the booking

  Scenario: Verify Reject booking in Booking Manager Page
    Given I navigate to the HomePage
    When  Navigate to Booking Manager Page
    And  Reject a Booking
    Then  I should see the reject Status of the booking

  Scenario: Verify Close booking in Booking Manager Page
    Given I navigate to the HomePage
    When  Navigate to Booking Manager Page
    And  Close a Booking
    Then  I should see the close Status of the booking


  #Users Scenarios
  Scenario: Verify number of Users in Users Page
    Given I navigate to the HomePage
    When  Navigate to User Page
    Then I should see 3 Users

  Scenario: Verify new User created in Users Page
    Given I navigate to the HomePage
    When  Navigate to User Page
    And  Create a new User
    Then I should see the new User

  Scenario: Verify edit created User in Users Page
    Given I navigate to the HomePage
    When  Navigate to User Page
    And  Edit a created User
    Then I should the new information of the User

  Scenario: Verify delet created User in Users Page
    Given I navigate to the HomePage
    When  Navigate to User Page
    And  Delete the created User
    Then I shouldn't the new information of the User


  #BookStore Scenarios
  Scenario: Verify number of Stores in Store Page
    Given I navigate to the HomePage
    When  Navigate to Store Page
    Then I should see 3 Stores

  Scenario: Verify new Store created in Store Page
    Given I navigate to the HomePage
    When  Navigate to Store Page
    And  Create a Store
    Then I should see the new Store

  Scenario: Verify edit created Store in Store Page
    Given I navigate to the HomePage
    When  Navigate to Store Page
    And  Edit a created  Store
    Then I should the new information of Store

  Scenario: Verify delet created Store in Store Page
    Given I navigate to the HomePage
    When  Navigate to Store Page
    And  Delete the created Store
    Then I shouldn't the new information of the created Store