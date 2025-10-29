package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserSignUpPage extends BasePage {

	// constructor for UserSignUpPage

	public UserSignUpPage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("UserSignUpPage not loaded correctly");
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

	public void chooseTitle(String label) {
		selectRadioButtonByLabel(Page_Elements.NAME_TITLE.getLocator(), label);
	}

	public void choosePassword(String password) {
		typeIntoField(Page_Elements.REGISTER_PASSWORD.getLocator(), password);
	}

	public void selectDOB(String day, String month, String year) {
		selectFromDropdown(Page_Elements.DOB_DAY.getLocator(), day);
		selectFromDropdown(Page_Elements.DOB_MONTH.getLocator(), month);
		selectFromDropdown(Page_Elements.DOB_YEAR.getLocator(), year);
	}

	public void selectSignupNewsletter() {
		clickElement(Page_Elements.SIGNUP_NEWSLETTER.getLocator());
	}

	public void selectSignupOffers() {
		clickElement(Page_Elements.SIGNUP_OFFERS.getLocator());
	}

	public void enterFirstName(String fname) {
		typeIntoField(Page_Elements.FIRST_NAME.getLocator(), fname);
	}

	public void enterLastName(String lname) {
		typeIntoField(Page_Elements.LAST_NAME.getLocator(), lname);
	}

	public void enterCompany(String company) {
		typeIntoField(Page_Elements.COMPANY.getLocator(), company);
	}

	public void enterAddress1(String add1) {
		typeIntoField(Page_Elements.ADDRESS_1.getLocator(), add1);
	}

	public void enterAddress2(String add2) {
		typeIntoField(Page_Elements.ADDRESS_2.getLocator(), add2);
	}

	public void selectCountry(String country) {
		selectFromDropdown(Page_Elements.COUNTRY.getLocator(), country);
	}

	public void enterState(String state) {
		typeIntoField(Page_Elements.STATE.getLocator(), state);
	}

	public void enterCity(String city) {
		typeIntoField(Page_Elements.CITY.getLocator(), city);
	}

	public void enterZipcode(String zipcode) {
		typeIntoField(Page_Elements.ZIPCODE.getLocator(), zipcode);
	}

	public void enterMobileNumber(String mobno) {
		typeIntoField(Page_Elements.MOBILE_NUMBER.getLocator(), mobno);
	}

	public void clickCreateAccount() {
		clickElement(Page_Elements.CREATE_ACCOUNT.getLocator());
	}

	public boolean validateAccountCreated() {
		return isDisplayed(Page_Elements.ACCOUNT_CREATED_TEXT.getLocator());
	}

	public boolean validateAccountDeleted() {
		return isDisplayed(Page_Elements.ACCOUNT_DELETED_TEXT.getLocator());
	}
	
	public void clickContinue() {
		clickElement(Page_Elements.CONTINUE_BUTTON.getLocator());
	}

	public void scrollElementIntoView()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(Page_Elements.CREATE_ACCOUNT.getLocator()));
	}
	// locators for UserSignUpPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//b[contains(text(),'Enter Account Information')]|//div[@class='logo pull-left']//a")),
		NAME_TITLE(By.xpath("//div[@class='radio-inline']")), REGISTER_PASSWORD(By.xpath("//input[@id='password']")),
		DOB_DAY(By.xpath("//select[@name='days']")), DOB_MONTH(By.xpath("//select[@name='months']")),
		DOB_YEAR(By.xpath("//select[@name='years']")),
		SIGNUP_NEWSLETTER(By.xpath("//label[contains(text(),'Sign up for our newsletter!')]")),
		SIGNUP_OFFERS(By.xpath("//label[contains(text(),'Receive special offers from our partners!')]")),
		FIRST_NAME(By.xpath("//input[@name='first_name']")), LAST_NAME(By.xpath("//input[@name='last_name']")),
		COMPANY(By.xpath("//input[@name='company']")), ADDRESS_1(By.xpath("//input[@name='address1']")),
		ADDRESS_2(By.xpath("//input[@name='address2']")), COUNTRY(By.xpath("//select[@name='country']")),
		STATE(By.xpath("//input[@name='state']")), CITY(By.xpath("//input[@name='city']")),
		ZIPCODE(By.xpath("//input[@name='zipcode']")), MOBILE_NUMBER(By.xpath("//input[@name='mobile_number']")),
		CREATE_ACCOUNT(By.xpath("//button[contains(text(),'Create Account')]")),
		ACCOUNT_CREATED_TEXT(By.xpath("//b[contains(text(),'Account Created!')]")),
		ACCOUNT_DELETED_TEXT(By.xpath("//b[contains(text(),'Account Deleted!')]")),
		CONTINUE_BUTTON(By.xpath("//a[contains(text(),'Continue')]"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}

	}
}
