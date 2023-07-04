package laptopsandnotebooks;

import homepage.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {
    java.lang.String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHover(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        mouseHover(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        visibleTextDropDown(By.id("input-sort"), "Price (High > Low)");
        getTextFromElement(By.xpath("//p[@class='price']"));
        //To print the prices in console
        List<WebElement> priceList = driver.findElements(By.xpath("//p[@class='price']"));
        for (int i = 0; i < priceList.size(); i++) {
            System.out.println(priceList.get(i).getText());
            String actual = priceList.get(i).getText();
            String exp = priceList.get(i).getText();
            Assert.assertEquals("Price not in High to Low order", actual, exp);
        }
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        //1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHover(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        mouseHover(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        clickOnElement(By.xpath("//select[@id='input-sort']"));
        visibleTextDropDown(By.id("input-sort"), "Price (High > Low)");
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
        String actual = getTextFromElement(By.xpath("//a[normalize-space()='MacBook']"));
        String exp = "MacBook";
        Assert.assertEquals("Text not matched", actual, exp);

        clickOnElement(By.xpath("//button[@id='button-cart']"));
        String actual1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String exp1 = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        Assert.assertEquals("Text not matched", actual1, exp1);

        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        String act3 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        String exp3 = "Shopping Cart  (0.00kg)";
        Assert.assertEquals("Text not matched", act3, exp3);

        String act4 = getTextFromElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        String exp4 = "MacBook";
        Assert.assertEquals("Text not matched", act4, exp4);

        //Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");

        //Click on “Update” Tab
        clickOnElement(By.xpath("//button[@type='submit']"));

        //Verify the message “Success: You have modified your shopping cart!”
        String act5 = getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        String exp5 = "Success: You have modified your shopping cart!\n" +
                "×";
        Assert.assertEquals("Text not matched", act5, exp5);
        //Verify the Total £737.45
        String act6 = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        String exp6 = "$1,204.00";
        Assert.assertEquals("Total not matched", act6, exp6);
        //Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        //Verify the text “Checkout”
        String act7 = getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']"));
        String exp7 = "Checkout";
        Assert.assertEquals("Text not matched", act7, exp7);
        //Verify the Text “New Customer”
        /*String act8 = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        System.out.println(act8);
        String exp8 = "New Customer";
        Assert.assertEquals("Text not matched", act8, exp8);*/
        //Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//label[normalize-space()='Guest Checkout']"));
        // Click on “Continue” tab
        clickOnElement(By.id("button-account"));
        // Fill the mandatory fields
        sendTextToElement(By.name("firstname"), "Shy");
        sendTextToElement(By.name("lastname"), "Birun");
        sendTextToElement(By.id("input-payment-email"), "Shy@gmail.com");
        sendTextToElement(By.name("telephone"), "07847345678");
        ;
        sendTextToElement(By.name("address_1"), "No 23,Cheam Road");
        sendTextToElement(By.name("address_2"), "Cheam");
        sendTextToElement(By.name("city"), "Sutton");
        sendTextToElement(By.name("postcode"), "SN67 5DM");
        valueDropDown(By.name("country_id"), "222");
        clickOnElement(By.xpath("//select[@id='input-payment-zone']"));
        valueDropDown((By.name("zone_id")), "3598");
        // Click on “Continue” Button
        clickOnElement(By.id("button-guest"));
        //Add comments to text area
        sendTextToElement(By.name("comment"), "Thank you");
        // Check the Terms & Conditions check box
        clickOnElement(By.name("agree"));
        // Click on “Continue” button
        clickOnElement(By.id("button-payment-method"));
        String act9 = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        String exp9 = "Warning: Payment method required!\n" +
                "×";
        Assert.assertEquals("Text not matched", act9, exp9);
    }
}


//Verify the message “Warning: Payment method required

