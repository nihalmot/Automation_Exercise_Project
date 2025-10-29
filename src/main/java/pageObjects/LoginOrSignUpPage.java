package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginOrSignUpPage extends BasePage {

	// constructor for LoginOrSignUpPage

	public LoginOrSignUpPage(WebDriver driver) {
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

	public void populateLogin(String email, String pass) {
		typeIntoField(Page_Elements.LOGIN_EMAIL.getLocator(), email);
		typeIntoField(Page_Elements.LOGIN_PASSWORD.getLocator(), pass);
		clickElement(Page_Elements.LOGIN_BUTTON.getLocator());

	}

	public void populateSignUp(String name, String email) {
		typeIntoField(Page_Elements.SIGNUP_NAME.getLocator(), name);
		typeIntoField(Page_Elements.SIGNUP_EMAIL.getLocator(), email);
		clickElement(Page_Elements.SIGNUP_BUTTON.getLocator());
	}

	public boolean validateInvalidCredentials() {
		return isDisplayed(Page_Elements.INVALID_CREDENTIALS.getLocator());
	}

	public boolean validateEmailAlreadyExistMsg() {
		return isDisplayed(Page_Elements.EMAIL_ALREADY_EXIST.getLocator());
	}

	// locators for LoginOrSignUpPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(
				By.xpath("//h2[contains(text(),'Login to your account')]|//h2[contains(text(),'New User Signup!')]")),
		LOGIN_EMAIL(By.xpath("//div[@class='login-form']//input[@name='email']")),
		LOGIN_PASSWORD(By.xpath("//input[@name='password']")), SIGNUP_NAME(By.xpath("//input[@name='name']")),
		SIGNUP_EMAIL(By.xpath("//div[@class='signup-form']//input[@name='email']")),
		LOGIN_BUTTON(By.xpath("//button[contains(text(),'Login')]")),
		SIGNUP_BUTTON(By.xpath("//button[contains(text(),'Signup')]")),
		INVALID_CREDENTIALS(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")),
		EMAIL_ALREADY_EXIST(By.xpath("//p[contains(text(),'Email Address already exist!')]"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}
	}

}
