package stepdefinitions;

import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.SearchHotelPage;

public class SearchHotelSteps {

	private SearchHotelPage hotelpage;

	@Given("user is logged into the Adactin application")
	public void user_is_logged_into_the_adactin_application() {

		LoginPage loginpage = new LoginPage();
		loginpage.login("pradeep2000", "1A3VTX");
		hotelpage = new SearchHotelPage();
	}

	@When("user selects location {string}")
	public void user_selects_location(String location) {
		if (!location.isBlank()) {
			hotelpage.selectcLocation(location);
		}
	}

	@When("user selects hotel {string}")
	public void user_selects_hotel(String hotel) {
		if (!hotel.isBlank()) {
			hotelpage.selectHotel(hotel);
		}
	}

	@When("user selects room type {string}")
	public void user_selects_room_type(String roomType) {

		if (!roomType.isBlank()) {
			hotelpage.roomType(roomType);

		}
	}

	@When("user selects number of rooms {string}")
	public void user_selects_number_of_rooms(String numOfRooms) {

		if (!numOfRooms.isBlank()) {
			hotelpage.selectNumberOfRooms(numOfRooms);
		}

	}

	@When("user enters check-in date {string}")
	public void user_enters_check_in_date(String string) {
		hotelpage.checkInDate(string);
	}

	@When("user enters check-out date {string}")
	public void user_enters_check_out_date(String string) {
		hotelpage.checkOutDate(string);
	}

	@When("user selects adults per room {string}")
	public void user_selects_adults_per_room(String adultPerRoom) {

		if (!adultPerRoom.isBlank()) {
			hotelpage.selectAdultsPerRoom(adultPerRoom);
		}

	}

	@When("user clicks the Search button")
	public void user_clicks_the_search_button() {
		hotelpage.clickSearch();
	}

	@Then("user should verify {string}")
	public void user_should_verify(String expectedResult) {

		switch (expectedResult) {
		case "Adactin.com - Select Hotel": {
			String actualTitle = hotelpage.getPageTitle();
			Assertions.assertEquals(expectedResult, actualTitle);
			break;
		}
		case "Please Select a Location": {
			String locationError = hotelpage.getLocationError();
			Assertions.assertEquals(expectedResult, locationError);
			break;
		}
		case "Please Select Total Number of Rooms": {
			String roomsError = hotelpage.getNumberOfRoomsError();
			Assertions.assertEquals(expectedResult, roomsError);
			break;
		}
		case "Check-In Date should be either Today or Later Date": {
			String checkInDateError = hotelpage.getCheckInDateError();
			Assertions.assertEquals(expectedResult, checkInDateError);
			break;
		}
		case "Check-Out Date shall be after than Check-In Date": {
			String checkOutDateError = hotelpage.getCheckOutDateError();
			Assertions.assertEquals(expectedResult, checkOutDateError);
			break;
		}
		case "Please Select Adults per Room": {
			String adultPerRoomError = hotelpage.getAdultsPerRoomError();
			Assertions.assertEquals(expectedResult, adultPerRoomError);
			break;
		}
		default:
			Assertions.fail("Unknown expected result: " + expectedResult);
		}
	}
	
	
	@Then("User should see username {string} on the Search Hotel page")
	public void user_should_see_username_on_the_search_hotel_page(String expectedUserName) {
	    String actualUserName = hotelpage.getLoggedInUserName();
		Assertions.assertEquals(actualUserName, expectedUserName);
	}
}
