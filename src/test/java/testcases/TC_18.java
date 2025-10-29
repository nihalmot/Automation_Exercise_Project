package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import basetest.BaseTest;
import pageObjects.HomePage;
import pageObjects.ProductCategoryPage;

public class TC_18 extends BaseTest {

	@Test
	public void testTC_18() {

		HomePage homePage = new HomePage(driver);
		homePage.scrollElementTillKidsCategory();
		Assert.assertTrue(homePage.validateCategoryVisibility(), "Categories are not visible");
		homePage.clickOnWomenCategory();
		homePage.clickOnWomenCategoryDress();

		ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);
		Assert.assertTrue(productCategoryPage.validateWomenDressProduct(), "Women dress product text is not displayed");

		homePage.clickOnMenCategory();
		homePage.clickOnMenCategoryTshirts();

		Assert.assertTrue(productCategoryPage.validateMenTshirtsProduct(), "Men Tshirts Product text is not displayed");

	}

}
