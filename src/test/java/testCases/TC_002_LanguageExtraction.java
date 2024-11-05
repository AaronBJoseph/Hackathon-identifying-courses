package testCases;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LanguageExtraction;
import testBase.BaseClass;
import utilities.ExcelUtil;

public class TC_002_LanguageExtraction extends BaseClass {

    @Test(groups = "regression")
    public void selectingLanguages() {
        // Generate a timestamp for unique file naming
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        
        try {
            logger.info("Starting test case: selectingLanguages");
            
            // Navigate to Home Page and perform search
            HomePage hp = new HomePage(driver);
            logger.info("HomePage object created");
            hp.search(p.getProperty("searchLanguage"));
            logger.info("Performed search for 'Language Learning'");
            
            // Initialize Language Extraction Page object
            LanguageExtraction llp = new LanguageExtraction(driver);
            logger.info("LanguageLearningPage object created");
            
            // Prepare file path for Excel output
            String filePath = System.getProperty("user.dir") + "\\OutputData\\Exceloutputfile_2" + timeStamp + ".xlsx";
            String[] headers = {"Language Number", "Language", "Level"};
            
            // Check if product is visible, else click 'Show More'
            if (!llp.isVisibileProduct()) {
                logger.info("No visible product found, clicking 'Show More'");
                llp.clickShowMore();
                logger.info("'Show More' clicked");
                
                int languageCount = llp.sizeOfLanguage();
                String[][] data = new String[languageCount][3];
                
                // Take screenshot
                takeScreenshot("languages learning");
                logger.info("Screenshot taken for languages learning");
                
                // Log and display languages
                logger.info("LANGUAGES:");
                System.out.println("LANGUAGES \n");
                
                for (int i = 0; i < languageCount; i++) {
                    String language = llp.nameOfLanguage(i);
                    logger.info("Language {}: {}", i + 1, language);
                    System.out.println(language);
                    data[i][0] = String.valueOf(i + 1);  // Language Number
                    data[i][1] = language;  // Language Name
                }
                
                // Log and display levels
                logger.info("LEVELS:");
                System.out.println("\n LEVELS \n");
                
                for (int i = 0; i < 4; i++) {
                    String level = llp.getLevels(i);
                    logger.info("Level {}: {}", i + 1, level);
                    System.out.println(level);
                    data[i][2] = level;  // Language Level
                    System.out.println(level);
                }
                
                // Write data to Excel
                ExcelUtil.writeToExcel(filePath, "Language Learning", headers, data);
                
            } else {
                logger.info("Visible product found, clicking 'Language Button'");
                llp.clickLanguageButton();
                logger.info("'Language Button' clicked");
                
                int languageCount = llp.sizeOfLanguage1();
                String[][] data = new String[languageCount][3];
                
                // Log and display languages
                logger.info("LANGUAGES:");
                System.out.println("LANGUAGES \n");
                
                for (int i = 0; i < llp.sizeOfLanguage1(); i++) {
                    String language = llp.nameOfLanguage1(i);
                    logger.info("Language {}: {}", i + 1, language);
                    System.out.println(language);
                    data[i][0] = String.valueOf(i + 1);  // Language Number
                    data[i][1] = language;  // Language Name
                }
                
                llp.clickResult();
                logger.info("'Result' clicked");
                
                llp.clickDifficulty();
                logger.info("'Difficulty' clicked");
                
                // Take screenshot
                takeScreenshot("languages learning");
                logger.info("Screenshot taken for languages learning");
                
                // Log and display levels
                logger.info("LEVELS:");
                System.out.println("\n LEVELS \n");
                
                for (int i = 0; i < 4; i++) {
                    String level = llp.getLevels1(i);
                    logger.info("Level {}: {}", i + 1, level);
                    data[i][2] = level;  // Language Level
                    System.out.println(level);
                }
                
                // Write data to Excel
                ExcelUtil.writeToExcel(filePath, "Language Learning", headers, data);
            }
            
            // Assert visibility of search results
            Assert.assertTrue(llp.isSearchResultsVisible(), "Search results are not visible");
            logger.info("Assertion passed: Search results are visible");
            logger.info("Test case: selectingLanguages completed");
            
        } catch (Exception e) {
            logger.error("An error occurred during the test case execution: ", e);
            Assert.fail("Test case failed due to an exception: " + e.getMessage());
        }
    }
}