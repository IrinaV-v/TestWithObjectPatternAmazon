package org;

import org.example.example.LoginPage;
import org.example.example.MainPage;
import org.example.example.RepositoryPage;
import org.openqa.selenium.WebDriver;;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    @DataProvider (name = "incorrectCredentials")
    public Object[][] incorrectCredentials() {
        return new Object [][]
                {
                        {"",""},
                        {"incorrect login", "!!!"},
                        {"!!!", "incorrect password"}
                };
    }

    private WebDriver driver;
    private LoginPage loginPage;


    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Java\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "incorrectCredentials")
    public void incorrectSignIn(String log, String pas) {
        LoginPage newLoginPage = loginPage.incorrectSignIn(log, pas);
        Assert.assertEquals( newLoginPage.getErrorText(), "Incorrect username or password.");
    }

    @Test
    public void correctSignIn() {
        RepositoryPage repositoryPage = loginPage.correctSignIn("correctLogin","CorrectPassword");
        Assert.assertEquals( repositoryPage.getText(), "Discover interesting projects and people to populate your personal news feed.");
    }


    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
