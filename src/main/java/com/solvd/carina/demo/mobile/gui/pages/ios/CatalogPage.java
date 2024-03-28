package com.solvd.carina.demo.mobile.gui.pages.ios;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.ClassChain;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CatalogPageBase.class)
public class CatalogPage extends CatalogPageBase{
    public CatalogPage(WebDriver driver) {
        super(driver);
    }
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
    @FindBy(xpath = "**/XCUIElementTypeOther[`name == \"test-Modal Selector Button\"`]")
    @ClassChain
    private ExtendedWebElement filterBtn;
    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"Price (low to high)\"`]")
    @ClassChain
    private ExtendedWebElement ascendingPriceBtn;
    @FindBy(xpath = "**/XCUIElementTypeOther[`label == \"Name (Z to A)\"`]")
    @ClassChain
    private ExtendedWebElement descendingNameBtn;

    @Override
    public boolean isTitlePresent() {
        return pageTitle.isElementPresent();
    }
    public boolean areProductTitlesVisible(){
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
        if ((Double.parseDouble(productPrices.get(0).getText().replace("$","")))<(Double.parseDouble(productPrices.get(1).getText().replace("$","")))){
            return true;
        }
        return false;
    }
    @Override
    public void sortProductsByDescendingName() {
        filterBtn.click();
        descendingNameBtn.click();
    }
    @Override
    public boolean areProductSortByDescendingName() {
        if (productTitles.get(0).getText().compareToIgnoreCase(productTitles.get(1).getText())>0){
            return true;
        }
        return false;
    }

}
