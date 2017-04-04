package wrappers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericWrappers implements Wrappers {

	Logger APPLICATION_LOGS=Logger.getLogger("test");
	
/*	public GenericWrappers(RemoteWebDriver driver) {
		this.driver = driver;
	}
*/
	public WebDriverWait wait;
	public RemoteWebDriver driver;
	protected static Properties prop;
	public String sUrl,primaryWindowHandle,sHubUrl,sHubPort;

	/*public GenericWrappers() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/config.properties")));
			sHubUrl = prop.getProperty("HUB");
			sHubPort = prop.getProperty("PORT");
			sUrl = prop.getProperty("URL");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadObjects() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("./src/main/resources/object.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void unloadObjects() {
		prop = null;
	}*/

	/**
	 * This method will launch the browser in local machine and maximise the browser and set the
	 * wait for 30 seconds and load the url
	 * @author Babu - TestLeaf
	 * @param url - The url with http or https
	 * 
	 */
	public void invokeApp(String browser) {
		invokeApp(browser,false);
	}


	public void invokeApp(String browser,String url, boolean bremote)
	{
		try {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);

			if(bremote)
			{
				driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
			}

			else
			{
				if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver();
				}
				else{
					System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver();
					Thread.sleep(2000);
					driver.manage().deleteAllCookies();
				}
			}
			//			Process p=Runtime.getRuntime().exec("cmd /c start TempClean.bat",null, new File("./Temp/TempClean.bat"));
			new WebDriverWait(driver, 30);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			driver.get(url);
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			primaryWindowHandle = driver.getWindowHandle();		
			APPLICATION_LOGS.debug("The browser:" + browser + " launched successfully");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The browser:" + browser + " could not be launched");
		}

	}


	/**
	 * This method will launch the browser in grid node (if remote) and maximise the browser and set the
	 * wait for 30 seconds and load the url 
	 * @author Babu - TestLeaf
	 * @param url - The url with http or https
	 * 
	 */
	public void invokeApp(String browser, boolean bRemote) {
		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);

			// this is for grid run
			if(bRemote)
				driver = new RemoteWebDriver(new URL("http://"+sHubUrl+":"+sHubPort+"/wd/hub"), dc);
			else{ // this is for local run
				if(browser.equalsIgnoreCase("chrome")){
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
					driver = new ChromeDriver();
				}else{
					System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
					driver = new FirefoxDriver();
				}
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(sUrl);

			primaryWindowHandle = driver.getWindowHandle();		
			APPLICATION_LOGS.debug("The browser:" + browser + " launched successfully");

		} catch (Exception e) {
			e.printStackTrace();
			APPLICATION_LOGS.debug("The browser:" + browser + " could not be launched");
		}
	}

	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public void enterById(String idValue, String data) {
		try {
			driver.findElement(By.id(idValue)).clear();
			driver.findElement(By.id(idValue)).sendKeys(data);	
			APPLICATION_LOGS.debug("The data: "+data+" entered successfully in field :"+idValue);
		} catch (NoSuchElementException e) {
			APPLICATION_LOGS.debug("The data: "+data+" could not be entered in the field :"+idValue);
		} catch (Exception e) {
			APPLICATION_LOGS.debug("Unknown exception occured while entering "+data+" in the field :"+idValue);
		}
	}

	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * 
	 * @param nameValue - name of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public void enterByName(String nameValue, String data) {
		try {
			driver.findElement(By.name(nameValue)).clear();
			driver.findElement(By.name(nameValue)).sendKeys(data);	
			APPLICATION_LOGS.debug("The data: "+data+" entered successfully in field :"+nameValue);

		} catch (NoSuchElementException e) {
			APPLICATION_LOGS.debug("The data: "+data+" could not be entered in the field :"+nameValue);
		} catch (Exception e) {
			APPLICATION_LOGS.debug("Unknown exception occured while entering "+data+" in the field :"+nameValue);
		}

	}

	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * 
	 * @param xpathValue - xpathValue of the webelement
	 * @param data - The data to be sent to the webelement
	 * @author Babu - TestLeaf
	 * @throws IOException 
	 * @throws COSVisitorException 
	 */
	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElement(By.xpath(xpathValue)).clear();
			driver.findElement(By.xpath(xpathValue)).sendKeys(data);	
			APPLICATION_LOGS.debug("The data: "+data+" entered successfully in field :"+xpathValue);

		} catch (NoSuchElementException e) {
			APPLICATION_LOGS.debug("The data: "+data+" could not be entered in the field :"+xpathValue);
		} catch (Exception e) {
			APPLICATION_LOGS.debug("Unknown exception occured while entering "+data+" in the field :"+xpathValue);
		}

	}

	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 * @author Babu - TestLeaf
	 */
	public boolean verifyTitle(String title){
		boolean bReturn = false;
		try{
			if (driver.getTitle().equalsIgnoreCase(title)){
				APPLICATION_LOGS.debug("The title of the page matches with the value :"+title);
				bReturn = true;
			}else
				APPLICATION_LOGS.debug("The title of the page:"+driver.getTitle()+" did not match with the value :"+title);

		}catch (Exception e) {
			APPLICATION_LOGS.debug("Unknown exception occured while verifying the title");
		}
		return bReturn;
	}


	//Added new method
	public boolean verifyURL(String url){
		boolean bReturn = false;
		try{
			if (driver.getCurrentUrl().contains(url)){
				APPLICATION_LOGS.debug("The URL of the page matches with the value :"+url);
				bReturn = true;
			}else
				APPLICATION_LOGS.debug("The URL of the page:"+driver.getCurrentUrl()+" did not match with the value :"+url);

		}catch (Exception e) {
			APPLICATION_LOGS.debug("Unknown exception occured while verifying the URL");
		}
		return bReturn;
	}

	/**
	 * This method will verify the given text matches in the element text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public void verifyTextByXpath(String xpath, String text){
		try {
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.equalsIgnoreCase(text)){
				APPLICATION_LOGS.debug("The text: "+sText+" matches with the value :"+text);
			}else{
				APPLICATION_LOGS.debug("The text: "+sText+" did not match with the value :"+text);
			}
		}catch (Exception e) {
			APPLICATION_LOGS.debug("Unknown exception occured while verifying the title");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * @param xpath - The locator of the object in xpath
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public void verifyTextContainsByXpath(String xpath, String text){
		try{
			String sText = driver.findElementByXPath(xpath).getText();
			if (sText.contains(text)){
				APPLICATION_LOGS.debug("The text: "+sText+" contains the value :"+text);
			}else{
				APPLICATION_LOGS.debug("The text: "+sText+" did not contain the value :"+text);
			}
		}catch (Exception e) {
			APPLICATION_LOGS.debug("Unknown exception occured while verifying the title");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * @param id - The locator of the object in id
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public void verifyTextById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.equalsIgnoreCase(text)){
				APPLICATION_LOGS.debug("The text: "+sText+" matches with the value :"+text);
			}else{
				APPLICATION_LOGS.debug("The text: "+sText+" did not match with the value :"+text);
			}
		}catch (Exception e) {
			APPLICATION_LOGS.debug("Unknown exception occured while verifying the title");
		}
	}

	/**
	 * This method will verify the given text is available in the element text
	 * @param id - The locator of the object in id
	 * @param text  - The text to be verified
	 * @author Babu - TestLeaf
	 */
	public void verifyTextContainsById(String id, String text) {
		try{
			String sText = driver.findElementById(id).getText();
			if (sText.contains(text)){
				APPLICATION_LOGS.debug("The text: "+sText+" contains the value :"+text);
			}else{
				APPLICATION_LOGS.debug("The text: "+sText+" did not contain the value :"+text);
			}
		}catch (Exception e) {
			APPLICATION_LOGS.debug("Unknown exception occured while verifying the title");
		}
	}

	/**
	 * This method will close all the browsers
	 * @author Babu - TestLeaf
	 */
	public void quitBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The browser:"+driver.getCapabilities().getBrowserName()+" could not be closed.");
		}

	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public void clickById(String id) {
		try{

			driver.findElement(By.id(id)).click();
			APPLICATION_LOGS.debug("The element with id: "+id+" is clicked.");

		} catch (Exception e) {
			APPLICATION_LOGS.debug("The element with id: "+id+" could not be clicked."+e+"");
		}
	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public void clickByClassName(String classVal) {
		try{
			driver.findElement(By.className(classVal)).click();
			APPLICATION_LOGS.debug("The element with class Name: "+classVal+" is clicked.");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The element with class Name: "+classVal+" could not be clicked.");
		}
	}
	/**
	 * This method will click the element using name as locator
	 * @param name  The name (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public void clickByName(String name) {
		try{
			driver.findElement(By.name(name)).click();
			APPLICATION_LOGS.debug("The element with name: "+name+" is clicked.");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The element with name: "+name+" could not be clicked.");
		}
	}

	/**
	 * This method will click the element using link name as locator
	 * @param name  The link name (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public void clickByLink(String name) {
		try{
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(name))));
			driver.findElement(By.linkText(name)).click();
			APPLICATION_LOGS.debug("The element with link name: "+name+" is clicked.");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The element with link name: "+name+" could not be clicked.");
		}
	}

	public void clickByLinkNoSnap(String name) {
		try{
			driver.findElement(By.linkText(name)).click();
			//APPLICATION_LOGS.debug("The element with link name: "+name+" is clicked.", "PASS");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The element with link: "+name+" could not be clicked.");
		}
	}

	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 * @author Babu - TestLeaf
	 */
	public void clickByXpath(String xpathVal) {
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			APPLICATION_LOGS.debug("The element : "+xpathVal+" is clicked.");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The element with xpath: "+xpathVal+" could not be clicked.");
		}
	}

	public void clickByXpathNoSnap(String xpathVal) {
		try{
			driver.findElement(By.xpath(xpathVal)).click();
			//APPLICATION_LOGS.debug("The element : "+xpathVal+" is clicked.", "PASS");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The element with xpath: "+xpathVal+" could not be clicked.");
		}
	}

	/**
	 * This method will mouse over on the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public void mouseOverByXpath(String xpathVal) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.xpath(xpathVal))).build().perform();
			APPLICATION_LOGS.debug("The mouse over by xpath : "+xpathVal+" is performed.");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The mouse over by xpath : "+xpathVal+" could not be performed.");
		}
	}

	/**
	 * This method will mouse over on the element using link name as locator
	 * @param xpathVal  The link name (locator) of the element to be moused over
	 * @author Babu - TestLeaf
	 */
	public void mouseOverByLinkText(String linkName) {
		try{
			new Actions(driver).moveToElement(driver.findElement(By.linkText(linkName))).build().perform();
			APPLICATION_LOGS.debug("The mouse over by link : "+linkName+" is performed.");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The mouse over by link : "+linkName+" could not be performed.");
		}
	}

	/**
	 * This method will return the text of the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element
	 * @author Babu - TestLeaf
	 */
	public String getTextByXpath(String xpathVal){
		String bReturn = "";
		try{
			return driver.findElement(By.xpath(xpathVal)).getText();
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The element with xpath: "+xpathVal+" could not be found.");
		}
		return bReturn; 
	}

	/**
	 * This method will return the text of the element using id as locator
	 * @param xpathVal  The id (locator) of the element
	 * @author Babu - TestLeaf
	 */
	public String getTextById(String idVal) {
		String bReturn = "";
		try{
			return driver.findElementById(idVal).getText();
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The element with id: "+idVal+" could not be found.");
		}
		return bReturn; 
	}


	/**
	 * This method will select the drop down value using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (visibletext) from the dropdown 
	 * @author Babu - TestLeaf
	 */
	public void selectVisibileTextById(String id, String value) {
		try{
			new Select(driver.findElement(By.id(id))).selectByVisibleText(value);;
			APPLICATION_LOGS.debug("The element with id: "+id+" is selected with value :"+value);
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The value: "+value+" could not be selected.");
		}
	}



	public void selectVisibileTextByXPath(String xpath, String value) {
		try{
			new Select(driver.findElement(By.xpath(xpath))).selectByVisibleText(value);;
			APPLICATION_LOGS.debug("The element with xpath: "+xpath+" is selected with value :"+value);
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The value: "+value+" could not be selected.");
		}
	}

	public void selectIndexById(String id, String value) {
		try{
			new Select(driver.findElement(By.id(id))).selectByIndex(Integer.parseInt(value));;
			APPLICATION_LOGS.debug("The element with id: "+id+" is selected with index :"+value);
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The index: "+value+" could not be selected.");
		}
	}

	public void switchToParentWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
				break;
			}
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The window could not be switched to the first window.");
		}
	}

	public void switchToLastWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The window could not be switched to the last window.");
		}
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			APPLICATION_LOGS.debug("The alert could not be found.");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The alert could not be accepted.");
		}

	}


	public String getAlertText() {		
		String text = null;
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			APPLICATION_LOGS.debug("The alert could not be found.");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The alert could not be accepted.");
		}
		return text;

	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			APPLICATION_LOGS.debug("The alert could not be found.");
		} catch (Exception e) {
			APPLICATION_LOGS.debug("The alert could not be accepted.");
		}

	}

	public long takeSnap(){
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L; 
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE) , new File("./reports/images/"+number+".jpg"));
		} catch (WebDriverException e) {
			APPLICATION_LOGS.debug("The browser has been closed.");
		} catch (IOException e) {
			APPLICATION_LOGS.debug("The snapshot could not be taken");
		}
		return number;
	}


	public String getTextByClass(String classVal) throws Exception {
		// TODO Auto-generated method stub
		String text="";
		try {
			text=driver.findElementByClassName(classVal).getText();

		} catch (NoSuchElementException e) {
			System.out.println("The element :"+classVal+" not found");
			throw new Exception("Element not found");
		} catch (WebDriverException e) {
			System.out.println("The browser closed");
			throw new Exception("Browser not found");
		} finally{
			takeSnap();
		}
		return text;
	}





}

