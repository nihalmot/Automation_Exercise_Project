package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import constants.Constants;

public class ContactUsPage extends BasePage {

	// constructor for UserSignUpPage

	public ContactUsPage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("ContactUsPage not loaded correctly");
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

	public void enterName(String name) {
		typeIntoField(Page_Elements.NAME.getLocator(), name);
	}

	public void enterEmail(String email) {
		typeIntoField(Page_Elements.EMAIL.getLocator(), email);
	}

	public void enterSubject(String subject) {
		typeIntoField(Page_Elements.SUBJECT.getLocator(), subject);
	}

	public void enterMessage(String message) {
		typeIntoField(Page_Elements.MESSAGE.getLocator(), message);
	}

	public void uploadFile() {
		getElement(Page_Elements.CHOOSE_FILE.getLocator()).sendKeys(Constants.PATH);
	}

	public void clickOnSubmit() {
		clickElement(Page_Elements.SUBMIT.getLocator());
	}

	public void clickOk() {
		handleAlerts();
	}

	public boolean validateSuccessMessage() {
		return isDisplayed(Page_Elements.SUCCESS_MESSAGE.getLocator());
	}

	public void clickHomeButton() {
		clickElement(Page_Elements.HOME_BUTTON.getLocator());
	}

	// locators for UserSignUpPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//h2[contains(text(),'Contact')]|//h2[contains(text(),'Get In Touch')]")),
		NAME(By.xpath("//input[@name='name']")), EMAIL(By.xpath("//input[@name='email']")),
		SUBJECT(By.xpath("//input[@name='subject']")), MESSAGE(By.xpath("//textarea[@name='message']")),
		CHOOSE_FILE(By.xpath("//input[@name='upload_file']")), SUBMIT(By.xpath("//input[@name='submit']")),
		SUCCESS_MESSAGE(By.xpath("(//div[contains(text(),'Success!')])[1]")),
		HOME_BUTTON(By.xpath("//a[@class='btn btn-success']"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}

	}
}
