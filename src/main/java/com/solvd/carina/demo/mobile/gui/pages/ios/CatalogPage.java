package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.components.ios.ProductSorting;
import com.solvd.carina.demo.mobile.gui.enums.SortType;
import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.ClassChain;
import com.zebrunner.carina.webdriver.decorator.annotations.Predicate;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "**/XCUIElementTypeStaticText[`label == \"PRODUCTS\"`]")
    @ClassChain
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "**/XCUIElementTypeStaticText[`name == \"test-Item title\"`]")
    @ClassChain
    private List<ExtendedWebElement> productTitles;

    @FindBy(xpath = "**/XCUIElementTypeStaticText[`name == \"test-Price\"`]")
    @ClassChain
    private List<ExtendedWebElement> productPrices;

    @ExtendedFindBy(accessibilityId = "Selector container")
    private ProductSorting productSorting;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement filterBtn;

    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"Price (low to high)\"`]")
    @ClassChain
    private ExtendedWebElement ascendingPriceBtn;

    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"Name (Z to A)\"`]")
    @ClassChain
    private ExtendedWebElement descendingNameBtn;

    @FindBy(xpath = "**/XCUIElementTypeOther[`name == \"test-ADD TO CART\"`][2]")
    @ClassChain
    private ExtendedWebElement addToCartBtn;

    @FindBy(xpath = "label == \"REMOVE\" AND name == \"test-REMOVE\"")
    @Predicate
    private ExtendedWebElement removeFromCartBtn;

    @FindBy(xpath = "**/XCUIElementTypeOther[`name == \"test-Cart\"`]/XCUIElementTypeOther")
    @ClassChain
    private ExtendedWebElement cartIcon;

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isTitlePresent() {
        return pageTitle.isElementPresent();
    }

    public boolean areProductTitlesVisible() {
        for (ExtendedWebElement e : productTitles) {
            if (!e.isPresent()) {
                return false;
            }
            LOGGER.info("Product Name: " + e.getText());
        }
        return true;
    }

    @Override
    public void sortProduct(SortType sortType) {
        openSortingFilter();
        productSorting.sortBy(sortType);
    }

    @Override
    public void openSortingFilter() {
        filterBtn.click();
    }

    @Override
    public boolean areProductSortByAscendingPrice() {
        return (Double.parseDouble(productPrices.get(0).getText().replace("$", ""))) < (Double.parseDouble(productPrices.get(1).getText().replace("$", "")));
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
        return cartIcon.getAttribute("name").length() != 0;
    }

    @Override
    public boolean isCartEmpty() {
        return cartIcon.getAttribute("name") == null;
    }

    @Override
    public ProductDetailPageBase clickOnAProduct() {
        productTitles.get(0).click();
        return initPage(getDriver(), ProductDetailPageBase.class);
    }

}
