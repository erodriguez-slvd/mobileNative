package com.solvd.carina.demo.mobile.gui.pages.android;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement pageTitle;
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\"]")
    private List<ExtendedWebElement> productTitles;
    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
    private List<ExtendedWebElement> productPrices;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]")
    private ExtendedWebElement filterBtn;
    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement ascendingPriceBtn;
    @FindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement descendingNameBtn;
    @FindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
    private ExtendedWebElement addToCartBtn;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]/android.widget.TextView")
    private ExtendedWebElement removeFromCartBtn;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement cartIcon;


    @Override
    public boolean isTitlePresent() {
        return pageTitle.isElementPresent();
    }
    @Override
    public boolean areProductTitlesVisible() {
        for (ExtendedWebElement e:productTitles) {
            if (!e.isPresent()){
                return false;
            }
            LOGGER.info("Product Name: "+e.getText());
        }
        return true;
    }
    @Override
    public void sortProductsByAscendingPrice() {
        filterBtn.click();
        ascendingPriceBtn.click();
    }
    @Override
    public boolean areProductSortByAscendingPrice() {
        return (Double.parseDouble(productPrices.get(0).getText().replace("$", ""))) < (Double.parseDouble(productPrices.get(1).getText().replace("$", "")));
    }
    @Override
    public void sortProductsByDescendingName() {
        filterBtn.click();
        descendingNameBtn.click();
    }
    @Override
    public boolean areProductSortByDescendingName() {
        return productTitles.get(0).getText().compareToIgnoreCase(productTitles.get(1).getText()) > 0;
    }
    @Override
    public void addProductToCart() {
        addToCartBtn.click();
    }
    @Override
    public void removeProductFromCart() {
        removeFromCartBtn.click();
    }
    @Override
    public boolean cartContainsProduct() {
        return cartIcon.getText().equals("1");
    }
    @Override
    public boolean isCartEmpty() {
        return cartIcon.isElementNotPresent(1L);
    }
    @Override
    public ProductDetailPageBase clickOnAProduct() {
        productTitles.get(0).click();
        return initPage(getDriver(), ProductDetailPageBase.class);
    }
}
