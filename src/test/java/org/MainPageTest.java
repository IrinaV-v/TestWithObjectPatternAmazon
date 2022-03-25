package org;

import org.example.example.LoginPage;
import org.example.example.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Java\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signIn(){
        LoginPage loginPage = mainPage.click();
        Assert.assertEquals(loginPage.getAnnotation(), "Sign in to GitHub");
    }


    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
