package org.example.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;

    By login = By.id("login_field");
    By password = By.id("password");
    By button = By.name("commit");

    public LoginPage(WebDriver webDriver) {
        this.driver = driver;
    }

    public LoginPage inputLogin(String log){
        driver.findElement(login).sendKeys(log);
        return this;
    }

    public LoginPage inputPass(String pass){
        driver.findElement(password).sendKeys(pass);
        return this;
    }


    public LoginPage incorrectSignIn(String log, String pass){
        this.inputLogin(log);
        this.inputPass(pass);
        driver.findElement(button).click();
        return this;
    }

    public RepositoryPage correctSignIn(String log, String pass){
        this.inputLogin(log);
        this.inputPass(pass);
        driver.findElement(button).click();
        return new RepositoryPage(driver);
    }

    public String getAnnotation(){
        return driver.findElement(By.xpath("//*[text()='Sign in to GitHub']")).getText();
    }
    public String getErrorText(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElement(By.xpath("//div[@class = \"px-2\"]")).getText();
    }
}
