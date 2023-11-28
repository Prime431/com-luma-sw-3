package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before

    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        // * * Mouse Hover on Men Menu
        mouseHoverToElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[3]/a[1]/span[2]"));
        //* * Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']"));
        // * * Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        clickOnElement(By.xpath("//div[@id='option-label-size-143-item-175']"));
        //Cronus Yoga Pant and click on colour Black.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        clickOnElement(By.xpath("//div[@id='option-label-color-93-item-49']"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
        clickOnElement(By.xpath("//li[1]//div[1]//div[1]//div[3]//div[1]//div[1]//form[1]//button[1]//span[1]"));
        // Verify the text
        verifyTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"), "You added Cronus Yoga Pant to your shopping cart.");
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        ///** Verify the text ‘Shopping Cart
        verifyTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"),"Cronus Yoga Pant");
        // Verify the product size ‘32’
        verifyTextFromElement(By.xpath("//dd[contains(text(),'32 ')]"),"32");
        // Verify the product colour ‘Black’
        verifyTextFromElement(By.xpath("//dd[contains(text(),'Black ')]"),"Black");
    }
    @After
    public void closeBrowser() {

        driver.close();
    }

}
