package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

	// constructor for UserSignUpPage

	public CheckoutPage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("CheckoutPage not loaded correctly");
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

	public boolean validateAddressDetails() {
		return isDisplayed(Page_Elements.VERIFY_ADDRESS_DETAILS.getLocator());
	}

	public boolean reviewYourOrder() {
		return isDisplayed(Page_Elements.REVIEW_YOUR_ORDER.getLocator());
	}

	public void typeCommentForOrder(String comment) {
		typeIntoField(Page_Elements.ORDER_COMMENT.getLocator(), comment);
	}

	public void clickPlaceOrder() {
		clickElement(Page_Elements.PLACE_ORDER.getLocator());
	}

	public void scrollElementIntoView() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getElement(Page_Elements.PLACE_ORDER.getLocator()));
	}

	// locators for UserSignUpPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//li[contains(text(),'Checkout')]")),
		VERIFY_ADDRESS_DETAILS(By.xpath("//div[@class='checkout-information']")),
		REVIEW_YOUR_ORDER(By.xpath("//table[@class='table table-condensed']")),
		ORDER_COMMENT(By.xpath("//textarea[@class='form-control']")),
		PLACE_ORDER(By.xpath("//a[contains(text(),'Place Order')]"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}

	}
}
