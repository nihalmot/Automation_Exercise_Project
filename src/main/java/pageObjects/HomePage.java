package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	// constructor for HomePage

	public HomePage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("Home Page not loaded correctly");
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

	public void clickLoginOrSignUp() {
		clickElement(Page_Elements.LOGIN_SIGNUP_BUTTON.getLocator());
	}

	public boolean validateUserLogin() {
		return isDisplayed(Page_Elements.LOGGED_IN_USER.getLocator());
	}

	public void clickDeleteAccount() {
		clickElement(Page_Elements.DELETE_ACCOUNT.getLocator());
	}

	public boolean validateAccountDeleted() {
		return isDisplayed(Page_Elements.ACCOUNT_DELETED.getLocator());
	}

	public void clickLogoutAccount() {
		clickElement(Page_Elements.LOGOUT_ACCOUNT.getLocator());
	}

	public void clickContactUs() {
		clickElement(Page_Elements.CONTACT_US.getLocator());
	}

	public void clickTestCases() {
		clickElement(Page_Elements.TEST_CASES.getLocator());
	}

	public void clickProducts() {
		clickElement(Page_Elements.PRODUCTS_BUTTON.getLocator());
	}

	public boolean verifySubscriptionText() {
		return isDisplayed(Page_Elements.SUBSCRIPTION_TEXT.getLocator());
	}

	public void scrollElementIntoView() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getElement(Page_Elements.SUBSCRIPTION_TEXT.getLocator()));
	}

	public void populateEmailSubscription(String email) {
		typeIntoField(Page_Elements.SUBSCRIPTION_EMAIL.getLocator(), email);
		clickElement(Page_Elements.SUBSCRIBE.getLocator());
	}

	public String validateSubscriptionMessage() {
		return getText(Page_Elements.SUBSCRIPTION_MESSAGE.getLocator());
	}

	public void populateCart() {
		clickElement(Page_Elements.CART_BUTTON.getLocator());
	}

	public void clickViewProduct() {
		clickElement(Page_Elements.VIEW_PRODUCT.getLocator());
	}

	public void addFirstProductToCart() {
		clickElement(Page_Elements.ADD_FIRST_PRODUCT_TO_CART.getLocator());
	}

	public void clickViewCart() {
		clickElement(Page_Elements.VIEW_CART.getLocator());
	}

	public boolean validateCategoryVisibility() {
		return isDisplayed(Page_Elements.CATEGORY.getLocator());
	}

	public void clickOnWomenCategory() {
		clickElement(Page_Elements.WOMEN_CATEGORY.getLocator());
	}

	public void clickOnWomenCategoryDress() {
		clickElementWithJavascriptExecutor(getElement(Page_Elements.PRODUCT_WOMEN_DRESS.getLocator()));
	}

	public void clickOnWomenCategoryTops() {
		clickElement(Page_Elements.PRODUCT_WOMEN_TOPS.getLocator());
	}

	public void clickOnWomenCategorySaree() {
		clickElement(Page_Elements.PRODUCT_WOMEN_SAREE.getLocator());
	}

	public void clickOnMenCategory() {
		clickElement(Page_Elements.MEN_CATEGORY.getLocator());
	}

	public void clickOnMenCategoryTshirts() {
		clickElement(Page_Elements.PRODUCT_MEN_TSHIRTS.getLocator());
	}

	public void clickOnMenCategoryJeans() {
		clickElement(Page_Elements.PRODUCT_MEN_JEANS.getLocator());
	}

	public void clickOnKidsCategory() {
		clickElement(Page_Elements.KIDS_CATEGORY.getLocator());
	}

	public void clickOnKidsCategoryDress() {
		clickElement(Page_Elements.PRODUCT_KIDS_DRESS.getLocator());
	}

	public void clickOnKidsCategoryTopsAndShirts() {
		clickElement(Page_Elements.PRODUCT_KIDS_TOPS_SHIRTS.getLocator());
	}

	public void scrollElementTillKidsCategory() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getElement(Page_Elements.KIDS_CATEGORY.getLocator()));
	}

	public boolean validateRecommendedItems() {
		return isDisplayed(Page_Elements.RECOMMENDED_ITEMS.getLocator());
	}

	public void clickRecommendedItemsLeftArrow() {
		clickElement(Page_Elements.RECOMMENDED_ITEMS_LEFT_ARROW.getLocator());
	}

	public void clickRecommendedItemsRightArrow() {
		clickElement(Page_Elements.RECOMMENDED_ITEMS_RIGHT_ARROW.getLocator());
	}

	public void addRecommendedItemsToCart() {
		List<WebElement> elements = getElements(Page_Elements.RECOMMENDED_ACTIVE_ITEMS.getLocator());
		for (WebElement element : elements) {
			element.click();
			getElement(Page_Elements.CONTINUE_SHOPPING.getLocator()).click();
		}
	}

	public void clickContinueButton() {
		clickElement(Page_Elements.CONTINUE_BUTTON.getLocator());
	}

	public void clickScrollUpButton() {
		clickElement(Page_Elements.SCROLL_UP_BUTTON.getLocator());
	}

	// locators for Home Page
	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//div[@class='logo pull-left']//a")),
		LOGIN_SIGNUP_BUTTON(By.xpath("//ul[@class='nav navbar-nav']//li[4]")),
		LOGGED_IN_USER(By.xpath("//ul[@class='nav navbar-nav']//li[10]")),
		DELETE_ACCOUNT(By.xpath("//ul[@class='nav navbar-nav']//li[5]")),
		ACCOUNT_DELETED(By.xpath("//b[contains(text(),'Account Deleted!')]")),
		LOGOUT_ACCOUNT(By.xpath("//ul[@class='nav navbar-nav']//li[4]")),
		CONTACT_US(By.xpath("//ul[@class='nav navbar-nav']//li[8]")),
		TEST_CASES(By.xpath("//ul[@class='nav navbar-nav']//li[5]")),
		PRODUCTS_BUTTON(By.xpath("//ul[@class='nav navbar-nav']//li[2]")),
		SUBSCRIPTION_TEXT(By.xpath("//h2[contains(text(),'Subscription')]")),
		SUBSCRIPTION_EMAIL(By.xpath("//input[@id='susbscribe_email']")),
		SUBSCRIBE(By.xpath("//button[@id='subscribe']")),
		SUBSCRIPTION_MESSAGE(By.xpath("//*[contains(text(),'You have been successfully subscribed!')]")),
		CART_BUTTON(By.xpath("//ul[@class='nav navbar-nav']//li[3]")),
		VIEW_PRODUCT(By
				.xpath("(//div[@class='col-sm-4']//div[@class='product-image-wrapper']//div[@class='choose'][1])[1]")),
		ADD_FIRST_PRODUCT_TO_CART(By.xpath("(//div[@class='productinfo text-center']//a)[1]")),
		VIEW_CART(By.xpath("//P[@class='text-center'][2]//a")), CATEGORY(By.xpath("//h2[contains(text(),'Category')]")),
		WOMEN_CATEGORY(By.xpath("(//h4[@class='panel-title']//i)[1]")),
		PRODUCT_WOMEN_DRESS(By.xpath("//div[@id='Women']//li[1]//a")),
		PRODUCT_WOMEN_TOPS(By.xpath("//div[@id='Women']//li[2]//a")),
		PRODUCT_WOMEN_SAREE(By.xpath("//div[@id='Women']//li[3]//a")),
		MEN_CATEGORY(By.xpath("(//h4[@class='panel-title']//i)[2]")),
		PRODUCT_MEN_TSHIRTS(By.xpath("//div[@id='Men']//li[1]//a")),
		PRODUCT_MEN_JEANS(By.xpath("//div[@id='Men']//li[2]//a")),
		KIDS_CATEGORY(By.xpath("(//h4[@class='panel-title']//i)[3]")),
		PRODUCT_KIDS_DRESS(By.xpath("//div[@id='Kids']//li[1]//a")),
		PRODUCT_KIDS_TOPS_SHIRTS(By.xpath("//div[@id='Kids']//li[2]//a")),
		RECOMMENDED_ITEMS(By.xpath("//h2[contains(text(),'recommended items')]")),
		RECOMMENDED_ITEMS_LEFT_ARROW(By.xpath("//a[@class='left recommended-item-control']")),
		RECOMMENDED_ITEMS_RIGHT_ARROW(By.xpath("//a[@class='right recommended-item-control']")),
		RECOMMENDED_ACTIVE_ITEMS(
				By.xpath("//div[@class='carousel-inner']//div[@class='item active']//div[@class='col-sm-4']//a")),
		CONTINUE_SHOPPING(By.xpath("//button[contains(text(),'Continue Shopping')]")),
		CONTINUE_BUTTON(By.xpath("//div[@class='pull-right']//a")),
		SCROLL_UP_BUTTON(By.xpath("//a[@id='scrollUp']//i"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}
	}

}
