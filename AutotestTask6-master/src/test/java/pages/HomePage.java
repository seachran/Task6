package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By RunMenu = By.cssSelector("a[href='/run']");

    public void goToRun() {
        driver.findElement(RunMenu).click();
    }

    public boolean isBrandsMenuVisible() {
        return driver.findElement(RunMenu).isDisplayed();
    }
}