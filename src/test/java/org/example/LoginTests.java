package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

public class LoginTests {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyPageTitleAndLoginFields() {
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Swag Labs"), "Заголовок не містить назву 'Swag Labs'");

        SoftAssert softAssert = new SoftAssert();


        softAssert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Поле логіну відсутнє");
        softAssert.assertTrue(loginPage.isPasswordFieldDisplayed(), "Поле паролю відсутнє");
        softAssert.assertAll();
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginDataProvider() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"}
        };

    }

    @Test(dataProvider = "LoginData")
    public void testLoginWithDataProvider(String username, String password) {
        System.out.println(" Тест логін: " + username + " Пароль: " + password);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
}

