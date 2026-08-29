@SearchHotel
Feature: AdactIn Search Hotel

  Background: 
  Given user is logged into the Adactin application

  Scenario Outline: Verify search hotel with <type> details

    When user selects location "<location>"
    And user selects hotel "<hotel>"
    And user selects room type "<roomType>"
    And user selects number of rooms "<numberOfRooms>"
    And user enters check-in date "<checkInDate>"
    And user enters check-out date "<checkOutDate>"
    And user selects adults per room "<adultsPerRoom>"
    And user clicks the Search button
    Then user should verify "<expectedResult>"

    Examples:
      | type                                                   | location | hotel       | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | expectedResult |
      | Valid details                                          | Sydney   | Hotel Creek | Standard | 2 - Two       | 27/08/2067  | 28/08/2067   | 2 - Two       | Adactin.com - Select Hotel |
      | Verifying search hotel without location                |          | Hotel Creek | Standard | 2 - Two       | 27/08/2067  | 28/08/2067   | 2 - Two       | Please Select a Location |
      | Verifying search hotel without selecting no. of rooms  | Sydney   | Hotel Creek | Standard | - Select Number of Rooms -  | 27/08/2067  | 28/08/2067   | 2 - Two       | Please Select Total Number of Rooms |
      | Verifying search hotel entering past check-in date earlier than the current-date    | Sydney   | Hotel Creek | Standard | 2 - Two       | 25/08/2026  | 28/08/2067   | 2 - Two | Check-In Date should be either Today or Later Date |
      | Verifying checkout date before check-in date           | Sydney   | Hotel Creek | Standard | 2 - Two       | 27/08/2067  | 26/08/2067   | 2 - Two       | Check-Out Date shall be after than Check-In Date |
      | Verifying search hotel without adults per room         | Sydney   | Hotel Creek | Standard | 2 - Two       | 27/08/2067  | 28/08/2067   |    - Select Adults per Room -           | Please Select Adults per Room |
      
      
      
@UsernameValidation
Scenario: Verify logged-in username is displayed on Search Hotel page
Then User should see username "pradeep2000" on the Search Hotel page 


