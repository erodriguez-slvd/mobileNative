package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.solvd.carina.demo.mobile.gui.pages.common.ProductDetailPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest implements IAbstractTest {
    @Test(suiteName = "Product Test")
    @TestCaseKey("ALPHA-153")
    public void testGetProductDescription() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        ProductDetailPageBase productPage = catalogPage.clickOnAProduct();
        productPage.getProductDescription();
    }
}
