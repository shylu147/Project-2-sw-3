package myaccounts;

import homepage.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyAccountsTest extends Utility {
    public void selectMyAccountOptions(String option) {
        driver.findElement(By.linkText(option)).click();
    }

    java.lang.String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        clickOnElement(By.xpath("//a[contains(text(),'My Account')]"));
        selectMyAccountOptions("Register");
        String act = getTextFromElement(By.xpath("//h1[text()='Register Account']"));
        String exp = "Register Account";

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        clickOnElement(By.xpath("//a[contains(text(),'My Account')]"));
        selectMyAccountOptions("Login");
        String act1 = getTextFromElement(By.xpath("//h2[text()='Returning Customer']"));
        String exp1 = "Returning Customer";
        Assert.assertEquals("Text not matched", act1, exp1);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        clickOnElement(By.xpath("//a[contains(text(),'My Account')]"));
        selectMyAccountOptions("Register");
        sendTextToElement(By.name("firstname"), "Shy");
        sendTextToElement(By.name("lastname"), "Birun");
        sendTextToElement(By.name("email"), "ipainyxvaan@gmail.com");
        sendTextToElement(By.name("telephone"), "07876345674");
        sendTextToElement(By.name("password"), "ipainyxvaan123");
        sendTextToElement(By.name("confirm"), "ipainyxvaan123");
        clickOnElement(By.name("newsletter"));
        clickOnElement(By.name("agree"));
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));
        String act2=getTextFromElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        String exp2="Your Account Has Been Created!";
        Assert.assertEquals("Text not matched",act2,exp2);
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        //clickOnElement(By.xpath("//a[text()='My Account']"));
        selectMyAccountOptions("Logout");
        String act3=getTextFromElement(By.xpath("//h1[text()='Account Logout']"));
        String exp3="Account Logout";
        Assert.assertEquals("text not matched",act3,exp3);}

}

