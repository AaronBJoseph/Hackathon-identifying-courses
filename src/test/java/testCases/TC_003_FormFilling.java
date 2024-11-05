package testCases;

import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ForEnterprise;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_FormFilling extends BaseClass {

    public Properties p;

    @Test(dataProvider = "formData", dataProviderClass = DataProviders.class, groups = "regression")
    public void formFilling(String fName, String lName, String email1, String phone1, String title1, String learners, String country1, /*String state1*/ String needs1) {
        try {
            // Log the start of the test case
            logger.info("Starting test case: formFilling");

            // Navigate to Home Page and click "For Enterprise"
            HomePage hp = new HomePage(driver);
            logger.info("HomePage object created");
            hp.clickForEnterprice();
            logger.info("Clicked on 'For Enterprise'");

            // Initialize ForEnterprise page object
            ForEnterprise ep = new ForEnterprise(driver);
            logger.info("ForEnterprisePage object created");

            // Fill the form using data from the DataProvider
            ep.setFirstName(fName);
            logger.info("Set first name: {}", fName);
            ep.setLastName(lName);
            logger.info("Set last name: {}", lName);
            ep.setEmail(email1);
            logger.info("Set email: {}", email1);
            ep.setPhone(phone1);
            logger.info("Set phone: {}", phone1);
            ep.setTitle(title1);
            logger.info("Set title: {}", title1);
            ep.setNoOfLearners(learners);
            logger.info("Set number of learners: {}", learners);
            ep.setCountry(country1);
            logger.info("Set country: {}", country1);
            ep.setNeeds(needs1);
            logger.info("Set needs: {}", needs1);

            // Submit the form
            ep.submitForm();
            logger.info("Form submitted");

            // Take a screenshot of the form submission
            takeScreenshot("form filling");
            logger.info("Screenshot taken for form filling");

            // Get and log the error message
            String errorMsg = ep.getErrorMsg();
            logger.info("Error message: {}", errorMsg);
            System.out.println(errorMsg);

            // Add assertion to check the error message
            Assert.assertTrue(errorMsg.contains("Must be valid email.\nexample@yourdomain.com"), "Error message does not contain expected text");
            logger.info("Assertion passed: Error message contains expected text");

        } catch (Exception e) {
            // Log and fail the test case in case of an exception
            logger.error("An error occurred during the form filling process: ", e);
            Assert.fail("Test case failed due to an exception: " + e.getMessage());
        }
    }
}