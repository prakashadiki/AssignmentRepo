package trip_advisor;

import org.testng.annotations.Test;

import com.task.genericLib.BaseClass;
import com.task.objectRepository.assign2.TripAdvisorPage;

public class TripAdvisorTest extends BaseClass{

	@Test
	public void rateTripAdvisorTest() throws Throwable {
		
		/* Navigating to TripAdvisorPage */
		TripAdvisorPage tripadvisor = new TripAdvisorPage(BaseClass.driver);
		
		/* search for Hotel */
		tripadvisor.search("Sheet1", 7, 0);
		
		/* Navigating to searched hotel details */
		tripadvisor.getSearchDetails();
		
		/* Navigating to hotel review Page */
		tripadvisor.reviewClick("Sheet1", 7, 1);
		
		/* Enter details and give ratings */
		tripadvisor.reviewTitle("Sheet1", 7, 2);
		tripadvisor.clickonRating();
		tripadvisor.yourReview("Sheet1", 7, 3);
		tripadvisor.clickOnHotelRatings();
		
		
		/* Submit Review */
		tripadvisor.submitReview();
		
	}
	
	
	
	
	
}
