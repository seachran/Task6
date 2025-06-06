package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By brandsMenu = By.cssSelector("a[href='/brands']");

    public void goToBrands() {
        driver.findElement(brandsMenu).click();
    }

    public boolean isBrandsMenuVisible() {
        return driver.findElement(brandsMenu).isDisplayed();
    }
}