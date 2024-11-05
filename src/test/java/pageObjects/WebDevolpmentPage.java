package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebDevolpmentPage extends BasePage {

    // Constructor to initialize WebDriver
    public WebDevolpmentPage(WebDriver driver) {
        super(driver);
    }

    // Element locators
    @FindBy(xpath = "//span[text()='English']") 
    WebElement englishCheckbox;  // English language checkbox
    
    @FindBy(xpath = "//span[text()='Beginner']") 
    WebElement beginnersCheckbox;  // Beginners level checkbox
    
    @FindBy(xpath = "//h3[@class='cds-CommonCard-title css-6ecy9b']") 
    List<WebElement> titles;  // Course titles
    
    @FindBy(xpath="//div[@aria-label='Rating']//span[@class=' css-6ecy9b']")
    List<WebElement> rating;  // Course ratings
    
    @FindBy(xpath = "//div[@class='cds-ProductCard-footer']//div[@class='cds-CommonCard-metadata']") 
    List<WebElement> courseLength;  // Course lengths

    @FindBy(xpath = "//span[text()='Show results']") 
    WebElement showResultBtn;  // Show results button
    
    @FindBy(xpath = "//div[text()='Product Type']") 
    WebElement productType;  // Product type filter
    
    @FindBy(xpath = "//div[text()='Difficulty']") 
    WebElement difficulty;  // Difficulty filter

    @FindBy(xpath = "//span[contains(text(),'Results for')]") 
    WebElement resultsElement;  // Results element

    // Method to click the English checkbox
    public void tickEnglishCheckBox() {
        englishCheckbox.click();
    }

    // Method to click the Beginners checkbox
    public void tickBeginnersCheckBox() {
        beginnersCheckbox.click();
    }

    // Method to return the title of a course
    public String getCourseTitle(int i) {
        String courseTitle = titles.get(i).getText();
        return courseTitle;
    }

    // Method to return the rating of a course
    public String getCourseRating(int i) {
        String courseRating = rating.get(i).getText();
        return courseRating;
    }

    // Method to return the length of a course
    public String getCourseLength(int i) {
        String courseLength1 = courseLength.get(i).getText();
        return courseLength1;
    }

    // Method to check if the product type filter is visible
    public Boolean isVisibileProduct() {
        try {
            return productType.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to click the Difficulty filter
    public void clickDifficulty() {
        difficulty.click();
    }

    // Method to click the Show Results button
    public void clickResult() {
        showResultBtn.click();
    }

    // Method to check if search results are visible
    public boolean isSearchResultsVisible() {
        try {
            return resultsElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

//div[contains(@class,'filterContent')]//span[text()='Beginner']
