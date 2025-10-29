package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pageObjects.HomePage;
import pageObjects.ShoppingCartPage;

public class TC_22 extends BaseTest {

	@Test
	public void testTC_18() {

		HomePage homePage = new HomePage(driver);
		homePage.scrollElementIntoView();

		Assert.assertTrue(homePage.validateRecommendedItems(), "Recommended Items are not visible");
		homePage.addRecommendedItemsToCart();
		homePage.clickRecommendedItemsRightArrow();
		homePage.addRecommendedItemsToCart();

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		homePage.populateCart();

		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		Assert.assertEquals(shoppingCartPage.getAddedProductCount(), 6, "All the products are not added into the cart");

	}

}
