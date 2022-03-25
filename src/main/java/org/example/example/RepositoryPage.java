package org.example.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RepositoryPage {
    WebDriver driver;

    public RepositoryPage(WebDriver driver) {
        this.driver = driver;
    }
    private By discoverText = By.xpath("//*[text() = \"Discover interesting projects and people to populate your personal news feed.\"]");

    public String getText(){
        return driver.findElement(discoverText).getText();
    }
}
