package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage {

	// constructor for UserSignUpPage

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("ShoppingCartPage not loaded correctly");
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

	public int getAddedProductCount() {
		return getElements(Page_Elements.TOTAL_PRODUCTS_IN_CART.getLocator()).size();
	}

	public String validateFirstProductPrice() {
		return getElement(Page_Elements.FIRST_PRODUCT_PRICE.getLocator()).getText();
	}

	public String validateSecondProductPrice() {
		return getElement(Page_Elements.SECOND_PRODUCT_PRICE.getLocator()).getText();
	}

	public String validateFirstProductQuantity() {
		return getElement(Page_Elements.FIRST_PRODUCT_QUANTITY.getLocator()).getText();
	}

	public String validateSecondProductQuantity() {
		return getElement(Page_Elements.SECOND_PRODUCT_QUANTITY.getLocator()).getText();
	}

	public String validateFirstProductTotalPrice() {
		return getElement(Page_Elements.FIRST_PRODUCT_TOTAL_PRICE.getLocator()).getText();
	}

	public String validateSecondProductTotalPrice() {
		return getElement(Page_Elements.SECOND_PRODUCT_TOTAL_PRICE.getLocator()).getText();
	}

	public String getProductQuantity() {
		return getElement(Page_Elements.FIRST_PRODUCT_ADDED_QUANTITY.getLocator()).getText();
	}

	public void clickProceedToCheckout() {
		clickElement(Page_Elements.PROCEED_TO_CHECKOUT.getLocator());
	}

	public void clickRegisterOrLoginButton() {
		clickElement(Page_Elements.REGISTER_OR_LOGIN_BUTTON.getLocator());
	}

	public void clickRemoveFirstProduct() {
		clickElement(Page_Elements.FIRST_PRODUCT_REMOVE.getLocator());
	}

	public boolean validateEmptyCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Page_Elements.EMPTY_CART_TEXT.getLocator()));
		return isDisplayed(Page_Elements.EMPTY_CART_TEXT.getLocator());
	}

	public void clickContinueOnCart() {
		clickElement(Page_Elements.CONTINUE_ON_CART.getLocator());
	}

	// locators for UserSignUpPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//ol[@class='breadcrumb']//li[2]")),
		TOTAL_PRODUCTS_IN_CART(By.xpath("//table[@class='table table-condensed']//tbody//tr")),
		FIRST_PRODUCT_PRICE(By.xpath("(//table[@class='table table-condensed']//tbody//tr//td[3]//p)[1]")),
		SECOND_PRODUCT_PRICE(By.xpath("(//table[@class='table table-condensed']//tbody//tr//td[3]//p)[2]")),
		FIRST_PRODUCT_QUANTITY(By.xpath("(//table[@class='table table-condensed']//tbody//tr//td[4])[1]//button")),
		SECOND_PRODUCT_QUANTITY(By.xpath("(//table[@class='table table-condensed']//tbody//tr//td[4])[2]//button")),
		FIRST_PRODUCT_TOTAL_PRICE(By.xpath("(//table[@class='table table-condensed']//tbody//tr//td[5]//P)[1]")),
		SECOND_PRODUCT_TOTAL_PRICE(By.xpath("(//table[@class='table table-condensed']//tbody//tr//td[5]//P)[2]")),
		FIRST_PRODUCT_ADDED_QUANTITY(By.xpath("(//button[@class='disabled'])[1]")),
		PROCEED_TO_CHECKOUT(By.xpath("//div[@class='col-sm-6']//a")),
		REGISTER_OR_LOGIN_BUTTON(
				By.xpath("//u[contains(text(),'Register / Login')]|//ul[@class='nav navbar-nav']//li[4]//a")),
		FIRST_PRODUCT_REMOVE(By.xpath("(//a[@class='cart_quantity_delete'])[1]")),
		EMPTY_CART_TEXT(By.xpath("//b[contains(text(),'Cart is empty!')]")),
		CONTINUE_ON_CART(By.xpath("//button[contains(text(),'Continue On Cart')]"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}

	}
}
