package com.roadreadywheels.comman;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import org.w3c.dom.Document;

 
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.roadreadywheels.driver.WebDriverProvider;
import com.roadreadywheels.utils.PropertyReader;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
public class JavaCore
   {
	public static boolean validate;
	 
	protected static String stringUrl[];
	public static Properties object = new Properties();	
	static int timeout=70;
	String StrpathConfig = System.getProperty("user.dir") + "//src//config//config.properties";
	String StrpathExternalAPI = System.getProperty("user.dir")+"//src//config//ORExternalApi.properties";
	public File fExp = new File(StrpathExternalAPI);
	String StrpathORCommon = System.getProperty("user.dir")+"//src//config//OR.properties";
	public File fC = new File(StrpathORCommon);
	public File f = new File(StrpathConfig);
 	static String StrPathexl = System.getProperty("user.dir") + "//src//testdata//TestData_Excel.xlsx";
 	
	public static WebDriver driver;
	public static boolean acceptNextAlert = true;
	 
	public static final String logout="//*[@id='lnklogout']";
	 
	protected static DesiredCapabilities capabilities;
 	
	public static String url,afterloginurl,BROWSER,Email,Pass,t_pass,t_email,CassandraIp,CassandraUserId,CassandraPassword,emailForSearch=null;
	
 
	public static void setUp() {

		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		   driver.manage().deleteAllCookies();	 
	}
    
	
	public  static void openUrl(String url)
	{
	    driver=WebDriverProvider.getWebDriver();
	     setUp();
	    driver.get(url);
	}
	 
//	public void initSoftAssert() {
//		softAssert = new SoftAssert();
//	}
//	 
//
// 	public void evaluateSoftAssert() {
//		softAssert.assertAll();
//	}
	 

 
	
	 
	 public static  WebElement FindWebElementByTag(String exData) {
	        WebElement webElement =driver.findElement(By.tagName(exData));
	        return webElement;
	    }
	
	// Return web driver object
		public static WebDriver getWebDriver() 
		{
			return driver;
		}

		

		/* Function for Verifying Fields-By Text */
		public static void Assertion_FieldByTxt(String BTN_Path, String BTN_Name, String error_message) 
		{

			WebElement BTNPath = JavaCore.driver.findElement(By.xpath(BTN_Path));
			String TriggerName = BTNPath.getText();
			//Assert.assertEquals(TriggerName, BTN_Name, error_message);
		}
		
	
	public static String getSystemTime()
	{
	     DateFormat dateFormat = new SimpleDateFormat("yyyyddMMHHmmssSSS");
		 Date date = new Date();
	 	 String currentdate=dateFormat.format(date);
	 	 String news=currentdate.substring(currentdate.lastIndexOf(" ")+1);
	     return news.substring(10,15);
	}
	 
	
	 
	// Handle send keys action
		public static void sendKeys(String locator, String text) 
		{
			try
			{
			WaitForElementPresent(locator, timeout);
			WebElement el = driver.findElement(ByLocator(locator));
			el.sendKeys(text);
			}
			catch (Exception e) {
			e.printStackTrace();
			}
			}
		 
		// Handle send keys action
			public static void sendKeysByIndex(String locator, String text,int index) 
			{
				try
				{
				WaitForElementPresent(locator, timeout);
				WebElement el=driver.findElements(ByLocator(locator)).get(index);
				el.sendKeys(text);
				}
				catch (Exception e) {
				e.printStackTrace();
				}
				}
				
		
		public static void sendKeysWhenCanNotFocus(String locator, String text) 
		{
			try
			{
			WaitForElementPresent(locator, timeout);
			Actions actions = new Actions(driver);
			WebElement el = JavaCore.driver.findElement(JavaCore.ByLocator(locator));
			actions.moveToElement(el);
			actions.click();
			actions.sendKeys(text);
			 actions.build().perform();
		 		}
			catch (Exception e) {
			e.printStackTrace();
			}
			}
		
		
		
	 /*
		public static void sendKeysWhenElementNotVisible(String locator, String text)
		{
		 WebElement el=new WebDriverWait(driver,1000).until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
		 el.sendKeys(text);
		
	//	int ok_size=driver.findElements(ByLocator(locator)).size();
		//driver.findElements(ByLocator(locator)).get(ok_size-1).click();
		
		}*/
		
		
		
		
		
		
		public static void ClickByXpath(String id) {
	        driver.findElement(By.xpath(id)).click();
	    }
		
		
		public static boolean retryingFindClick(String locator) {
		    boolean result = false;
		    int attempts = 0;
		    while(attempts < 2) {
		        try {
		            driver.findElement(ByLocator(locator)).click();
		            result = true;
		            break;
		        } 
		        catch(StaleElementReferenceException e) 
		        {
		        }
		        attempts++;
		    }
		    return result;
		}
	
	public static String readLoginUrl()
	{
		String url=PropertyReader.getConfigProperty("config.properties");
        return url;
	}
	
	// Handle Tab

		public static void tabhandle() {

			Set<String> window = driver.getWindowHandles();
			Iterator<String> it = window.iterator();
			String mainpage = it.next();
			String nextpage = it.next();
			driver.switchTo().window(nextpage);
		System.out.println(mainpage);
			System.out.println(driver.getTitle());
		}
	
	
	
	 
	
	public static Properties loadOR() {
		Properties prop = null;
		try {
			// Specify the file location I used . operation here because
			// we have object repository inside project directory only

			File src = new File(".//src//config//OR.properties");

			// Create FileInputStream object
			FileInputStream fis = new FileInputStream(src);

			// Create Properties class object to read properties file
			prop = new Properties();

			// Load file so we can use into our script
			prop.load(fis);
			// return File;

			System.out.println("Property class loaded");
		}

		catch (Exception e) {
			System.out.println("Getting exception in loading Object repositories file" + e);
		}

		return prop;
	}
//	public static void assertMandatoryField(WebElement element, String elementName, boolean isMandatory) {
//		String isRequiredVal = element.getAttribute("data-validate");
//		//SoftAssert softAssert = new SoftAssert();
//		if (isMandatory) {
//			softAssert.assertTrue("onBoardV".equals(isRequiredVal), elementName + " is mandatory!");
//		} else {
//			softAssert.assertTrue(!("onBoardV".equals(isRequiredVal)), elementName + " is non-mandatory!");
//		}
//		softAssert.assertAll();
//	}
	
	public static void doubleClick(String Xpath) {
		WebElement element = driver.findElement(ByLocator(Xpath));
		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().perform();
	}
	
	public static void AutoITUpload() throws InterruptedException, IOException {
	  Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\Uploads Files\\FIleU_Flatfile.exe");
		}


public static String closeAlertAndGetItsText() 
{

    try {
        new WebDriverWait(driver,Duration.ofSeconds(50)).ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
//      assertEquals(alertText,"Action completed successfully.");
//      Assert.assertEquals(alertText, "Action completed successfully.", "Text on Alert is not matched");
    System.out.println(alertText);
//    loadicon("ImgLOADING");
    return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
public static void loadicon(String loadingiconcontainer)
{
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(ByLocator(loadingiconcontainer)));          
}

public static  void waitforelement(String loadingiconname) {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loadingiconname))); 
	}
