package amazon_flipkart;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.task.genericLib.BaseClass;
import com.task.objectRepository.assign1.AmazonPage;
import com.task.objectRepository.assign1.FlipkartPage;

public class Amazon_FlipkartTest extends BaseClass {

	@Test
	public void comparePriceTest() throws Throwable {
		
		/* Navigating to Amazon */
		AmazonPage amazon = new AmazonPage(BaseClass.driver);
		
		/* Search for product */
		amazon.searchProduct("Sheet1", 1, 0);
		
		/* get the price of a product */
		int amazonPrice = amazon.priceOfProduct();
		
		/* navigating to flipkart */
		FlipkartPage flipkart = new FlipkartPage(BaseClass.driver);
		
		/* Search for product */
		flipkart.searchProduct("Sheet1", 4, 0);
		
		/* get the price of a product */
		int flipkartPrice = flipkart.priceOfProduct();
		
		/* Compare the price from amazon and flipkart and display it in console */
		if(amazonPrice > flipkartPrice) {
			Reporter.log("Flipkart has Lesser Price than Amazon", true);
			Reporter.log("Price : "+flipkartPrice, true);
		}else if (amazonPrice < flipkartPrice) {
			Reporter.log("Amazon has Lesser Price than flipkart", true);
			Reporter.log("Price : "+amazonPrice, true);
		}else {
			Reporter.log("Amazon and Flipkart Both have same price", true);
		}
		
		
	}
}
