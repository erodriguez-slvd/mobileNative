package com.solvd.carina.demo;

import com.solvd.carina.demo.mobile.gui.enums.SortType;
import com.solvd.carina.demo.mobile.gui.pages.common.CatalogPageBase;
import com.zebrunner.agent.core.annotation.TestCaseKey;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatalogTest extends BaseTest implements IAbstractTest {
    @Test(suiteName = "Catalog Test")
    @TestCaseKey("ALPHA-148")
    public void testGetAllProductsName() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        Assert.assertTrue(catalogPage.areProductTitlesVisible());
    }

    @Test(suiteName = "Catalog Test")
    @TestCaseKey("ALPHA-149")
    public void verifyProductSortInAscendingOrder() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.sortProduct(SortType.PRICE_LOW_TO_HIGH);
        pause(3L);
        Assert.assertTrue(catalogPage.areProductSortByAscendingPrice());
    }

    @Test(suiteName = "Catalog Test")
    @TestCaseKey("ALPHA-150")
    public void verifyProductSortInDescendingOrder() {
        CatalogPageBase catalogPage = initPage(getDriver(), CatalogPageBase.class);
        catalogPage.sortProduct(SortType.PRICE_LOW_TO_HIGH);
        pause(3L);
        Assert.assertTrue(catalogPage.areProductSortByDescendingName());
    }

}
