package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.WebDevolpmentPage;
import testBase.BaseClass;
import utilities.ExcelUtil;

public class TC_001_SearchingForWebDevolpment extends BaseClass {

    @Test(groups = "regression")
    public void SearchForWebDevelopmentCourses() {
        // Generate a timestamp for unique file naming
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        
        try {
            // Navigate to the home page and perform a search
            HomePage hp = new HomePage(driver);
            hp.search(p.getProperty("searchElement"));
            logger.info("Navigating to Home Page");

            // Initialize Web Development Page object
            WebDevolpmentPage wdp = new WebDevolpmentPage(driver);
            logger.info("Searching for 'Web Development' courses");

            // Prepare file path for Excel output
            String filePath = System.getProperty("user.dir") + "\\OutputData\\Exceloutputfile_1" + timeStamp + ".xlsx";
            String[] headers = {"Course Number", "Title", "Rating", "Length"};
            String[][] data = new String[2][4];  // Array to store course details

            // Check if product is visible, else apply filters
            if (!wdp.isVisibileProduct()) {
                logger.info("No visible product found, applying filters");

                // Apply filters: English and Beginners
                wdp.tickEnglishCheckBox();
                logger.info("English checkbox ticked");
                wdp.tickBeginnersCheckBox();
                logger.info("Beginners checkbox ticked");

                // Loop through first 2 courses and get their details
                for (int i = 0; i < 2; i++) {
                    String title = wdp.getCourseTitle(i);
                    String rating = wdp.getCourseRating(i);
                    String courseLength = wdp.getCourseLength(i);
                    data[i][0] = String.valueOf(i + 1);  // Course Number
                    data[i][1] = title;  // Course Title
                    data[i][2] = rating;  // Course Rating
                    data[i][3] = courseLength;  // Course Length
                    System.out.println("Course " + (i + 1) + ": " + title + "\nRating: " + rating + "\n" + courseLength);
                    logger.info("Course {}: Title: {}, Rating: {}, Length: {}", i + 1, title, rating, courseLength);
                }

                // Take a screenshot of the courses
                takeScreenshot("courses");
                logger.info("Screenshot taken for courses");

            } else {
                // Apply filters: Difficulty and Beginners
                wdp.clickDifficulty();
                logger.info("Visible product found, applying difficulty filter");
                wdp.tickBeginnersCheckBox();
                logger.info("Beginners checkbox ticked");
                wdp.clickResult();
                logger.info("Clicked on result");

                // Loop through first 2 courses and get their details
                for (int i = 0; i < 2; i++) {
                    String title = wdp.getCourseTitle(i);
                    String rating = wdp.getCourseRating(i);
                    String courseLength = wdp.getCourseLength(i);
                    data[i][0] = String.valueOf(i + 1);  // Course Number
                    data[i][1] = title;  // Course Title
                    data[i][2] = rating;  // Course Rating
                    data[i][3] = courseLength;  // Course Length
                    System.out.println("Course " + (i + 1) + ": " + title + "\nRating: " + rating + "\n" + courseLength);
                    logger.info("Course {}: Title: {}, Rating: {}, Length: {}", i + 1, title, rating, courseLength);
                }

                // Take a screenshot of the courses
                takeScreenshot("courses");
                logger.info("Screenshot taken for courses");
            }

            // Write course details to Excel
            ExcelUtil.writeToExcel(filePath, "Web Development Courses", headers, data);

            // Assert visibility of search results
            Assert.assertTrue(wdp.isSearchResultsVisible(), "Search results are not visible");
            logger.info("Assertion passed: Search results are visible");
            logger.info("Test case: SearchForWebDevelopmentCourses completed");

        } catch (Exception e) {
            logger.error("An error occurred during the test case execution: ", e);
            Assert.fail("Test case failed due to an exception: " + e.getMessage());
        }
    }
}
	 