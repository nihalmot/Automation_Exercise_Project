package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductBrandPage extends BasePage {

	// constructor for UserSignUpPage

	public ProductBrandPage(WebDriver driver) {
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

	public int getBrandsList() {
		return getElements(Page_Elements.PRODUCTS_BRAND_LISTS.getLocator()).size();
	}

	public void clickBrandPolo() {
		clickElement(Page_Elements.PRODUCT_BRAND_POLO.getLocator());
	}

	public boolean validateProductsFromBrandPolo() {
		return isDisplayed(Page_Elements.BRAND_POLO_PRODUCTS.getLocator());
	}

	public void clickBrandHnM() {
		clickElement(Page_Elements.PRODUCT_BRAND_HNM.getLocator());
	}

	public boolean validateProductsFromBrandHnM() {
		return isDisplayed(Page_Elements.BRAND_HNM_PRODUCTS.getLocator());
	}

	public void clickBrandMadame() {
		clickElement(Page_Elements.PRODUCT_BRAND_MADAME.getLocator());
	}

	public boolean validateProductsFromBrandMadame() {
		return isDisplayed(Page_Elements.BRAND_MADAME_PRODUCTS.getLocator());
	}

	public void clickBrandMastnHarbour() {
		clickElement(Page_Elements.PRODUCT_BRAND_MASTNHARBOUR.getLocator());
	}

	public boolean validateProductsFromBrandMastnHarbour() {
		return isDisplayed(Page_Elements.BRAND_MASTNHARBOUR_PRODUCTS.getLocator());
	}

	public void clickBrandBabyHug() {
		clickElement(Page_Elements.PRODUCT_BRAND_BABYHUG.getLocator());
	}

	public boolean validateProductsFromBrandBabyHug() {
		return isDisplayed(Page_Elements.BRAND_BABYHUG_PRODUCTS.getLocator());
	}

	public void clickBrandAllenSollyJunior() {
		clickElement(Page_Elements.PRODUCT_BRAND_ALLENSOLLYJUNIOR.getLocator());
	}

	public boolean validateProductsFromBrandAllenSollyJunior() {
		return isDisplayed(Page_Elements.BRAND_ALLENSOLLYJUNIOR_PRODUCTS.getLocator());
	}

	public void clickBrandKookieKids() {
		clickElement(Page_Elements.PRODUCT_BRAND_KOOKIEKIDS.getLocator());
	}

	public boolean validateProductsFromBrandKookieKids() {
		return isDisplayed(Page_Elements.BRAND_KOOKIEKIDS_PRODUCTS.getLocator());
	}

	public void clickBrandBiba() {
		clickElement(Page_Elements.PRODUCT_BRAND_BIBA.getLocator());
	}

	public boolean validateProductsFromBrandBiba() {
		return isDisplayed(Page_Elements.BRAND_BIBA_PRODUCTS.getLocator());
	}

	// locators for UserSignUpPage

	private enum Page_Elements {
		PAGE_HEADER_TEXT(By.xpath("//h2[contains(text(),'Brands')]")),
		PRODUCTS_BRAND_LISTS(By.xpath("//div[@class='brands-name']//ul//li")),
		PRODUCT_BRAND_POLO(By.xpath("//div[@class='brands-name']//ul//li[1]//a")),
		BRAND_POLO_PRODUCTS(By.xpath("//h2[contains(text(),'Brand - Polo Products')]")),
		PRODUCT_BRAND_HNM(By.xpath("//div[@class='brands-name']//ul//li[2]//a")),
		BRAND_HNM_PRODUCTS(By.xpath("//h2[contains(text(),'Brand - H&M Products')]")),
		PRODUCT_BRAND_MADAME(By.xpath("//div[@class='brands-name']//ul//li[3]//a")),
		BRAND_MADAME_PRODUCTS(By.xpath("//h2[contains(text(),'Brand - Madame Products')]")),
		PRODUCT_BRAND_MASTNHARBOUR(By.xpath("//div[@class='brands-name']//ul//li[4]//a")),
		BRAND_MASTNHARBOUR_PRODUCTS(By.xpath("//h2[contains(text(),'Brand - Mast & Harbour Products')]")),
		PRODUCT_BRAND_BABYHUG(By.xpath("//div[@class='brands-name']//ul//li[5]//a")),
		BRAND_BABYHUG_PRODUCTS(By.xpath("//h2[contains(text(),'Brand - Babyhug Products')]")),
		PRODUCT_BRAND_ALLENSOLLYJUNIOR(By.xpath("//div[@class='brands-name']//ul//li[6]//a")),
		BRAND_ALLENSOLLYJUNIOR_PRODUCTS(By.xpath("//h2[contains(text(),'Brand - Allen Solly Junior Products')]")),
		PRODUCT_BRAND_KOOKIEKIDS(By.xpath("//div[@class='brands-name']//ul//li[7]//a")),
		BRAND_KOOKIEKIDS_PRODUCTS(By.xpath("//h2[contains(text(),'Brand - Kookie Kids Products')]")),
		PRODUCT_BRAND_BIBA(By.xpath("//div[@class='brands-name']//ul//li[8]//a")),
		BRAND_BIBA_PRODUCTS(By.xpath("//h2[contains(text(),'Brand - Biba Products')]"));

		private final By locator;

		Page_Elements(By locator) {
			this.locator = locator;
		}

		public By getLocator() {
			return this.locator;
		}

	}
}
