package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCategoryPage extends BasePage {

	// constructor for UserSignUpPage

	public ProductCategoryPage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("AllProductsPage not loaded correctly");
		}
	}

	// abstract methods implementation

	@Override
	public boolean isPageLoaded() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Page_Elements.PAGE_HEADER_TEXT.getLocator()));
			return isDisplayed(Page_Elements.PAGE_HEADER_TEXT.getLocator());

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();
	}

	// action methods

	public boolean validateWomenDressProduct() {
		return isDisplayed(Page_Elements.WOMEN_DRESS_PRODUCTS.getLocator());
	}

	public boolean validateMenTshirtsProduct() {
		return isDisplayed(Page_Elements.MEN_TSHIRTS_PRODUCTS.getLocator());
	}

	// locators for UserSignUpPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//h2[contains(text(),'Category')]")),
		WOMEN_DRESS_PRODUCTS(By.xpath("//h2[contains(text(),'Women - Dress Products')]")),
		MEN_TSHIRTS_PRODUCTS(By.xpath("//h2[contains(text(),'Men - Tshirts Products')]"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}

	}
}