public static  void LoadingIcondissapear(String loadingiconname) {
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	 wait.until(ExpectedConditions.invisibilityOfElementLocated(ByLocator(loadingiconname)));	 
	}

	
public static String GetFieldValue(String locator) {
	int timeout=0;
	WaitForElementPresent(locator, timeout);
	//Scrollelement(locator);
	WebElement el = driver.findElement(ByLocator(locator));
	return el.getText();
}	


public static String GetFieldValueByLocatorAndAttribute(String locator, String attibutename) {
	 
	int timeout=0;
	WaitForElementPresent(locator, timeout);
	//Scrollelement(locator);
	WebElement el = driver.findElement(ByLocator(locator));	 
	return el.getAttribute(attibutename);
}	
	 

	
public static List<WebElement>  GetAllValuesOfDroupDown(String locator) {
	int timeout=10;
	WaitForElementPresent(locator, timeout);
	WebElement drop_down =driver.findElement(ByLocator(locator));
	Select se = new Select(drop_down);
	List<WebElement> options = se.getOptions();
	return options;
}

	


public static List<WebElement>  getAllElementsList(String locator) {
	int timeout=500;
	WaitForElementPresent(locator, timeout);
	Scrollelement(locator);
	List<WebElement> options=driver.findElements(ByLocator(locator));
	   	return options;
}	


	
	public static void Clear(String locator) {
		WaitForElementPresent(locator, timeout);
		 
		WebElement el = driver.findElement(ByLocator(locator));
		el.clear();
	}
	public static void ClearByIndex(String locator,int index) {
		WaitForElementPresent(locator, timeout);
		//Scrollelement(locator);
		//WebElement el = driver.findElement(ByLocator(locator));
		WebElement el=driver.findElements(ByLocator(locator)).get(index);
		el.clear();
	}
	
	public static String Fun_UniqueName(String StrPrefixName) {
		String strUQ;
		strUQ = Fun_DateTime1();
		StrPrefixName = StrPrefixName+strUQ;
		return StrPrefixName;
	}
	public static String Fun_RemoveSpace(String s) {
		String withoutspaces = "";
		char ch = 'a';
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (ch != 32)
				withoutspaces += s.charAt(i);
		}
		return withoutspaces;
	}

	
	public static WebElement WaitForElementPresent(String locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(ByLocator(locator)));
		return element;
	}
	
	
    	// Handle click action
	 		public static void clickOn(String locator) {
	 			try
	 			{
	 			WaitForElementPresent(locator,timeout);
	 //			WebDriverWait wait = new WebDriverWait(driver, timeout);
	 			WebElement el = driver.findElement(ByLocator(locator));
	 			waitForElementToBeClickable(driver,el);
	 			el.click();
	 			}
	 			catch (Exception e) {
					e.printStackTrace();
				}
	 		}
	 		public static void clickByJS(String locator)
	 		{

	 			WebElement el = driver.findElement(ByLocator(locator));
	 		JavascriptExecutor executor = (JavascriptExecutor)driver;
	 		executor.executeScript("arguments[0].click();", el);

	 		}
	 		
	 	// Handle click action
	 		public static void clickOnByIndex(String locator,int index) {
	 			try
	 			{
	 			WaitForElementPresent(locator,timeout);
	 //			WebDriverWait wait = new WebDriverWait(driver, timeout);
	 			WebElement el=driver.findElements(ByLocator(locator)).get(index);
	 			
	 			//WebElement el = driver.findElements(ByLocator(locator));
	 			waitForElementToBeClickable(driver,el);
	 			el.click();
	 			}
	 			catch (Exception e) {
					e.printStackTrace();
				}
	 		}
	 		

	    	// Handle click action
		 		public static void clickOnWaitTime(String locator,int timeout) {
		 			try
		 			{
		 			WaitForElementPresent(locator,timeout);
		  			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		 			WebElement el = driver.findElement(ByLocator(locator));
		 			waitForElementToBeClickable(driver,el);
		 			el.click();
		 			}
		 			catch (Exception e) {
						e.printStackTrace();
					}
		 		}
	 		
	 		
	 	// Handle click action
	 		public static void clickByIndex(String locator,int position) 
	 		{
	 			try
	 			{
	 			WaitForElementPresent(locator,timeout);
	 //			WebDriverWait wait = new WebDriverWait(driver, timeout);	
	 			List<WebElement> el = driver.findElements(ByLocator(locator));
	 			waitForElementToBeClickableListType(driver,el);
	 			el.get(position).click();
	 			}
	 			catch (Exception e) 
	 			{
					e.printStackTrace();
				}
	 		}
	 		
	 		public static void scrollByXPath(String xpath)
	 		{
				JavascriptExecutor je = (JavascriptExecutor)driver;
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath(xpath));
				// now execute query which actually will scroll until that element is not appeared on page.
				je.executeScript("arguments[0].scrollIntoView(true);",element);
				// Extract the text and verify
				System.out.println(element.getText());
	 		}
	 		
	 		public static void scrollByXPathWithIndexPos(String xpath,int pos)
	 		{
				JavascriptExecutor je = (JavascriptExecutor)driver;
		
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElements(By.xpath(xpath)).get(pos);
				// now execute query which actually will scroll until that element is not appeared on page.
				je.executeScript("arguments[0].scrollIntoView(true);",element);
				// Extract the text and verify
				System.out.println(element.getText());
	 		}
	 		public static void scrollLetToRight()
	 		{
				JavascriptExecutor je = (JavascriptExecutor)driver;
				//Identify the WebElement which will appear after scrolling down
				//WebElement element = driver.findElement(By.xpath(xpath));
				// now execute query which actually will scroll until that element is not appeared on page.				
				je.executeScript("window.scrollBy(1000,0)");

				// Extract the text and verify
				//System.out.println(element.getText());
	 		}
	 		 
	 		
	 		
	 		public static void clickOn1(String locator) {
	 			//WaitForElementPresent(locator, timeout);
	 			//WaitForElementVisible(locator, timeout);
	 			WebElement el = driver.findElement(By.linkText(locator));
	 			el.click();
	 		}
	 		
	 		public static void clicksave() {
	 			
	 		 WebElement element1 = driver.findElement(By.xpath(".//*[@id='submitone']"));
	     	Actions action1 = new Actions(driver);
	     	action1.moveToElement(element1).click().perform();
	 		}
	 		
	 		
	 		
	 		public static void ClickSaveData() {
	 			
		 		 WebElement element2 = driver.findElement(By.xpath(".//*[@id='btnsave']"));
		     	Actions action2 = new Actions(driver);
		     	action2.moveToElement(element2).click().perform();
		 		}
	 		
	 		
	 		public static void ClickSaveandSend() {
	 			
		 		 WebElement ele = driver.findElement(By.xpath("//*[@id='winsumsaveandsend']"));
		     	Actions act = new Actions(driver);
		     	act.moveToElement(ele).click().perform();
		 		}
	 		
	 		
	 		public static void ClickPopUP_ok() throws InterruptedException {
	 			Thread.sleep(2000);
	 		//int size=driver.findElements(By.xpath("//*[@id='btnOk']")).size();
	 		int size=driver.findElements(By.xpath("//*[@id='btnNtfOptOk']")).size();
	 		 driver.findElements(By.xpath("//*[@id='btnNtfOptOk']")).get(size-1).click();
	 		}
	 		
	 		
	 		
	 		public static void mouseclick(String locator) {
				JavaCore.WaitForElementVisible(locator, timeout);
				WebElement el = driver.findElement(ByLocator(locator));
				Actions builder = new Actions(driver);
				builder.moveToElement(el).click().perform();
			}
	 		
	 		public static void dragNDrop(String Xpath) 
	           {
			@SuppressWarnings("unused")
			WebElement element = driver.findElement(ByLocator(Xpath));
			Actions action = new Actions(driver);
	                WebElement sourcelocator = driver.findElement(ByLocator(Xpath));
	                WebElement DestinationLocator = driver.findElement(ByLocator(Xpath));
	                action.dragAndDrop(sourcelocator,DestinationLocator).build().perform(); 

	           }        		
	 		public static WebElement WaitForElementVisible(String locator, int timeout) {

				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(locator)));
				return element;
			}
	 		
	 		public static WebElement WaitForElemePresent(String locator, int timeout) {

				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
				WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(ByLocator(locator)));
				return element;
			}

	 		
	 		public  static  boolean isTextPresent(String text){
	 	        try{
	 	            boolean b = driver.getPageSource().contains(text);
	 	            return b;
	 	        }
	 	        catch(Exception e){
	 	            return false;
	 	        }
	 	  }	
	 		
	 		
	 		public static String getCurrenturl(){
				return driver.getCurrentUrl();
				
				
			}
	 		public static String ChangeCurrenturl_TestRecord(){
	 			String CURL = driver.getCurrentUrl();
	 			driver.get(CURL+"&tstrcd=1");
				return CURL;
			}
	 		
	 		
	 		
	 		public static void selectDropDownByIndex(String locator, int index) {
//				Assert.assertTrue(isElementPresent(locator), "Element Locator :"
//						+ locator + " Not found");
				WebElement waitForElementPresent = JavaCore.WaitForElementPresent(locator, 60);
				new Select(waitForElementPresent)
				.selectByIndex(index);

			}

	 		public static void selectDropDownByIndexAndClickPosition(String locator, int index,int pos) {
//				Assert.assertTrue(isElementPresent(locator), "Element Locator :"
//						+ locator + " Not found");
//				JavaCore.WaitForElementPresent(locator, 60);
				new Select(driver.findElements(ByLocator(locator)).get(pos))
				.selectByIndex(index);

			}
	 		
	 		
	 		public static void selectDropDownByIndexWebElement(WebElement webElement, int index) {
				new Select(webElement)
				.selectByIndex(index);

			}
	 		
	 		public static void selectDropDownByvalue(String locator, String value) {
//				Assert.assertTrue(isElementPresent(locator), "Element Locator :"
//						+ locator + " Not found");
				JavaCore.WaitForElementPresent(locator, 60);
				new Select(driver.findElement(ByLocator(locator)))
				.selectByValue(value);

			}
	 			
	 		public static String Fun_DateTime1() {
	 	        {
	 	        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
	 	        Date date = new Date();
	 	        String Str_Date = dateFormat.format(date);
	 	         return Str_Date;
	 	        }
	 		}
	  		
	 		
	 		public static String getValueByXPath(String xpath)
	 		{
	 			//driver.switchTo().alert().accept();
	 			String strMessageLang="";
	 			try
	 			{
	 				//*[@id="sfMessage"]
	 			  WebElement webElement =driver.findElement(By.xpath(xpath));
	 	           strMessageLang = webElement.getText();
	 			}
	 			catch(Exception ex)
	 			{
	 				System.out.println("Error");
	 				ex.printStackTrace();
	 			}
			   return strMessageLang;
	 			
	 		}
	 		
	 		public static String getValueByWebElement(WebElement webElement)
	 		{
	 			//driver.switchTo().alert().accept();
	 			String strMessageLang="";
	 			try
	 			{
	 				//*[@id="sfMessage"]
	 			  //WebElement webElement =driver.findElement(By.xpath(xpath));
	 	           strMessageLang = webElement.getText();
	 			}
	 			catch(Exception ex)
	 			{
	 				System.out.println(ex);
	 				ex.printStackTrace();
	 			}
			   return strMessageLang;
	 			
	 		}
	 		
	 		public static String getReadOnlyFieldValue(String xpath)
	 		{
	 			
	 			WebElement input = driver.findElement(By.xpath(xpath));
	 			String value=input.getAttribute("value");
				return value;
	 			
	 		}
	 		
	 		
	 		
	 		
	 		
	 		public static String getAttributeByXpath(String xpath,String attributeName)
	 		{
	 			 String value=null;
	 			try
	 			{
	 				WebElement el = driver.findElement(ByLocator(xpath));
	 				value=el.getAttribute(attributeName);
	 			}
	 			catch(Exception e)
	 			{
	 				e.printStackTrace();
	 			}
				return value;
	 		}
	 		
	 		
	 		public static String getalertValue() {
	 			String text=null;
	 			/*WebDriverWait wait = new WebDriverWait(driver,0);
	 			
	 			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	 			driver.switchTo().alert().accept();
	 			String s = alert.getText();
	 			System.out.println(s);*/
	 			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
                if(wait.until(ExpectedConditions.alertIsPresent())==null){
                      System.out.println("alert was not present");
                }
                else
                {
                 Alert alert = driver.switchTo().alert();
                alert.accept();
                text=alert.getText();
                
                System.out.println("alert was present and accepted");
                }
	 			
	 			return text;
	 		}
	 		
	 		public static void selectSE(){
	 			WebElement element = driver.findElement(By.xpath("//*[@id='MyTr_pim2mleadsaseassigned']/span[4]/div/button"));
	 			Actions action = new Actions(driver);
	 			action.moveToElement(element).click().perform();
	 		      driver.findElement(By.linkText("Plasma SuperUser (plasmasuperuser)")).click();
	 		}
	 		
	 		
	 		
	 		public static  void uploadDataByAutoIt(String locator,String path)
	 		{
	 			
	 			 try {
	 				 Thread.sleep(3000);
	 				 JavaCore.clickOn(locator);
	 				Runtime.getRuntime().exec(path);
	 			} catch (Exception e1) {
	 				// TODO Auto-generated catch block
	 				e1.printStackTrace();
	 			}
	 		}
	 		
	 		public static void checkradio(String strxpath){
	 			
	 			WebElement ele=JavaCore.driver.findElement(By.xpath(strxpath));
	 			ele.click();
	 			
	 		}
	 		
	 		public static void Close_CurrentTab(){
	 			driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"w");
	 			 		}
	 		
	 		public static Boolean isElementPresent(String locator) {
				Boolean result = false;
				try {
					driver.findElement(ByLocator(locator));
					result = true;
				} catch (Exception ex) {
				}
				return result;
			}
	 		
	 		public static  String randomString() throws InterruptedException {
				Random random = new Random(System.nanoTime() % 100000);

				  int randomInt = random.nextInt(1000000000);
					
				 return String.valueOf(randomInt);		
				    
			}	
	 		
	 		
	 		public static int createRandomNumber()
	 		{
	 			Random rand = new Random();
	 			int n = rand.nextInt(50) + 1;
	 			return n;
	 		}
	 		
	 		public static String Fun_DateTimeValue(String Str_Date) throws ParseException, java.text.ParseException {
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();
				String Str_Date1 = dateFormat.format(date);
				
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				Calendar c = Calendar.getInstance();
				c.setTime(sdf.parse(Str_Date1));
				c.add(Calendar.DATE, 4);  // number of days to add
				Str_Date1 = sdf.format(c.getTime());  
				return Str_Date1;
			}
	
	 		
	 		
	 		
	 		public static String getCurrentDay (){

	 		    //Create a Calendar Object
	 		    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

	 		    //Get Current Day as a number
	 		    int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
	 		   // System.out.println("Today Int: " + todayInt +"\n");

	 		    //Integer to String Conversion
	 		    String todayStr = Integer.toString(todayInt);
	 		    //System.out.println("Today Str: " + todayStr + "\n");

	 		    return todayStr;
	 		}

	 		
	 		
	 		public static String Fun_CurrentDate(String str_Date) throws ParseException, java.text.ParseException {
	 			DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
	 			Date date1 = new Date();
	 			String str_Date2 = dateFormat1.format(date1);
	 			
	 			SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
	 			Calendar c = Calendar.getInstance();
	 			c.setTime(sdf1.parse(str_Date2));
	 			c.add(Calendar.DATE, 2);  // number of days to add
	 			str_Date2 = sdf1.format(c.getTime());  
	 			return str_Date2;
	 					}
	 		
	 		
	 		
	 		public static void DynamicWait(String StrXpath) {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(StrXpath)));
			}
	
	 		
	 		public static void Scrollelement(String string)
	 		{
	 		 WebElement StoreApph = driver.findElement(By.xpath(string));
	 		 JavascriptExecutor je = (JavascriptExecutor)driver;
	 		 je.executeScript("arguments[0].scrollIntoView(true);",StoreApph);
	 		 //System.out.println("Scroll executed");
	 		// System.out.println(StoreApph.getText());
	 		}	
	 		public static String  createRandomUrl(String urlName)
	 	   {
	 	        String alphabet= "abcdefghijklmnopqrstuvwxyz";
	 	        String s = "";
	 	        Random random = new Random();
	 	        int randomLen = 1+random.nextInt(9);
	 	        for (int i = 0; i < randomLen; i++) {
	 	            char c = alphabet.charAt(random.nextInt(26));
	 	            s+=c;
	 	        }

	 	        return "https://www."+urlName+s+".com";
	 	    }
	 		public static String createRandomDomainName(String DomainName)
	 	   {
	 	        String alphabet= "abcdefghijklmnopqrstuvwxyz";
	 	        String s = "";
	 	        Random random = new Random();
	 	        int randomLen = 1+random.nextInt(9);
	 	        for (int i = 0; i < randomLen; i++) {
	 	            char c = alphabet.charAt(random.nextInt(26));
	 	            s+=c;
	 	        }

	 	        return DomainName+s;
	 	    }
	 		
	 		public static void Scrollelement1(String string)
	 		{
	 		 WebElement StoreApph = driver.findElement(By.linkText(string));
	 		 JavascriptExecutor je = (JavascriptExecutor)driver;
	 		 je.executeScript("arguments[0].scrollIntoView(true);",StoreApph);
	 		 //System.out.println("Scroll executed");
	 		// System.out.println(StoreApph.getText());
	 		}	
	 		
	 		
	
	
	// Handle locator type
	 		public static By ByLocator(String locator)
            {
                By result = null;
                if (locator.startsWith(".//")) {
                    result = By.xpath(locator);
                }
                else if (locator.startsWith("//")) {
                    result = By.xpath(locator);
                } else if (locator.startsWith("css=")) {
                    result = By.cssSelector(locator.replace("css=", ""));
                } else if (locator.startsWith("name=")) {
                    result = By.name(locator.replace("name=", ""));
                } else if (locator.startsWith("link=")) {
                    result = By.linkText(locator.replace("link=", ""));
                } else if (locator.startsWith("id="))  {
                    result = By.id(locator.replace("id=", ""));
                }
                else {
                    result = By.id(locator);
                }
                return result;
            }


			
			public static String Fun_DateTime() {
			    DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy :: 'Date' - dd MMM yyyy :: 'Time' : hh_mm_ss a zzz");
			    Date date = new Date();
			    String Str_Date = dateFormat.format(date);
			    return Str_Date;
			   }

			 	
			  public static String getCallData(final String urlGet) {
				  String data=null;
				try
				{
					/*String paramValue = urlGet;
					String yourURLStr = urlGet+java.net.URLEncoder.encode(paramValue, "UTF-8");
					java.net.URL url = new java.net.URL(yourURLStr);*/
				URL url=new URL(urlGet);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", "Mozilla/5.0");
				int responseCode = con.getResponseCode();
				System.out.println("reposne code :"+responseCode);
				if (responseCode == HttpURLConnection.HTTP_OK) { // success
					BufferedReader in = new BufferedReader(new InputStreamReader(
							con.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();

					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine.trim());
					}
					in.close();

					// print result
				//	xls.setCellData("API_Services", "Feed_API",7,response.toString());
					//System.out.println("data="+response.toString());
					data=response.toString();
				}
				}
				catch(Exception ex)
				{
				System.out.println(ex);
				}
				return data;
			 	
		}
			
			
			
			
			
			public static  String whenParsingXmlStringIntoJsonNode(InputSource xmlString) 
			{
				try
				{
				
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 				Document doc =dBuilder.parse(xmlString);
 			doc.getDocumentElement().normalize();
 
 				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
						
				NodeList nList = doc.getElementsByTagName("Table1");
						
				System.out.println("----------------------------");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
							
					System.out.println("\nCurrent Element :" + nNode.getNodeName());
							
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					
						Element eElement = (Element) nNode;

					//	System.out.println("Staff id : " + eElement.getAttribute("id"));
						System.out.println("c2mdatetime : " + eElement.getElementsByTagName("c2mdatetime").item(0).getTextContent());
						System.out.println("row_id : " + eElement.getElementsByTagName("row_id").item(0).getTextContent());
						System.out.println("order_id : " + eElement.getElementsByTagName("order_id").item(0).getTextContent());
						System.out.println("order_date : " + eElement.getElementsByTagName("order_date").item(0).getTextContent());
						return "success";
					}
					else
					{
						return "fail";
					}
				}
				
				}
				catch (Exception e) {
					e.printStackTrace();
				}
