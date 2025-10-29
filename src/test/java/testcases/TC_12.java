package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import constants.Constants;
import pageObjects.AllProductsPage;
import pageObjects.HomePage;
import pageObjects.ShoppingCartPage;
import utilities.DataProviders;

public class TC_12 extends BaseTest {

	@Test
	public void testTC_12() {

		HomePage homePage = new HomePage(driver);
		homePage.clickProducts();

		AllProductsPage allProductsPage = new AllProductsPage(driver);
		allProductsPage.scrollElementIntoView();
		allProductsPage.addFirstProductToCart();
		allProductsPage.clickContinueShopping();
		allProductsPage.addSecondProductToCart();
		allProductsPage.clickViewCart();

		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		Assert.assertEquals(shoppingCartPage.getAddedProductCount(), 2, "All products are not added into cart");

		Assert.assertEquals(shoppingCartPage.validateFirstProductPrice(), "Rs. 500",
				"Price missmatch for first product");
		Assert.assertEquals(shoppingCartPage.validateSecondProductPrice(), "Rs. 400",
				"Price missmatch for second product");

		Assert.assertEquals(shoppingCartPage.validateFirstProductQuantity(), "1",
				"Quantity missmatch for first product");
		Assert.assertEquals(shoppingCartPage.validateSecondProductQuantity(), "1",
				"Quantity missmatch for second product");

	}

}
