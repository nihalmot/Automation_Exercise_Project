package basetest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/*
 * BaseTest is a reusable utility class which will be used in every test cases
 */

public class BaseTest {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass
	// public void setup(String os, String browser) throws IOException
	public void setup() throws IOException {
		// loading config.properties file

		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		/*
		 * it automatically fetches the log4j2.xml file from test/resources
		 */
		logger = LogManager.getLogger(this.getClass());

		/*
		 * if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
		 * DesiredCapabilities capabilities = new DesiredCapabilities();
		 * 
		 * // for os selection if (os.equalsIgnoreCase("windows")) {
		 * capabilities.setPlatform(Platform.WIN11); } else if
		 * (os.equalsIgnoreCase("mac")) { capabilities.setPlatform(Platform.MAC); } else
		 * { System.out.println("No matching os"); }
		 * 
		 * // for browser selection switch (browser.toLowerCase()) { case "chrome":
		 * capabilities.setBrowserName("chrome"); break; case "edge":
		 * capabilities.setBrowserName("MicrosoftEdge"); break; case "firefox":
		 * capabilities.setBrowserName("firefox"); break; default:
		 * System.out.println("No matching browser"); return; }
		 * 
		 * driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
		 * capabilities);
		 * 
		 * }
		 */

		/*
		 * if (p.getProperty("execution_env").equalsIgnoreCase("local")) { switch
		 * (browser.toLowerCase()) { case "chrome": driver = new ChromeDriver(); break;
		 * case "edge": driver = new EdgeDriver(); break; case "firefox": driver = new
		 * FirefoxDriver(); break; default:
		 * System.out.println("Invalid browser name......"); return; } }
		 */

		// === ChromeOptions Setup ===
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-popup-blocking");
		
		// Add this line for CI (headless mode)
		options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");

		
		options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {
			{
				put("credentials_enable_service", false);
				put("profile.password_manager_enabled", false);
			}
		});

		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

	/*
	 * method to capture the screenshot of a page on test failure
	 * 
	 */

	public String captureScreen(String tname) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

}