//				
//				XmlPath path=new XmlPath(xmlString);
//			     String name = path.with(xmlString).get("root.response.status");
//			     System.out.println("datasss="+name);
				
//				
//			      ObjectMapper mapper = new XmlMapper();
//			     
//			      String value=mapper.writeValueAsString(xmlString);
//			     
//			     System.out.println("VAAAAAA="+value);
//			     
			   //Object actualObj = mapper.readValue(new URL(xmlString), List.class);
			   //  System.out.println("JsonObject="+actualObj);
				// return actualObj;	    
					
			     
			     return "fail";  
			 }
			
			
			
			
			
			
			
			
			
			
			public static  String whenParsingXmlStringIntoJsonNodeC2MDateTime(InputSource xmlString) 
			{
				try
				{
				
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 				Document doc =dBuilder.parse(xmlString);
 			doc.getDocumentElement().normalize();
 
 				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
						
				NodeList nList = doc.getElementsByTagName("Table1");
						
				System.out.println("----------------------------");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
							
					System.out.println("\nCurrent Element :" + nNode.getNodeName());
							
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					
						Element eElement = (Element) nNode;

					//	System.out.println("Staff id : " + eElement.getAttribute("id"));
						System.out.println("c2mdatetime : " + eElement.getElementsByTagName("c2mdatetime").item(0).getTextContent());
//						System.out.println("row_id : " + eElement.getElementsByTagName("row_id").item(0).getTextContent());
//						System.out.println("order_id : " + eElement.getElementsByTagName("order_id").item(0).getTextContent());
//						System.out.println("order_date : " + eElement.getElementsByTagName("order_date").item(0).getTextContent());
						return "success";
					}
					else
					{
						return "fail";
					}
				}
				
				}
				catch (Exception e) {
					e.printStackTrace();
				}
