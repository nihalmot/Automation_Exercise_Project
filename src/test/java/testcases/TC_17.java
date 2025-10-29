package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pageObjects.HomePage;
import pageObjects.ShoppingCartPage;
import utilities.DataProviders;

public class TC_17 extends BaseTest {

	@Test
	public void testTC_15() {

		HomePage homePage = new HomePage(driver);
		homePage.scrollElementIntoView();
		homePage.addFirstProductToCart();
		homePage.clickViewCart();

		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.clickRemoveFirstProduct();

		Assert.assertTrue(shoppingCartPage.validateEmptyCart(), "Cart is not empty");
	}

}
