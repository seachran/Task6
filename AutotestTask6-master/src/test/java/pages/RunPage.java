package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RunPage {
    WebDriver driver;

    public RunPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstRun = By.cssSelector("a[href='/shorts']");

    public void selectFirstBrand() {
        driver.findElement(firstRun).click();
    }
}