//				
//				XmlPath path=new XmlPath(xmlString);
//			     String name = path.with(xmlString).get("root.response.status");
//			     System.out.println("datasss="+name);
				
//				
//			      ObjectMapper mapper = new XmlMapper();
//			     
//			      String value=mapper.writeValueAsString(xmlString);
//			     
//			     System.out.println("VAAAAAA="+value);
//			     
			   //Object actualObj = mapper.readValue(new URL(xmlString), List.class);
			   //  System.out.println("JsonObject="+actualObj);
				// return actualObj;	    
					
			     
			     return "fail";  
			 }
			
			public static  String whenParsingXmlStringIntoJsonNodeAQB(InputSource xmlString) 
			{
				try
				{
				
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 				Document doc =dBuilder.parse(xmlString);
 			doc.getDocumentElement().normalize();
 
 				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
						
				NodeList nList = doc.getElementsByTagName("Table1");
						
				System.out.println("----------------------------");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
							
					System.out.println("\nCurrent Element :" + nNode.getNodeName());
							
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					
						Element eElement = (Element) nNode;

					//	System.out.println("Staff id : " + eElement.getAttribute("id"));
						System.out.println("c2mdatetime : " + eElement.getElementsByTagName("c2mdatetime").item(0).getTextContent());
 					System.out.println("row_id : " + eElement.getElementsByTagName("order_id").item(0).getTextContent());
 						System.out.println("order_id : " + eElement.getElementsByTagName("order_priority").item(0).getTextContent());
 					System.out.println("order_date : " + eElement.getElementsByTagName("order_date").item(0).getTextContent());
 					System.out.println("order_date : " + eElement.getElementsByTagName("order_quantity").item(0).getTextContent());
 					
						return "success";
					}
					else
					{
						return "fail";
					}
				}
				
				}
				catch (Exception e) {
					e.printStackTrace();
				}
