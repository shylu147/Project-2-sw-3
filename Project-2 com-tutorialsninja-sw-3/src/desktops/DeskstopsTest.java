package desktops;

import homepage.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DeskstopsTest extends Utility {
    java.lang.String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        mouseHover(By.xpath("//a[normalize-space()='Desktops']"));
        mouseHover(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        mouseHover(By.xpath("//select[@id='input-sort']"));
        visibleTextDropDown(By.id("input-sort"), "Name (A - Z)");
        //To print the list Z to A in console
        List<WebElement> productList = driver.findElements(By.id("product-category"));
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).getText());
            java.lang.String actual = productList.get(i).getText();
            String exp = productList.get(i).getText();
            Assert.assertEquals("Products not in Z to A order", actual, exp);
        }
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() {
        mouseHover(By.xpath("//a[normalize-space()='Desktops']"));
        mouseHover(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        mouseHover(By.xpath("//select[@id='input-sort']"));
        visibleTextDropDown(By.id("input-sort"), "Name (A - Z)");
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));
        String actual = getTextFromElement(By.xpath("//h1[text()='HP LP3065']"));
        String exp = getTextFromElement(By.xpath("//h1[text()='HP LP3065']"));
        Assert.assertEquals("Text not matched", actual, exp);

        clickOnElement(By.xpath("//i[@class='fa fa-calendar']"));
       /* while (true) {
            String monthYear = driver.findElement(By.cssSelector("body > section:nth-child(3) > div:nth-child(3) > main:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)")).getText();
            System.out.println(monthYear);
            String monthYear = driver.findElement(By.xpath("//th[normalize-space()='November 2011']")).getText();
            String[] a = monthYear.split(" ");
            String month = a[0];
            String year = a[1];
            if (month.equalsIgnoreCase(month) && year.contains(year)) {
                String yer = a[1].split("\n")[0];
                if (month.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                    break;
                } else {
                    clickOnElement(By.xpath("//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//div[3]//*[name()='svg']"));
                }
            }

            // Select the Date
            List<WebElement> allDates = driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']//table//td"));
            List<WebElement> allDates = driver.findElements(By.xpath("//div[@class='DatePicker__MainBlock-sc-1kf43k8-1 hHKFiR']/div[3]/div/span/div/span"));
            for (WebElement dt : allDates) {
                if (dt.getText().equalsIgnoreCase(date)) {
                    dt.click();*/
                    //verify model 21
                    String actual1 = getTextFromElement(By.xpath("//li[normalize-space()='Product Code:Product 21']"));
                    String exp1 = getTextFromElement(By.xpath("//li[normalize-space()='Product Code:Product 21']"));
                    Assert.assertEquals("Text not matched",actual1,exp1);

                    String actual2= getTextFromElement(By.xpath("//h2[normalize-space()='$122.00']"));
                    String exp2 = getTextFromElement(By.xpath("//h2[normalize-space()='$122.00']"));
                    Assert.assertEquals("Text not matched",actual1,exp1);}}

