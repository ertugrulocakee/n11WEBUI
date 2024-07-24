package StepDefinitions;

import Pages.n11Pages;
import Util.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class n11Steps {
    WebDriver driver = DriverFactory.getDriver();
    n11Pages n11Pages = new n11Pages(driver);

    @Given("User is on homepage")
    public void userIsOnHomepage() {
        n11Pages.HomePage();
    }

    @When("Click accept cookies")
    public void clickAcceptCookies() {
        n11Pages.acceptCookie();
    }

    @When("Click the brands button")
    public void clickTheAllBrandsButton(){
        n11Pages.clickAllBrands();
    }

    @When("Write product name {string}")
    public void writeProductName(String productName){
        n11Pages.writeProduct(productName);
    }

    @When("Click search button")
    public void clickSearchButton(){
        n11Pages.searchButton();
    }

    @When("Filter for Character")
    public void filterForCharacter(){
        n11Pages.filterCharacter();
    }

    @When("Click Brand")
    public void clickBrand(){
        n11Pages.clickBrand();
    }

    @When("Select second phone")
    public void selectSecondPhone(){
        n11Pages.selectSecondProduct();
    }

    @When("Add to Cart")
    public void addToCart(){
        n11Pages.addFirstAndLastProductToCart();
        n11Pages.checkBasketValue(2);
    }

    @When("Filter for Comments")
    public void filterForComments() {
        n11Pages.filterForCommentsAndFreeShipping();
    }
}
