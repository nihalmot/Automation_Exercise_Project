package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllProductsPage extends BasePage {

	// constructor for UserSignUpPage

	public AllProductsPage(WebDriver driver) {
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

	public int validateProductList() {
		return getElements(Page_Elements.PRODUCT_LIST.getLocator()).size();
	}

	public void viewFirstProduct() {
		clickElement(Page_Elements.FIRST_PRODUCT.getLocator());
	}

	public void scrollElementIntoView() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getElement(Page_Elements.SUBSCRIPTION.getLocator()));
	}

	public void populateSearchProduct(String product) {
		typeIntoField(Page_Elements.SEARCH_PRODUCT_OPTION.getLocator(), product);
		clickElement(Page_Elements.SEARCH_BUTTON.getLocator());
	}

	public boolean validateSearchedProducts() {
		return isDisplayed(Page_Elements.SEARCHED_PRODUCTS.getLocator());
	}

	public void addFirstProductToCart() {
		clickElement(Page_Elements.ADD_FIRST_PRODUCT_TO_CART.getLocator());
	}

	public void clickContinueShopping() {
		clickElement(Page_Elements.CONTINUE_SHOPPING_BUTTON.getLocator());
	}

	public void addSecondProductToCart() {
		clickElement(Page_Elements.ADD_SECOND_PRODUCT_TO_CART.getLocator());
	}

	public void clickViewCart() {
		clickElement(Page_Elements.VIEW_CART.getLocator());
	}

	public void addProductsToCart() {
		List<WebElement> elements = getElements(Page_Elements.ADD_PRODUCTS_TO_CART.getLocator());
		for (WebElement element : elements) {
			clickElementWithJavascriptExecutor(element);

			clickContinueShopping();
		}
	}

	// locators for UserSignUpPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//h2[contains(text(),'All Products')]")),
		PRODUCT_LIST(By.xpath("//div[@class='features_items']//div[@class='col-sm-4']")),
		FIRST_PRODUCT(By
				.xpath("(//div[@class='col-sm-4']//div[@class='product-image-wrapper']//div[@class='choose'][1])[1]")),
		SEARCH_PRODUCT_OPTION(By.xpath("//input[@id='search_product']")),
		SEARCH_BUTTON(By.xpath("//button[@id='submit_search']")),
		SEARCHED_PRODUCTS(By.xpath("//div[@class='features_items']//div[@class='col-sm-4']")),
		ADD_FIRST_PRODUCT_TO_CART(By.xpath("(//div[@class='productinfo text-center']//a)[1]")),
		CONTINUE_SHOPPING_BUTTON(By.xpath("//button[contains(text(),'Continue Shopping')]")),
		ADD_SECOND_PRODUCT_TO_CART(By.xpath("(//div[@class='productinfo text-center']//a)[2]")),
		VIEW_CART(By.xpath("//P[@class='text-center'][2]//a")),
		ADD_PRODUCTS_TO_CART(By.xpath("//div[@class='productinfo text-center']//a")),
		SUBSCRIPTION(By.xpath("//button[@id='subscribe']"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}

	}
}
