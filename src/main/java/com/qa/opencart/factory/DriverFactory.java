package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	WebDriver driver;
	Properties prop;
	OptionsManager options;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(Properties prop) {

		String browser = prop.getProperty("browser");
		System.out.println("Browser name is " + browser);
		options = new OptionsManager(prop);

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Bimlesh\\Upskilling\\Framework\\Driver files\\Chrome\\chromedriver-win64\\chromedriver.exe");
			// driver = new ChromeDriver(options.getChromeOptions());
			tldriver.set(new ChromeDriver(options.getChromeOptions()));
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Bimlesh\\Upskilling\\Framework\\Driver files\\Firefox\\geckodriver-v0.34.0-win64\\geckodriver.exe");
			// driver = new FirefoxDriver(options.getFirefoxOptions());
			tldriver.set(new FirefoxDriver(options.getFirefoxOptions()));

			break;

		case "edge":
			System.setProperty("webdriver.edge.driver",
					"C:\\Bimlesh\\Upskilling\\Framework\\Driver files\\Edge\\msedgedriver.exe");
			// driver = new EdgeDriver(options.getEdgeOptions());
			tldriver.set(new EdgeDriver(options.getEdgeOptions()));

			break;

		case "safari":
			// driver = new SafariDriver();
			tldriver.set(new SafariDriver());
			break;

		default:
			System.out.println("Please pass a valid browser " + browser + " is not a valid browser");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));

		return getDriver();
	}

	public static WebDriver getDriver() {
		return tldriver.get();
	}

	public Properties init_prop() {

		String env = "qa";
		FileInputStream fis = null;
		prop = new Properties();

		try {
			if (env.trim().toLowerCase() == null) {
				System.out.println("No environment is specified.. hence using the default environment which is QA");
				fis = new FileInputStream("./src/test/resources/config/qa.config.properties");

			}else
			{
				switch(env.trim().toLowerCase()) {
				
				case "dev":
					fis = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
					
				case "qa":
					fis = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
					
				case "stage":
					fis = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
					
					default:
						System.out.println("Environment name mentioned is incorrect "+env);
				}
			}
			
			prop.load(fis);

		} catch (Exception e) {

		}

		return prop;
	}
}
