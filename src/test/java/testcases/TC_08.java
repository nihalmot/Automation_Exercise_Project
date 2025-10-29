package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pageObjects.AllProductsPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailsPage;

public class TC_08 extends BaseTest {

	@Test
	public void testTC_06() {

		HomePage homePage = new HomePage(driver);
		homePage.clickProducts();
		
		AllProductsPage allProductsPage = new AllProductsPage(driver);
		Assert.assertEquals(34, allProductsPage.validateProductList(),"product list is not visible");
		allProductsPage.scrollElementIntoView();
		allProductsPage.viewFirstProduct();
		
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsPage.validateVisibilityOfProductName(), "Product name is not visible");
		Assert.assertTrue(productDetailsPage.validateVisibilityOfProductCategory(), "Product category is not visible");
		Assert.assertTrue(productDetailsPage.validateVisibilityOfProductPrice(), "Product price is not visible");
		Assert.assertTrue(productDetailsPage.validateVisibilityOfProductAvailability(), "Product availability is not visible");
		Assert.assertTrue(productDetailsPage.validateVisibilityOfProductCondition(), "Product condition is not visible");
		Assert.assertTrue(productDetailsPage.validateVisibilityOfProductBrand(), "Product brand is not visible");
		
		
	}

}
