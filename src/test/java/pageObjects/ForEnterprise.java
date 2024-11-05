package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForEnterprise extends BasePage {

    // Constructor to initialize WebDriver
    public ForEnterprise(WebDriver driver) {
        super(driver);
    }

    // Element locators
    @FindBy(id="FirstName") 
    WebElement firstName;  // First Name input field
    
    @FindBy(id="LastName") 
    WebElement lastName;  // Last Name input field
    
    @FindBy(id="Email") 
    WebElement email;  // Email input field
    
    @FindBy(id="Phone") 
    WebElement phone;  // Phone input field
    
    @FindBy(id="Title") 
    WebElement jobTitle;  // Job Title input field
    
    @FindBy(id="Self_reported_employees_to_buy_for__c") 
    WebElement noOfLearners;  // Number of Learners input field
    
    @FindBy(id="Country") 
    WebElement country;  // Country input field
    
    @FindBy(id="State") 
    WebElement state;  // State input field
    
    @FindBy(id="What_the_lead_asked_for_on_the_website__c") 
    WebElement needs;  // Needs input field
    
    @FindBy(xpath="//button[normalize-space()='Submit']") 
    WebElement submitButton;  // Submit button
    
    @FindBy(id="ValidMsgEmail") 
    WebElement errorMsg;  // Error message element

    // Methods to set form fields
    public void setFirstName(String fname) {
        firstName.sendKeys(fname);  // Set First Name
    }

    public void setLastName(String lname) {
        lastName.sendKeys(lname);  // Set Last Name
    }

    public void setEmail(String email1) {
        email.sendKeys(email1);  // Set Email
    }

    public void setPhone(String phone1) {
        phone.sendKeys(phone1);  // Set Phone
    }

    public void setTitle(String title) {
        jobTitle.sendKeys(title);  // Set Job Title
    }

    public void setNoOfLearners(String no_of_learners) {
        noOfLearners.sendKeys(no_of_learners);  // Set Number of Learners
    }

    public void setCountry(String country1) {
        country.sendKeys(country1);  // Set Country
    }

    public void setState(String state) {
        this.state.sendKeys(state);  // Set State
    }

    public void setNeeds(String need) {
        needs.sendKeys(need);  // Set Needs
    }

    // Method to submit the form
    public void submitForm() {
        submitButton.click();  // Click Submit button
    }

    // Method to get error message text
    public String getErrorMsg() {
        return errorMsg.getText();  // Get Error Message
    }
}