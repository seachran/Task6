package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BrandsPage;
import pages.HomePage;
import pages.AdidasPage;
import java.time.Duration;
import java.util.List;

import static org.junit.Assert.*;


public class WiggleSteps {

    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);
    BrandsPage brandsPage = new BrandsPage(driver);
    AdidasPage adidasPage = new AdidasPage(driver);

    @Given("User is on the Wiggle home page")
    public void user_is_on_home_page() {
        driver.get("https://www.wiggle.com/");
    }

    @When("User navigates to the {string} section")
    public void user_navigates_to_section(String section) {
        homePage.goToBrands();
    }

    @When("User selects the first brand in the list \\(Adidas)")
    public void user_selects_first_brand() {
        brandsPage.selectFirstBrand();
    }

    @Then("Adidas brand page is displayed")
    public void adidas_page_is_displayed() {
        assertTrue(adidasPage.isAdidasPageDisplayed());
    }

    @When("User collapses the left filter panel")
    public void user_collapses_filter_panel() {
        adidasPage.toggleFilterPanel();
    }

    @Then("The filter panel should be collapsed")
    public void filter_panel_should_be_collapsed() {
        assertTrue(adidasPage.isFilterPanelCollapsed());
    }

    @When("User expands the left filter panel")
    public void user_expands_filter_panel() {
        adidasPage.toggleFilterPanel();
    }

    @When("User sorts products by {string}")
    public void user_sorts_products(String criteria) {
        adidasPage.sortBy(criteria);
    }

    @Then("Products should be sorted by high price")
    public void products_sorted_by_high_price() {
        assertTrue(adidasPage.isSortApplied("price_desc"));
    }

    @When("User scrolls to the bottom of the page")
    public void user_scrolls_to_bottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");
        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long newHeight = (long) js.executeScript("return document.body.scrollHeight");
            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }
    }

    @Then("Pagination controls should be visible")
    public void pagination_controls_visible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement nextLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("a.swipeNextClick.NextLink")
            ));

            Assert.assertTrue("Кнопка Next не отображается", nextLink.isDisplayed());

        } catch (TimeoutException e) {
            System.out.println("Кнопка Next не найдена или не видна!");
            throw e;
        }
    }

    @When("User navigates back to the home page")
    public void user_navigates_back_home() {
        driver.navigate().to("https://www.wiggle.com/");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("Brands section should be visible on the main menu")
    public void brands_section_visible() {
        assertTrue(homePage.isBrandsMenuVisible());
    }
}

