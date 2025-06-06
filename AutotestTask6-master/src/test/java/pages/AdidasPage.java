package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdidasPage {
    WebDriver driver;

    public AdidasPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Инициализация всех @FindBy
    }

    @FindBy(xpath = "//h1[contains(text(),'Adidas')]")
    WebElement pageTitle;

    @FindBy(xpath = "//h3[contains(text(),'Sort By')]/ancestor::div[contains(@class,'productFilterTitleBox')]")
    WebElement sortByToggle;

    @FindBy(id = "DesktopSortOptions_price_desc")
    WebElement sortByPriceDesc;

    @FindBy(css = "ul.Pagination li")
    WebElement paginationItem;

    @FindBy(xpath = "//h3[contains(text(),'Sort By')]/ancestor::li")
    WebElement filterSection;

    public boolean isAdidasPageDisplayed() {
        return driver.getCurrentUrl().contains("/adidas");
    }

    public void toggleFilterPanel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(sortByToggle)).click();
    }

    public boolean isFilterPanelCollapsed() {
        try {
            return filterSection.getAttribute("class").contains("FilterClosed");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void sortBy(String criteria) {
        if (criteria.equalsIgnoreCase("Price (High To Low)")) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(sortByPriceDesc))
                    .click();
        }
    }

    public boolean isSortApplied(String keyword) {
        return driver.getCurrentUrl().contains(keyword);
    }

    public boolean paginationVisible() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(paginationItem));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}