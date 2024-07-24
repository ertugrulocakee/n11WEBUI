package Pages;

import Util.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class n11Pages {
    static WebDriver driver;
    static ElementHelper elementHelper;
    WebDriverWait wait;

    static By allBrands= By.xpath("//div[@class='columnContent ']//a[@title='Markalar']");
    static By brandItems = By.xpath("//li[@class='item']/a");
    static By colorOptions = By.xpath("(//fieldset/div[@class='sku-definitions'])[1]//label");
    static By memoryOptions = By.xpath("(//fieldset/div[@class='sku-definitions'])[2]//label");
    static By search = By.id("searchData");
    static By searchButton = By.xpath("//a[@class='searchBtn']");
    static By sFilter = By.xpath("//a[text()='S']");
    static By appleFilter = By.cssSelector("body > div:nth-child(1) > div:nth-child(28) > div:nth-child(12) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > span:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > span:nth-child(1) > a:nth-child(1) > span:nth-child(2)");
    static By btnBasket = By.className("btnBasket");
    static By addBasket = By.id("js-addBasketSku");
    static By basketValue = By.xpath("//span[@class='basketTotalNum']");
    static By phones = By.xpath("//img[@class='lazy cardImage']");
    static By otherBrands = By.xpath("//a[contains(text(),'Diğer Mağazalar')]");
    static By filterForCommentsOption = By.xpath("//select[@class='unf-sortType']//option[@value='REVIEWS']");
    static By freeShipOption = By.xpath("//li[@class='unf-sell-flt-freeShip']");
    static By selectedFreeShipOption = By.xpath("//li[@class='unf-sell-flt-freeShip active']");

    public n11Pages(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(driver);
    }

    public static void HomePage() {
        Assert.assertEquals("https://www.n11.com/",driver.getCurrentUrl(),"unexpected url!");
    }

    public  static void clickAllBrands(){
        elementHelper.click(allBrands);
    }

    public static void clickBrand(){
        List<WebElement> exampleList = driver.findElements(brandItems);
        Random rnd = new Random();
        int i = rnd.nextInt(exampleList.size());
        elementHelper.waitMillis(1500);
        String hrefValue = exampleList.get(i).getAttribute("href");
        exampleList.get(i).click();
        elementHelper.waitMillis(1500);
        Assert.assertEquals(hrefValue,driver.getCurrentUrl());
    }

    public static void acceptCookie(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String el = "return document.querySelector(\"body > efilli-layout-dynamic\").shadowRoot.querySelector(\"#\\\\31 d5d7aff-8ee1-4a98-9022-f0e29a5e471c\")";
        WebElement element = (WebElement) js.executeScript(el);
        element.click();
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public static void clickSearch() {
        elementHelper.click(search);
    }

    public static void writeProduct(String productName){
        elementHelper.sendKey(search,productName);
        elementHelper.click(searchButton);
        elementHelper.waitMillis(1500);
        Assert.assertEquals(productName,elementHelper.findElement(search).getAttribute("value"));
    }

    public static void searchButton() {
        elementHelper.click(searchButton);
    }

    public static void filterCharacter() {
        elementHelper.click(sFilter);
    }
    public static void filterApple() {
        elementHelper.click(appleFilter);
    }
    public static void selectSecondProduct(){
        List<WebElement> phoneList = driver.findElements(phones);
        phoneList.get(1).click();
        elementHelper.waitMillis(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public static void  filterForCommentsAndFreeShipping(){
        elementHelper.click(otherBrands);
        elementHelper.waitMillis(1500);
        elementHelper.click(filterForCommentsOption);
        elementHelper.waitMillis(1500);
        elementHelper.click(freeShipOption);
        elementHelper.waitMillis(1500);
        Assert.assertTrue(elementHelper.elementVisible(selectedFreeShipOption));
    }

    public static void addFirstAndLastProductToCart(){
        List<WebElement> exampleList = driver.findElements(btnBasket);
        exampleList.get(0).click();
        elementHelper.waitMillis(1000);

        if(elementHelper.elementVisible(colorOptions)){
            List<WebElement> colorList = driver.findElements(colorOptions);
            colorList.get(0).click();
        }
        elementHelper.waitMillis(1000);
        if(elementHelper.elementVisible(memoryOptions)){
            List<WebElement> memoryList = driver.findElements(memoryOptions);
            memoryList.get(0).click();
        }

        elementHelper.waitMillis(500);
        elementHelper.click(addBasket);

        exampleList.get(exampleList.size()-1).click();
        elementHelper.waitMillis(1000);

        if(elementHelper.elementVisible(colorOptions)){
            List<WebElement> colorList = driver.findElements(colorOptions);
            colorList.get(0).click();
        }
        elementHelper.waitMillis(1000);
        if(elementHelper.elementVisible(memoryOptions)){
            List<WebElement> memoryList = driver.findElements(memoryOptions);
            memoryList.get(0).click();
        }

        elementHelper.waitMillis(500);
        elementHelper.click(addBasket);
    }

    public static void  checkBasketValue(int value){
        elementHelper.waitMillis(1500);
        Assert.assertEquals(value,Integer.valueOf(elementHelper.findElement(basketValue).getText()));
    }
}
