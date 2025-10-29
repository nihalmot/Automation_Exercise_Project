package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pageObjects.HomePage;
import pageObjects.ProductBrandPage;
import pageObjects.ProductCategoryPage;

public class TC_19 extends BaseTest {

	@Test
	public void testTC_18() {

		HomePage homePage = new HomePage(driver);
		homePage.clickProducts();

		ProductBrandPage productBrandPage = new ProductBrandPage(driver);
		Assert.assertEquals(productBrandPage.getBrandsList(), 8, "All Brands are not Visible");

		productBrandPage.clickBrandAllenSollyJunior();
		Assert.assertTrue(productBrandPage.validateProductsFromBrandAllenSollyJunior(),
				"Products from Brand Allen Solly is not displayed");

		productBrandPage.clickBrandKookieKids();
		Assert.assertTrue(productBrandPage.validateProductsFromBrandKookieKids(),
				"Products from Brand Kookie Kids is not displayed");

	}

}
