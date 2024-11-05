package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LanguageExtraction extends BasePage {

    // Constructor to initialize WebDriver
    public LanguageExtraction(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    // Element locators
    @FindBy(xpath = "//div[@data-testid='search-filter-group-Language']//span[contains(text(),'Show')]")
    WebElement showMore;  // Show more languages button

    @FindBy(xpath="//div[@data-testid='search-filter-group-Language']//div[@class='css-1bmgd8']")   
    List<WebElement> listOfLanguages;  // List of available languages

    @FindBy(xpath = "//div[@data-testid='search-filter-group-Level']//div[@class='css-1bmgd8']")
    List<WebElement> levels;   // List of available levels

    @FindBy(xpath = "//div[text()='Difficulty']")
    WebElement difficulty;  // Difficulty filter

    @FindBy(xpath = "//button[@class='css-1bbqjkf']")
    WebElement languageBtn;  // Button to filter by language

    @FindBy(xpath = "//div[@class='cds-checkboxAndRadio-labelText']")
    List<WebElement> level1;  // Another level list (if applicable)

    @FindBy(xpath = "//label[@class='cds-checkboxAndRadio-label']")
    List<WebElement> languages;  // Language titles

    @FindBy(xpath = "//div[text()='Product Type']")
    WebElement productType;  // Product type filter

    @FindBy(xpath = "//span[text()='Show results']")
    WebElement showResultBtn;  // Show results button

    @FindBy(xpath = "//span[contains(text(),'Results for')]")
    WebElement resultsElement;  // Results element

    // Post actions

    // Click the "Show More" button
    public void clickShowMore() {
        showMore.click();
    }

    // Select a language from the list
    public void selectLanguage(int i) {
        listOfLanguages.get(i).click();
    }

    // Get the size of the language list
    public int sizeOfLanguage() {
        return listOfLanguages.size();
    }

    // Get the size of the alternative language list
    public int sizeOfLanguage1() {
        return languages.size();
    }

    // Get the name of a language from the list
    public String nameOfLanguage(int i) {
        return listOfLanguages.get(i).getText();
    }

    // Get the name of a language from the alternative list
    public String nameOfLanguage1(int i) {
        return languages.get(i).getText();
    }

    // Get the level text from the list
    public String getLevels(int i) {
        return levels.get(i).getText();
    }

    // Get the size of the levels list
    public int getLevelsSize() {
        return levels.size();
    }

    // Get the level text from the alternative list
    public String getLevels1(int i) {
        return level1.get(i).getText();
    }

    // Click the "Difficulty" filter
    public void clickDifficulty() {
        difficulty.click();
    }

    // Click the language filter button
    public void clickLanguageButton() {
        languageBtn.click();
    }

    // Check if the product type filter is visible
    public Boolean isVisibileProduct() {
        try {
            return productType.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Click the "Show Results" button
    public void clickResult() {
        showResultBtn.click();
    }

    // Check if the search results are visible
    public boolean isSearchResultsVisible() {
        try {
            return resultsElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
 