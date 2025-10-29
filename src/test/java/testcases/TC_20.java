package testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import constants.Constants;
import pageObjects.AllProductsPage;
import pageObjects.HomePage;
import pageObjects.LoginOrSignUpPage;
import pageObjects.ShoppingCartPage;
import utilities.DataProviders;

public class TC_20 extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataProviders.class)
	public void testTC_18(Map<String, String> data) {

		HomePage homePage = new HomePage(driver);
		homePage.clickProducts();

		AllProductsPage allProductsPage = new AllProductsPage(driver);
		Assert.assertTrue(allProductsPage.isPageLoaded(), "All Products page not loaded");

		allProductsPage.populateSearchProduct(data.get(Constants.SEARCH_PRODUCT));
		Assert.assertTrue(allProductsPage.validateSearchedProducts(), "The product you searched is not visible");

		allProductsPage.scrollElementIntoView();
		allProductsPage.addProductsToCart();
		homePage.populateCart();

		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(shoppingCartPage.getAddedProductCount() >= 1, "No Product is added to the cart");
		shoppingCartPage.clickRegisterOrLoginButton();

		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.populateLogin(data.get(Constants.LOGIN_EMAIL), data.get(Constants.LOGIN_PASSWORD));

		homePage.populateCart();
		Assert.assertTrue(shoppingCartPage.getAddedProductCount() >= 1, "No Product is added to the cart");
	}

}
