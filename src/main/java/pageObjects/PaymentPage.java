package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends BasePage {

	// constructor for UserSignUpPage

	public PaymentPage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("PaymentPage not loaded correctly");
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

	public void enterNameOnCard(String name) {
		typeIntoField(Page_Elements.NAME_ON_CARD.getLocator(), name);
	}

	public void enterCardNumber(String cardnum) {
		typeIntoField(Page_Elements.CARD_NUMBER.getLocator(), cardnum);
	}

	public void enterCVC(String cvc) {
		typeIntoField(Page_Elements.CVC.getLocator(), cvc);
	}

	public void enterExpieryMonth(String expmonth) {
		typeIntoField(Page_Elements.EXPIERY_MONTH.getLocator(), expmonth);
	}

	public void enterExpieryYear(String expyear) {
		typeIntoField(Page_Elements.EXPIERY_YEAR.getLocator(), expyear);
	}

	public void payAndConfirmOrder() {
		clickElementWithJavascriptExecutor(getElement(Page_Elements.PAY_AND_CONFIRM_ORDER.getLocator()));

	}

	public boolean validateOrderConfirmation() {
		return isDisplayed(Page_Elements.ORDER_CONFIRMATION.getLocator());
	}

	public void scrollElementIntoView() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getElement(Page_Elements.PAY_AND_CONFIRM_ORDER.getLocator()));
	}

	public void clickDownloadInvoice() {
		clickElement(Page_Elements.DOWNLOAD_INVOICE.getLocator());
	}

	// locators for UserSignUpPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//li[contains(text(),'Payment')]")),
		NAME_ON_CARD(By.xpath("//input[@name='name_on_card']")), CARD_NUMBER(By.xpath("//input[@name='card_number']")),
		CVC(By.xpath("//input[@name='cvc']")), EXPIERY_MONTH(By.xpath("//input[@name='expiry_month']")),
		EXPIERY_YEAR(By.xpath("//input[@name='expiry_year']")),
		PAY_AND_CONFIRM_ORDER(By.xpath("//button[@id='submit']")),
		ORDER_CONFIRMATION(By.xpath("//b[contains(text(),'Order Placed!')]")),
		DOWNLOAD_INVOICE(By.xpath("//a[contains(text(),'Download Invoice')]"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}

	}
}
