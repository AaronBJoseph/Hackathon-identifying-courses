package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Element locators
    @FindBy(xpath = "//input[@id='search-autocomplete-input']")
    WebElement searchBox;  // Search box input field
    
    @FindBy(xpath = "//span[contains(text(),'Businesses')]")
    WebElement forBusiness;  // "For Business" button/link

    // Method to search for web development
    public void search(String str) {
        searchBox.sendKeys(str);  // Enter search term in search box
        searchBox.sendKeys(Keys.ENTER);  // Press Enter key to initiate search
    }

    // Method to click on "For Enterprises"
    public void clickForEnterprice() {
        forBusiness.click();  // Click on "For Business" button/link
    }

    // Method to get the page title
    public String title() {
        return driver.getTitle();  // Return the current page title
    }
}
