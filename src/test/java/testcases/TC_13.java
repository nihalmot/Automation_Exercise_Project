package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;
import pageObjects.ShoppingCartPage;

public class TC_13 extends BaseTest {

	@Test
	public void testTC_13() {

		HomePage homePage = new HomePage(driver);
		homePage.scrollElementIntoView();
		homePage.clickViewProduct();

		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		productDetailsPage.enterQuantity("4");
		productDetailsPage.clickAddToCart();
		productDetailsPage.clickViewCart();
		
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		Assert.assertEquals(shoppingCartPage.getAddedProductCount(), 1, "Product is not added to the cart");
		Assert.assertEquals(shoppingCartPage.getProductQuantity(), "4", "Product quantity mismatched on carts page");
	}

}
