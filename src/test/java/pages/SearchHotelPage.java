package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import driver.DriverFactory;
import utils.WaitUtils;

public class SearchHotelPage {

	private final WebDriver driver;

	public SearchHotelPage() {
		driver = DriverFactory.getDriver();
	}

	// ===================== Locators =======================

	private final By location = By.xpath("//select[@id='location']");
	private final By hotel = By.xpath("//select[@id='hotels']");
	private final By roomType = By.xpath("//select[@id='room_type']");
	private final By numberOfRoom = By.xpath("//select[@id='room_nos']");
	private final By checkInDate = By.xpath("//input[@id='datepick_in']");
	private final By checkOutDate = By.xpath("//input[@id='datepick_out']");
	private final By adultPerRoom = By.xpath("//select[@id='adult_room']");
	private final By searchButton = By.xpath("//input[@id='Submit']");

	// ===============loggedInUserName==============================
	private final By loggedInUserName = By.xpath("//input[@value='Hello pradeep2000!']");

	// ===================== Error Locators =====================
	private final By locationError = By.xpath("//span[@id='location_span']");
	private final By numberOfRoomsError = By.xpath("//span[@id='num_room_span']");
	private final By checkInDateError = By.xpath("//span[@id='checkin_span']");
	private final By checkOutDateError = By.xpath("//span[@id='checkout_span']");
	private final By adultsPerRoomError = By.xpath("//span[@id='adults_room_span']");

	// ===================== Page Actions =====================

	public void selectcLocation(String locationName) {
		WebElement locationElement = WaitUtils.waitForElementVisible(driver, location);

		Select select = new Select(locationElement);
		select.selectByVisibleText(locationName);
	}

	public void selectHotel(String hotelName) {
		WebElement hotelElement = WaitUtils.waitForElementVisible(driver, hotel);
		Select select = new Select(hotelElement);
		select.selectByVisibleText(hotelName);
	}

	public void roomType(String RoomType) {
		WebElement roomTypeElement = WaitUtils.waitForElementVisible(driver, roomType);
		Select select = new Select(roomTypeElement);
		select.selectByVisibleText(RoomType);
	}

	public void selectNumberOfRooms(String NumberOfRooms) {
		WebElement numberOfRooms = WaitUtils.waitForElementVisible(driver, numberOfRoom);
		Select select = new Select(numberOfRooms);
		select.selectByVisibleText(NumberOfRooms);
	}

	public void checkInDate(String CheckInDate) {
		WebElement checkInDateElement = WaitUtils.waitForElementVisible(driver, checkInDate);
		checkInDateElement.clear();
		checkInDateElement.sendKeys(CheckInDate);
	}

	public void checkOutDate(String CheckOutDate) {
		WebElement checkOutDateElement = WaitUtils.waitForElementVisible(driver, checkOutDate);
		checkOutDateElement.clear();
		checkOutDateElement.sendKeys(CheckOutDate);
	}

	public void selectAdultsPerRoom(String numOfAdults) {
		WebElement adultPerRoomElement = WaitUtils.waitForElementVisible(driver, adultPerRoom);
		Select select = new Select(adultPerRoomElement);
		select.selectByVisibleText(numOfAdults);
	}

	public String getLoggedInUserName() {
		return WaitUtils.waitForElementVisible(driver, loggedInUserName).getAttribute("value").substring(6, 17);
	}

	public void clickSearch() {
		WebElement searchButtonElement = WaitUtils.waitForElementClickable(driver, searchButton);
		searchButtonElement.click();
	}

	// ===================== Validation Methods =====================
	public String getLocationError() {
		return WaitUtils.waitForElementVisible(driver, locationError).getText();
	}

	public String getNumberOfRoomsError() {
		return WaitUtils.waitForElementVisible(driver, numberOfRoomsError).getText();
	}

	public String getCheckInDateError() {
		return WaitUtils.waitForElementVisible(driver, checkInDateError).getText();
	}

	public String getCheckOutDateError() {
		return WaitUtils.waitForElementVisible(driver, checkOutDateError).getText();
	}

	public String getAdultsPerRoomError() {
		return WaitUtils.waitForElementVisible(driver, adultsPerRoomError).getText();
	}

	public String getPageTitle() {

		return driver.getTitle();
	}

}