//				
//				XmlPath path=new XmlPath(xmlString);
//			     String name = path.with(xmlString).get("root.response.status");
//			     System.out.println("datasss="+name);
				
//				
//			      ObjectMapper mapper = new XmlMapper();
//			     
//			      String value=mapper.writeValueAsString(xmlString);
//			     
//			     System.out.println("VAAAAAA="+value);
//			     
			   //Object actualObj = mapper.readValue(new URL(xmlString), List.class);
			   //  System.out.println("JsonObject="+actualObj);
				// return actualObj;	    
					
			     
			     return "fail";  
			 }
			
			public static  String whenParsingXmlStringIntoJsonNodeAQBRefresh(InputSource xmlString) 
			{
				try
				{
				
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 				Document doc =dBuilder.parse(xmlString);
 			doc.getDocumentElement().normalize();
 
 				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
						
				NodeList nList = doc.getElementsByTagName("Table1");
						
				System.out.println("----------------------------");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
							
					System.out.println("\nCurrent Element :" + nNode.getNodeName());
							
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					
						Element eElement = (Element) nNode;

					//	System.out.println("Staff id : " + eElement.getAttribute("id"));
						System.out.println("c2mdatetime : " + eElement.getElementsByTagName("c2mdatetime").item(0).getTextContent());
 					System.out.println("row_id : " + eElement.getElementsByTagName("order_id").item(0).getTextContent());
 						System.out.println("order_id : " + eElement.getElementsByTagName("order_priority").item(0).getTextContent());
 					System.out.println("order_date : " + eElement.getElementsByTagName("order_date").item(0).getTextContent());
 					System.out.println("order_date : " + eElement.getElementsByTagName("order_quantity").item(0).getTextContent());
 					
						return "success";
					}
					else
					{
						return "fail";
					}
				}
				
				}
				catch (Exception e) {
					e.printStackTrace();
				}
