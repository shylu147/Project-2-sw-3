package homepage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuRest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        driver.findElement(By.xpath(menu)).click();
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        mouseHover(By.xpath("//a[normalize-space()='Desktops']"));
        mouseHover(By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        String actual = getTextFromElement(By.xpath("//body/div[@id='product-category']/ul[1]/li[2]/a[1]"));
        String expected = "Desktops";
        Assert.assertEquals("Text not matched", actual, expected);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        mouseHover(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        mouseHover(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        String actual = getTextFromElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(),'Laptops & Notebooks')]"));
        String expected = "Laptops & Notebooks";
        Assert.assertEquals("Text not matched", actual, expected);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        mouseHover(By.xpath("//a[normalize-space()='Components']"));
        mouseHover(By.xpath("//a[contains(text(),'Show AllComponents')]"));
        String actual = getTextFromElement(By.xpath("//ul[@class='breadcrumb']//a[contains(text(),'Components')]"));
        String expected = "Components";
        Assert.assertEquals("Text not matched", actual, expected);
    }
}