package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {

    // This method will send text on element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // This Method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    public void verifyTextFromElement(By by, String expectedText) {
        WebElement actualText = driver.findElement(by);
        String actual = actualText.getText();
        Assert.assertEquals(expectedText, actual);
    }
    //Retrieving Text Method
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    // Hoovering the mouse on element
    public WebElement mouseHovering(By by) {
        return driver.findElement(by);
    }
    public void selectBYIndexFromDropDown(By by, String value){
        new Select(driver.findElement(by)).selectByValue(value);
    }
    public void clearTheQuantity(By by){
        driver.findElement(by).clear();
    }
    public void mouseHoverToElement(By by){
        WebElement action = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(action).build().perform();
    }
    public void mouseHoverToElementAndClick(By by) {
        WebElement action = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(action).click().perform();
    }
    /**
     *  This method will select the option visible text from dropdown menu
     */
    public void selectByVisibleTextFromDropdown(By by,String text){
        WebElement dropDown=driver.findElement(by);
        Select select=new Select(dropDown);
        select.selectByVisibleText(text);
    }
    /**
     * This method will find the list of elements
     */
    public List<WebElement> findElementsFromWebPage(By by) {
        return driver.findElements(by);
    }
    /**
     *  This method will verify the element
     */
    public void verifyElements(String displayMessage, String expectedMessage, By by) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }
}