//				
//				XmlPath path=new XmlPath(xmlString);
//			     String name = path.with(xmlString).get("root.response.status");
//			     System.out.println("datasss="+name);
				
//				
//			      ObjectMapper mapper = new XmlMapper();
//			     
//			      String value=mapper.writeValueAsString(xmlString);
//			     
//			     System.out.println("VAAAAAA="+value);
//			     
			   //Object actualObj = mapper.readValue(new URL(xmlString), List.class);
			   //  System.out.println("JsonObject="+actualObj);
				// return actualObj;	    
					
			     
			     return "fail";  
			 }
			
			

			public static  String parsePureDevice(InputSource xmlString) 
			{
				try
				{
				if(xmlString!=null)
				{
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
 				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
 				Document doc =dBuilder.parse(xmlString);
 			doc.getDocumentElement().normalize();
 
 				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
						
				NodeList nList = doc.getElementsByTagName("Table1");
						
				System.out.println("----------------------------");

				for (int temp = 0; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);
							
					System.out.println("\nCurrent Element :" + nNode.getNodeName());
							
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					
						Element eElement = (Element) nNode;

					//	System.out.println("Staff id : " + eElement.getAttribute("id"));
						System.out.println("c2mdatetime : " + eElement.getElementsByTagName("c2mdatetime").item(0).getTextContent());
						System.out.println("ID : " + eElement.getElementsByTagName("Id").item(0).getTextContent());
						System.out.println("City : " + eElement.getElementsByTagName("City").item(0).getTextContent());
						System.out.println("Temperature : " + eElement.getElementsByTagName("Temperature").item(0).getTextContent());
						return "success";
				
					}
					else
					{
						return "fail";
					}
				}
				}
				else
				{
					System.out.println("success but data is not comming...");
				}
				
				}
				catch (Exception e) {
					e.printStackTrace();
				}
//				
//				XmlPath path=new XmlPath(xmlString);
//			     String name = path.with(xmlString).get("root.response.status");
//			     System.out.println("datasss="+name);
				
