package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_004_Cousera extends BaseClass {

    @Test(groups = {"smoke"})
    public void openCousera() {
        try {
            // Navigate to Home Page
            HomePage hp = new HomePage(driver);

            // Expected title of the page
            String expectedTitle = "Coursera | Online Courses & Credentials From Top Educators. Join for Free";

            // Get the actual title of the page
            String actualTitle = hp.title();

            // Assert that the expected title matches the actual title
            Assert.assertEquals(expectedTitle, actualTitle);

        } catch (Exception e) {
            // If an exception occurs, fail the test case and log the error message
            Assert.fail("Failed to load Cousera " + e.getMessage());
        }
    }
}

