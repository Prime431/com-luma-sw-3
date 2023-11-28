package testsuite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
        //Mouse Hover on Gear Menu and click
        mouseHoverToElement(By.xpath("//span[contains(text(),'Gear')]"));
        //Click on Bags
        clickOnElement(By.xpath("//span[contains(text(),'Bags')]"));

        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
        //Change Qty 3
        sendTextToElement(By.xpath("//input[@id='qty']"), Keys.DELETE + "3");
        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        //Verify the text
        verifyTextFromElement(By.xpath("//div[@class='message-success success message']"), "You added Overnight Duffle to your shopping cart");
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //Verify the product name ‘Cronus Yoga Pant’
        verifyTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"), "You added Cronus Yoga Pant to your shopping cart.");
        //Verify the Qty is ‘3’
        verifyTextFromElement(By.xpath("//input[@id='cart-487572-qty']"),"3");
        //Verify the product price ‘$135.00’
        verifyTextFromElement(By.xpath("td[class='col subtotal'] span[class='price']"),"$135.00");
        //* Change Qty to ‘5’
        sendTextToElement(By.xpath("//input[@id='qty']"), Keys.DELETE + "5");
        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[text()='Update Shopping Cart']"));
        // Verify the product price '$225.00'
        verifyTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][text()='$225.00']"), "$225.00");
    }

}