//				
//			      ObjectMapper mapper = new XmlMapper();
//			     
//			      String value=mapper.writeValueAsString(xmlString);
//			     
//			     System.out.println("VAAAAAA="+value);
//			     
			   //Object actualObj = mapper.readValue(new URL(xmlString), List.class);
			   //  System.out.println("JsonObject="+actualObj);
				// return actualObj;	    
					
			     
			     return "fail";  
			 }
			
			
			
			
			public static void tabSwitch(int Tabno) {
						
						ArrayList tabs = new ArrayList (driver.getWindowHandles());
					    System.out.println("WindowHandler Size="+tabs.size());
					   // System.out.println("window="+tabs.get(Tabno));
					    driver.switchTo().window((String)tabs.get(Tabno));
					}
			
			 

			
			public static void tabSwitchUntil(int Tabno) {
//						ArrayList tabs = new ArrayList (driver.getWindowHandles());
//					    System.out.println("WindowHandler Size="+tabs.size());
					    
					    driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
					   // driver.switchTo().defaultContent();
					    
//					   // System.out.println("window="+tabs.get(Tabno));
//					    //driver.switchTo().activeElement();
//					   driver.switchTo().window((String)tabs.get(Tabno));
					    
					}
			 
	 

			public static void tabSwitch1() {
						
				ArrayList tabs = new ArrayList (driver.getWindowHandles());
			    System.out.println(tabs.size());
			    driver.switchTo().window((String) tabs.get(2));
					}
			
			
			
			
			
			
			

			public static void tabSwitch2() {
						
				ArrayList tabs = new ArrayList (driver.getWindowHandles());
			    System.out.println(tabs.size());
			    driver.switchTo().window((String) tabs.get(3));
					}
			
			
			
			public static void GetTitle(){
				String title = driver.getTitle();
				System.out.println(title);
				
			}
			
			

			public static void CloseTab(){
				Robot robot;
				try {
					robot = new Robot();
					robot.keyPress(KeyEvent.VK_CONTROL);
					robot.keyPress(KeyEvent.VK_W);
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			

	

@SuppressWarnings("resource")
public static void Global_Search() throws IOException {
	BufferedReader br = null;
    String sCurrentLine;
    String filepath = System.getProperty("user.dir") + "//src//testdata//testing.txt" ;
    br = new BufferedReader(new FileReader(filepath));
     while ((sCurrentLine = br.readLine()) != null) {
         System.out.println(sCurrentLine);
         
        ScrollUp();
         Scrollelement("//*[@id='txtGlobalSearch']");
        WebElement wb= driver.findElement(By.xpath("//*[@id='txtGlobalSearch']"));
        wb.sendKeys(sCurrentLine);
       }
	
}
@SuppressWarnings("resource")

public static void ScrollUp() {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(4000,0)", "");
}

public static void ScrollDown() {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,3000)", "");
}
	

public static void ScrollWinDown() {
    try {

        ((JavascriptExecutor) JavaCore.driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    } catch (Exception e) {
        //System.out.println("Exception in ScrollWinDown.");
    }
}

public static void ScrollelementByxpath(String string)
{
 WebElement StoreApph = driver.findElement(By.xpath(string));
 JavascriptExecutor je = (JavascriptExecutor)driver;
 je.executeScript("arguments[0].scrollIntoView(true);",StoreApph);
 //System.out.println("Scroll executed");
// System.out.println(StoreApph.getText());
}
public static void ScrollDivDown(String exData) {

    try {
        WebElement targetElement = JavaCore.driver.findElement(By.xpath(exData));
        JavascriptExecutor js = ((JavascriptExecutor) JavaCore.driver);

        js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
        targetElement.click();
    } catch (Exception e) {
        System.out.println(e);
    }
}

public static Actions moveToNextElement(WebElement element)
{

	Actions actions = new Actions(driver);
	actions.moveToElement(element);
	actions.click();
	return actions;
	
}

public static void setClipboardData(String string) {
	//StringSelection is a class that can be used for copy and paste operations.
	   StringSelection stringSelection = new StringSelection(string);
	   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

 

public static void CompDragAndDrop(String sourceLocator,String destLocator) throws InterruptedException {
    try {
        WebElement source =driver.findElement(ByLocator(sourceLocator));
     
        WebElement target=driver.findElement(ByLocator(destLocator));
        Actions actions = new Actions(driver);
        //actions.moveToElement(source);
        actions.dragAndDrop(source, target).build().perform();

    } catch (Exception ex) {
        //ex.printStackTrace();
    }
}


public static void LogoClick() throws InterruptedException {

WebElement element2 = driver.findElement(By.xpath("//*[@id='MyTr_paoswincustomerlogo']/ul/li/span/input"));
Actions action2 = new Actions(driver);
Thread.sleep(3000);
action2.moveToElement(element2).click().perform();
}

public static void LogoUpload() throws InterruptedException, IOException {

	Thread.sleep(3000);
	WebElement ele= driver.findElement(By.xpath("//*[@id='MyTr_paoswincustomerlogo']/ul/li/span/input"));
	Actions act= new Actions(driver);
	Thread.sleep(3000);
	act.moveToElement(ele).click().perform();
	Thread.sleep(3000);
	String uploadPath1 = System.getProperty("user.dir") + "//src//testdata//FileUpload2.exe" ;
Runtime.getRuntime().exec(uploadPath1);	

}
public static void attatchmentUpload() throws InterruptedException, IOException {
	Thread.sleep(3000);
WebElement ele= driver.findElement(By.xpath("//*[@id='lbUploadDocument_paoswinsummarycontract']"));
	Actions act= new Actions(driver);
	Thread.sleep(3000);
	act.moveToElement(ele).click().perform();
	Thread.sleep(3000);
	String uploadPath1 = System.getProperty("user.dir") + "//src//testdata//FileUpload2.exe" ;
Runtime.getRuntime().exec(uploadPath1);	
}

public static void tabSwitchParent(){
    Set <String> st= driver.getWindowHandles();
    Iterator<String> it = st.iterator();
    String parent =  it.next();
    //String child =it.next();
    //swtich to parent
    driver.switchTo().window(parent);
    System.out.println("Returned to parent");
    // switch to child 
    //driver.switchTo().window(child);
    driver.switchTo().defaultContent();
    
}


/* Function for Verifying Fields-by ID */
public static void Assertion_Field(String BTN_Path, String BTN_Name, String Locator, String error_message) {

	WebElement BTNPath = JavaCore.driver.findElement(By.xpath(BTN_Path));
	String TriggerName = BTNPath.getAttribute(Locator);
	//Assert.assertEquals(TriggerName, BTN_Name,error_message);
}




public static void scroll(String string)
{
	try
	{
	WebElement StoreApph = driver.findElement(By.xpath(string));
	JavascriptExecutor je =(JavascriptExecutor)driver;je.executeScript("arguments[0].scrollIntoView(true);",StoreApph);	

	}
	catch (Exception e) {
	e.printStackTrace();
	}
	}









// Common method for login

//Common method to quit from Driver
	public static  void Fun_DriverQuit() {
		try {
			driver.quit();
			driver = null;
		} catch (Exception e) {
			System.out.println("Exception on quit from Browser !");
		}
	}
  public static void VerifyElement(String StrXpath, String Element, String Page) {

		WebElement rxBtn = driver.findElement(ByLocator(StrXpath));
		// Assert.assertEquals(true, rxBtn.isDisplayed());
		 System.out.println("Verified the " + Element + " Element at " + Page + "Page.");
		}
  
  
	  public static void Ntab() {
			JavaCore.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		}
	  public void switchToTab() {
			// Switching between tabs using CTRL + tab keys.
			try {
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
				// Switch to current selected tab's content.
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
			} catch (Exception e) {
				System.out.println("Exception in Switch tab.");
			}

		}
	/// Function to highlight the click Area
		public static void highLightElement(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: Green; border: 5px solid red;');", element);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				System.out.println(e.getMessage());
			}
			js.executeScript("arguments[0].setAttribute('style','border: solid 2px white')", element);

		}
		public static void Fun_ONChannel() {
			try {

				driver.findElement(
						By.xpath("//*[@id='channelListContainer']/li[1]/div/div/div/div[3]/div/div[1]/span/a[2]")).click();
				Thread.sleep(3000);				
			} catch (Exception e) {
				System.out.println("Exception in On Channel function !" + e.getMessage());

			}

		}

		/// Function for Off channel
		public static void Fun_OffChannel() {
			try {
				driver.findElement(By.xpath("//*[@id='channelListContainer']/li[1]/div/div/div/div[3]/div/div[1]/span/a[2]"))
						.click();
				Thread.sleep(3000);
				driver.findElement(By.cssSelector("#pnlAlert > div.pop_content")).click();
				Thread.sleep(3000);
				driver.findElement(By.id("lnkClosePop")).click();
			} catch (Exception e) {
				System.out.println("Exception in Off Channel function !" + e.getMessage());

			}
		}
		public static void SetClipboardData(String string) {
	        StringSelection stringSelection = new StringSelection(string);
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	    }


	    public void UploadFile(String fileLocation) {
	        try {
	            SetClipboardData(fileLocation);
	            Thread.sleep(5000);
	            Robot robot = new Robot();
	            Thread.sleep(1000);
	            robot.keyPress(KeyEvent.VK_CONTROL);
	            robot.keyPress(KeyEvent.VK_V);
	            Thread.sleep(1000);
	            robot.keyRelease(KeyEvent.VK_V);
	            robot.keyRelease(KeyEvent.VK_CONTROL);
	            Thread.sleep(1000);
	            robot.keyPress(KeyEvent.VK_ENTER);
	            robot.keyRelease(KeyEvent.VK_ENTER);
	            Thread.sleep(1000);

	        } catch (Exception exp) {
	            exp.printStackTrace();
	        }
	    }
	    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
	        wait.until(ExpectedConditions.elementToBeClickable(element));
	    }
	   
	    public static void waitForElementToBeClickableListType(WebDriver driver, List<WebElement> element) {
	        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
	        
	       // wait.until(ExpectedConditions.elementToBeClickabl(element));
	    }
	   
	    public static boolean isClickable(WebElement el, WebDriver driver) 
	    {
	        try{
	            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
	            wait.until(ExpectedConditions.elementToBeClickable(el));
	            return true;
	        }
	        catch (Exception e){
	            return false;
	        }
	    }  
	    
	    public static String getPageTitle() {
	        return driver.getTitle();  // This fetches the title of the current page
	    }
	
	    public static void scrollWinDown() {
	        try {

	            ((JavascriptExecutor)driver)
	                    .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        } catch (Exception e) {
	            //System.out.println("Exception in ScrollWinDown.");
	        }
	    }
	   
	    /**
	     * Retrieves the visible text of a web element located by the provided By locator.
	     *
	     * @param locator the By locator of the element
	     * @return the visible text of the web element
	     */
	    public static String getElementText(String locatorString) {
	        try {
	            // Locate the element directly using XPath
	            WebElement element = driver.findElement(By.xpath(locatorString));

	            // Get visible text
	            String text = element.getText();
	            if (text != null && !text.trim().isEmpty()) {
	                return text;
	            }

	            // If no visible text, return a message indicating no text found
	            return "No text found in the element.";
	        } catch (Exception e) {
	            System.out.println("Error while fetching text from element: " + locatorString);
	            e.printStackTrace();
	            return null;
	        }
	    }

	    public static void clearAndSendKeys(String locator, String value) {
	        try {
	            // Wait for the element to be present
	            WaitForElementPresent(locator, timeout);

	            // Convert the string locator to a By object
	            WebElement element = driver.findElement(ByLocator(locator));

	            // Clear the field
	            element.clear();

	            // Send the new value
	            element.sendKeys(value);

	        } catch (Exception e) {
	            System.out.println("Error in clearAndSendKeys: " + e.getMessage());
	        }
	    }

	    public static  void ScrollDivDownById(String id) {
	        try {
	            // Initialize Javascript executor
	            JavascriptExecutor js = (JavascriptExecutor)driver;

	            // Scroll inside web element vertically (e.g. 100 pixel)
	            js.executeScript("arguments[0].scrollTop = arguments[1];",driver.findElement(By.id(id)), 500);
	        } catch (Exception ex) {

	        }
	    }
	    
	   
	    

	    
	  
	//Extent Report Logic.....
//			@BeforeMethod
//			public void beforeMethod(Method method)
//			{
//		     		//ExtentTestManager.startTest(method.getName());
//			}
			
//			@AfterMethod
//			protected void afterMethod(ITestResult result)
//			{
//				this.result=result;
//				
//				if(result.getStatus()==ITestResult.FAILURE)
//				{
//					ExtentTestManager.getTest().log(LogStatus.FAIL,result.getThrowable());		
//				}
//				else if(result.getStatus()==ITestResult.SKIP)
//				{
//					ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Skipped "+result.getThrowable());
//					
//				}
//				else
//				{
//					ExtentTestManager.getTest().log(LogStatus.PASS,"Test Passed");		
//				}
//				ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
//				ExtentManager.getReporter().flush(); 
//			 }



}
