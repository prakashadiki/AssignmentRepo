package com.task.objectRepository.assign2;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.task.genericLib.CommonLibrary;
import com.task.genericLib.FileLib;

/**
 * 
 * @author adikiprakash
 *
 */
public class TripAdvisorPage {

	private WebDriver driver;
	private CommonLibrary common;
	
	FileLib flib = new FileLib();
	
	/**
	 * Intilize TripAdvisorPage
	 * @param driver
	 * @throws Throwable
	 */
	public TripAdvisorPage(WebDriver driver) throws Throwable {
		// TODO Auto-generated constructor stub
		driver.get(flib.getPropertyKeyValue("urlTripAdvisor"));
		PageFactory.initElements(driver, this);
		this.driver = driver;
		common = new CommonLibrary(driver);
	}
	
	@FindBy(xpath = "//div[@title='Search']")
	private WebElement search;
	
	@FindBy(name = "q")
	private WebElement searchInput;
	
	@FindBy(id = "mainSearch")
	private WebElement searchBox;
	
	@FindBy(id = "SEARCH_BUTTON")
	private WebElement searchBtn;
	
	@FindBy(xpath = "(//div[@class='result-title']/span[contains(text(),'Club Mahindra')])[1]")
	private WebElement searchDetail;
	
	@FindBy(linkText = "Write a review")
	private WebElement reviewLnk;
	
	@FindBy(id = "ReviewTitle")
	private WebElement reviewTitleBox;
	
	@FindBy(id = "bubble_rating")
	private WebElement rating;
	
	@FindBy(id = "ReviewText")
	private WebElement yourReviewBox;

	@FindBy(xpath = "//div[text()='Service']/following-sibling::div/div[@class='detailsRatings']")
	private WebElement hotelServiceRating;
	
	@FindBy(xpath = "//div[text()='Location']/following-sibling::div/div[@class='detailsRatings']")
	private WebElement hotelLocationRating;
	
	@FindBy(xpath = "//div[text()='Rooms']/following-sibling::div/div[@class='detailsRatings']")
	private WebElement hotelRoomsRating;
	
	@FindBy(id = "noFraud")
	private WebElement certifyCheckBox;

	@FindBy(id = "SUBMIT")
	private WebElement reviewSubmitBtn;
	
	
	public void reviewTitle(String sheetName, int rowNum, int celNum) throws Throwable {
		String data = flib.getExcelData(sheetName, rowNum, celNum);
		common.waitForPageToLoad();
		reviewTitleBox.sendKeys(data);
	}
	
	
	public void yourReview(String sheetName, int rowNum, int celNum) throws Throwable {
		String data = flib.getExcelData(sheetName, rowNum, celNum);
		common.waitForPageToLoad();
		yourReviewBox.sendKeys(data);
	}
	
	
	public void search(String sheetName, int rowNum, int celNum) throws Throwable {
		String data = flib.getExcelData(sheetName, rowNum, celNum);
		common.waitForPageToLoad();
		
	
		try {
			common.waitAndClick(search);
			searchBox.sendKeys(data);
			searchBtn.click();
			
		} catch (Throwable e) {
			common.waitAndClick(searchInput);
			searchInput.sendKeys(data, Keys.ENTER);
		} 
	
	}
	
	
	public void getSearchDetails() throws Throwable {
		common.waitAndClick(searchDetail);
		
	}
	
	
	public void reviewClick(String sheetName, int rowNum, int celNum) throws Throwable {
		String data = flib.getExcelData(sheetName, rowNum, celNum);
		common.waitForPageToLoad();
		common.switchToChildWindow();
		common.waitForPageToLoad();
		common.waitAndClick(reviewLnk);
		common.waitForPageToLoad();
		common.switchWindow(driver, data);
	}
	
	
	public void clickonRating() throws Throwable {
		common.waitForPageToLoad();
		common.waitAndClick(rating);
		
	}
	
	
	public void clickOnHotelRatings() throws Throwable {
		common.waitForPageToLoad();
		common.waitAndClick(hotelServiceRating);
		common.waitAndClick(hotelLocationRating);
		common.waitAndClick(hotelRoomsRating);
	}
	
	
	public void submitReview() throws Throwable {
		common.waitForPageToLoad();
		common.waitAndClick(certifyCheckBox);
		common.waitAndClick(reviewSubmitBtn);
	}
	
}
