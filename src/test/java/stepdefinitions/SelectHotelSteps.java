package stepdefinitions;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SearchHotelPage;
import pages.SelectHotelPage;
import utils.TextContext;

public class SelectHotelSteps {

	@Given("user searches hotel with location {string}, hotel {string}, room type {string}, rooms {string}, check-in {string}, check-out {string} and adults-per-room {string}")
	public void user_searches_hotel_with_location_hotel_room_type_rooms_check_in_and_check_out(String location,
			String hotel, String roomType, String numOfRoms, String checkIn, String checkOut, String adultsPerRoom) {

		// Store expected data
		TextContext.location = location;
		TextContext.hotel = hotel;
		TextContext.roomType = roomType;
		TextContext.numOfRooms = numOfRoms;
		TextContext.checkInDate = checkIn;
		TextContext.checkOutDate = checkOut;
		TextContext.adultsPerRoom = adultsPerRoom;

		// Enter same data into application

		SearchHotelPage searchHotelPage = new SearchHotelPage();

		searchHotelPage.selectcLocation(location);
		searchHotelPage.selectHotel(hotel);
		searchHotelPage.roomType(roomType);
		searchHotelPage.checkInDate(checkIn);
		searchHotelPage.checkOutDate(checkOut);
		searchHotelPage.selectNumberOfRooms(numOfRoms);
		searchHotelPage.selectAdultsPerRoom(adultsPerRoom);
		searchHotelPage.clickSearch();

	}

	@Then("searched hotel details should be displayed correctly on the Select Hotel page")
	public void searched_hotel_details_should_be_displayed_correctly_on_the_select_hotel_page() {

		SelectHotelPage selectHotelPage = new SelectHotelPage();

		Assertions.assertEquals(TextContext.hotel, selectHotelPage.getHotelName());
		Assertions.assertEquals(TextContext.location, selectHotelPage.getHotelLocation());

		String expectedRooms = TextContext.numOfRooms.split(" - ")[0] + " Rooms";

		Assertions.assertEquals(expectedRooms, selectHotelPage.getNumOfRooms());
		Assertions.assertEquals(TextContext.checkInDate, selectHotelPage.getCheckInDate());
		Assertions.assertEquals(TextContext.checkOutDate, selectHotelPage.getCheckOutDate());
		Assertions.assertEquals(TextContext.roomType, selectHotelPage.getRoomType());
	}

	@Then("total price should be calculated correctly")
	public void total_price_should_be_calculated_correctly() {
		
		SelectHotelPage selectHotelPage = new SelectHotelPage();
		
		String[] rooms = selectHotelPage.getNumOfRooms().split(" ");
		int numOfRooms = Integer.parseInt(rooms[0]);
		
		String[] roomPrice = selectHotelPage.getPricePerNight().split(" ");
		int roomPricePerNight = Integer.parseInt(roomPrice[2]);
		
		String[] totalPrice = selectHotelPage.getTotalPrice().split(" ");
		int expectedTotalPrice = Integer.parseInt(totalPrice[2]);
		
		int actualTotalPrice = numOfRooms-roomPricePerNight;
		
		Assertions.assertEquals(actualTotalPrice, expectedTotalPrice);

		
		
		
	}

}
