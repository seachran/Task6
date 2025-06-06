package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BrandsPage {
    WebDriver driver;

    public BrandsPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstBrand = By.cssSelector("a[href='/adidas']");

    public void selectFirstBrand() {
        driver.findElement(firstBrand).click();
    }
}