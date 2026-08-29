@SelectHotel
Feature: AdactIn Select Hotel

  Background:
    Given user is logged into the Adactin application

  Scenario Outline: Verify searched hotel details are displayed correctly on Select Hotel page

    Given user searches hotel with location "<location>", hotel "<hotel>", room type "<roomType>", rooms "<rooms>", check-in "<checkInDate>", check-out "<checkOutDate>" and adults-per-room "<adultsPerRoom>"

    Then searched hotel details should be displayed correctly on the Select Hotel page

    Examples:
      | location | hotel       | roomType | rooms  | checkInDate | checkOutDate | adultsPerRoom |
      | Sydney   | Hotel Creek | Standard | 2 - Two | 27/08/2067 | 28/08/2067  | 2 - Two       |
      
      
   @TotalPriceCalculationInSelectedHotel
   Scenario Outline: Verify total price calculation on Select Hotel page

    Given user searches hotel with location "<location>", hotel "<hotel>", room type "<roomType>", rooms "<rooms>", check-in "<checkInDate>", check-out "<checkOutDate>" and adults-per-room "<adultsPerRoom>"

    Then total price should be calculated correctly

    Examples:
      | location | hotel       | roomType | rooms  | checkInDate | checkOutDate | adultsPerRoom |
      | Sydney   | Hotel Creek | Standard | 2 - Two | 27/08/2067 | 28/08/2067  | 2 - Two       |