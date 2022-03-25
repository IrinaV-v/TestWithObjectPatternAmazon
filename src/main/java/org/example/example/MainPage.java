package org.example.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signIn = By.xpath("//a[starts-with(@href, \"/login\")]");

    public LoginPage click(){
        driver.findElement(signIn).click();
        return new LoginPage(driver);
    }
}
