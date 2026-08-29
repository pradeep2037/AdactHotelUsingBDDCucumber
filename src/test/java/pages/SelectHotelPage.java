package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import driver.DriverFactory;
import utils.WaitUtils;

public class SelectHotelPage {

	private final WebDriver driver;

	public SelectHotelPage() {
		driver = DriverFactory.getDriver();
	}

//	=================//locators====================
	private final By hotelName = By.xpath("//input[@id='hotel_name_0']");
	private final By location = By.xpath("//input[@id='location_0']");
	private final By checkInDate = By.xpath("//input[@id='arr_date_0']");
	private final By checkOutdate = By.xpath("//input[@id='dep_date_0']");
	private final By numOfRooms = By.xpath("//input[@id='rooms_0']");
	private final By roomType = By.xpath("//input[@id='room_type_0']");
	private final By adultsPerRoom = By.xpath("//select[@id='adult_room']");
	private final By pricePerNight = By.xpath("//input[@id='price_night_0']");
	private final By totalPrice = By.xpath("//input[@id='total_price_0']");

	// ===================== Page Actions =====================

	public String getHotelName() {
		return WaitUtils.waitForElementVisible(driver, hotelName).getAttribute("value");
	}

	public String getHotelLocation() {
		return WaitUtils.waitForElementVisible(driver, location).getAttribute("value");
	}
	
	public String getCheckInDate() {
		return WaitUtils.waitForElementVisible(driver, checkInDate).getAttribute("value");
	}
	
	public String getCheckOutDate() {
		return WaitUtils.waitForElementVisible(driver, checkOutdate).getAttribute("value");
	}
	
	public String getNumOfRooms() {
		return WaitUtils.waitForElementVisible(driver, numOfRooms).getAttribute("value");
	}
	
	public String getRoomType() {
		return WaitUtils.waitForElementVisible(driver, roomType).getAttribute("value");
	}
	
	public String getPricePerNight() {
		return WaitUtils.waitForElementVisible(driver, pricePerNight).getAttribute("value");
	}
	
	public String getTotalPrice() {
		return WaitUtils.waitForElementVisible(driver, totalPrice).getAttribute("value");
	}

}
