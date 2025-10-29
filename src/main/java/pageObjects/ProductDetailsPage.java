package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends BasePage {

	// constructor for UserSignUpPage

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("ProductDetailsPage not loaded correctly");
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

	public boolean validateVisibilityOfProductName() {
		return isDisplayed(Page_Elements.PRODUCT_NAME.getLocator());
	}

	public boolean validateVisibilityOfProductCategory() {
		return isDisplayed(Page_Elements.PRODUCT_CATEGORY.getLocator());
	}

	public boolean validateVisibilityOfProductPrice() {
		return isDisplayed(Page_Elements.PRODUCT_PRICE.getLocator());
	}

	public boolean validateVisibilityOfProductAvailability() {
		return isDisplayed(Page_Elements.PRODUCT_AVAILABLITY.getLocator());
	}

	public boolean validateVisibilityOfProductCondition() {
		return isDisplayed(Page_Elements.PRODUCT_CONDITION.getLocator());
	}

	public boolean validateVisibilityOfProductBrand() {
		return isDisplayed(Page_Elements.PRODUCT_BRAND.getLocator());
	}

	public void enterQuantity(String qty) {
		typeIntoField(Page_Elements.PRODUCT_QUANTITY.getLocator(), qty);
	}

	public void clickAddToCart() {
		clickElement(Page_Elements.ADD_TO_CART.getLocator());
	}

	public void clickViewCart() {
		clickElement(Page_Elements.VIEW_CART.getLocator());
	}

	public boolean validateWriteYourReviewVisibility() {
		return isDisplayed(Page_Elements.WRITE_YOUR_REVIEW.getLocator());
	}

	public void populateReviewOnProductDetails(String name, String email, String comment) {
		typeIntoField(Page_Elements.REVIEWER_NAME.getLocator(), name);
		typeIntoField(Page_Elements.REVIEWER_EMAIL.getLocator(), email);
		typeIntoField(Page_Elements.REVIEW_COMMENT.getLocator(), email);
		clickElement(Page_Elements.SUBMIT_BUTTON.getLocator());
	}

	public boolean validateThankYouMessageAfterReview()
	{
		return isDisplayed(Page_Elements.THANK_YOU_MESSAGE.getLocator());
	}
	
	// locators for UserSignUpPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//img[@class='newarrival']")),
		PRODUCT_NAME(By.xpath("//h2[contains(text(),'Blue Top')]")),
		PRODUCT_CATEGORY(By.xpath("//p[contains(text(),'Category: Women > Tops')]")),
		PRODUCT_PRICE(By.xpath("//span[contains(text(),'Rs. 500')]")),
		PRODUCT_AVAILABLITY(By.xpath("//div[@class='product-information']//p[2]")),
		PRODUCT_CONDITION(By.xpath("//div[@class='product-information']//p[3]")),
		PRODUCT_BRAND(By.xpath("//div[@class='product-information']//p[4]")),
		PRODUCT_QUANTITY(By.xpath("//input[@name='quantity']")),
		ADD_TO_CART(By.xpath("//button[@class='btn btn-default cart']")),
		VIEW_CART(By.xpath("//P[@class='text-center'][2]//a")),
		WRITE_YOUR_REVIEW(By.xpath("//a[contains(text(),'Write Your Review')]")),
		REVIEWER_NAME(By.xpath("//input[@id='name']")), REVIEWER_EMAIL(By.xpath("//input[@id='email']")),
		REVIEW_COMMENT(By.xpath("//textarea[@name='review']")),
		SUBMIT_BUTTON(By.xpath("//button[@id='button-review']")),
		THANK_YOU_MESSAGE(By.xpath("//*[contains(text(),'Thank you for your review.')]"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}

	}
}
