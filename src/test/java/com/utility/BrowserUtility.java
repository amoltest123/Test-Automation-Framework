package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching browser for " + browserName);

		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

		} else {
			logger.error("Inavlid browserName...!! enter either chrome, edge or firefox");

			System.err.println("Inavlid browserName...!! enter either chrome or edge");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching browser for " + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			logger.error("Inavlid browserName...!! enter either chrome, edge or firefox");

			System.err.println("Inavlid browserName...!! enter either chrome, edge or firefox");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching browser for " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless=old");
				chromeOptions.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(chromeOptions));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
				driver.get().manage().window().maximize();
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments("--headless=old");
				edgeOptions.addArguments("disable-gpu");
				driver.set(new EdgeDriver(edgeOptions));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--headless=old");
				driver.set(new FirefoxDriver(firefoxOptions));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
		} else {
			logger.error("Inavlid browserName...!! enter either chrome, edge or firefox");

			System.err.println("Inavlid browserName...!! enter either chrome, edge or firefox");
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximising the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding elements with locator " + locator);
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Element found and now performing click");
		element.click();
	}
	
	public void clickOnCheckBox(By locator) {
		logger.info("Finding elements with locator " + locator);
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now performing click");
		element.click();
	}

	public void clickOn(WebElement element) {
		logger.info("Element found and now performing click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding elements with locator " + locator);
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now enter text " + textToEnter);
		element.sendKeys(textToEnter);
	}

	public void clearText(By textBoxlocator) {
		logger.info("Finding elements with locator " + textBoxlocator);
//		WebElement element = driver.get().findElement(textBoxlocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxlocator));
		logger.info("Element found and now clearing the text box field");
		element.clear();
	}

	public void selectFromDropdown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding elements with locator " + dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		logger.info("Selecting the Option " + optionToSelect);
		select.selectByVisibleText(optionToSelect);
	}

	public void selectFromDropdown(By dropDownLocator, By optionToSelect) {
		logger.info("Finding elements with locator " + dropDownLocator);
		driver.get().findElement(dropDownLocator).click();
		logger.info("Selecting the Option " + optionToSelect);
		driver.get().findElement(optionToSelect).click();
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {
		logger.info("Finding elements with locator " + locator);
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element found and now enter special key " + keyToEnter);
		element.sendKeys(keyToEnter);
	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding All elements with locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Element found and now printing the list of elements");
		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList;
	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding All elements with locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Element found and now printing the list of elements");
		return elementList;
	}

	public String getVisibleText(WebElement element) {
		logger.info("Returning the visible text " + element.getText());
		return element.getText();
	}

	public String getVisibleText(By locator) {
		logger.info("Finding elements with locator " + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now returning the value " + element.getText());
		return element.getText();
	}

	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		screenshotFile.getParentFile().mkdirs();
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
}
