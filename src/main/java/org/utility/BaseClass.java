package org.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static WebDriver browserLaunch(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		return driver;
	}
	public static WebDriver launchBrowser(String browsername) {
		
		switch(browsername) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		default:
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		return driver;
	}
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public static void implicitWait(long secs) {
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}
	public static void thread(long millis) throws InterruptedException {
		Thread.sleep(millis);
	}
	public static void sendKeys(WebElement e,String value) {
		e.sendKeys(value);
	}
	public static void click(WebElement e) {
		e.click();
	}
	public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}
	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}
	public static String getAttributeInnerText(WebElement e) {
		String attribute = e.getAttribute("innerText");
		return attribute;
	}
	public static void quit() {
		driver.quit();
	}
	public static void close() {
		driver.close();
	}
	public static String getTille() {
		String title = driver.getTitle();
		return title;
	}
	public static String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	public static void moveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();;
	}
	public static void actionclick(WebElement e) {
		Actions a=new Actions(driver);
		a.click(e).perform();
	}
	public static void doubleClick(WebElement e) {
		Actions a=new Actions(driver);
		a.doubleClick(e).perform();
	}
	public static void contextClick(WebElement e) {
		Actions a=new Actions(driver);
		a.contextClick(e).perform();
	}
	public static void clickAndHold(WebElement e) {
		Actions a=new Actions(driver);
		a.clickAndHold(e).perform();
	}
	public static void release(WebElement e) {
		Actions a=new Actions(driver);
		a.release(e).perform();
	}
	private void dragAndDrop(WebElement src,WebElement des) {
		Actions a=new Actions(driver);
		a.dragAndDrop(src, des);		
	}
	public static void enterKey() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void downKey() throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);
	}
	public static void selectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByValue(value);
	}
	public static boolean isMultibel(WebElement e) {
		Select s=new Select(e);
		boolean multiple = s.isMultiple();
		return multiple;
	}
	public static String getFirstSelectedOption(WebElement e) {
		Select s=new Select(e);
		WebElement fs = s.getFirstSelectedOption();
		String text = fs.getText();
		return text;
	}
	public static void selectAllIndex(WebElement e) {
		Select s=new Select(e);
		List<WebElement> os = s.getOptions();
		for(int i=0;i<os.size();i++) {
			
			s.selectByIndex(i);
		}
	}
	public static void selectAllValue(WebElement e) {
		Select s=new Select(e);
		List<WebElement> os = s.getOptions();
		for(int i=0;i<os.size();i++) {
			WebElement wb = os.get(i);
			String text = wb.getText();
			s.selectByValue(text);
		}
	}
	public static void selectAllVisibleText(WebElement e) {
		Select s=new Select(e);
		List<WebElement> os = s.getOptions();
		for(int i=0;i<os.size();i++) {
			WebElement w = os.get(i);
			String attribute = w.getAttribute("value");
			s.selectByVisibleText(attribute);
		}
	}
//	public static String getOptions(WebElement e) {
//		Select s=new Select(e);
//		List<WebElement> op = s.getOptions();
//		for(int i=0;i<op.size();i++) {
//			WebElement w = op.get(i);
//			String text = w.getText();
//		}
//		return text;
//
//	}
	public static void selectByVisibleText(WebElement e,String text) {
		Select s=new Select(e);
		s.selectByVisibleText(text);
	}
	public static void deselectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.deselectByIndex(index);
	}
	public static void deselectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.deselectByValue(value);
	}
	public static void deselectByVisibleText(WebElement e,String text) {
		Select s=new Select(e);
		s.deselectByVisibleText(text);
	}
	public static void deselectAll(WebElement e) {
		Select s=new Select(e);
		s.deselectAll();
	}
	public static void navigateTo(String url) {
		driver.navigate().to(url);		
	}
	public static void back() {
		driver.navigate().back();
	}
	public static void forward() {
		driver.navigate().forward();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static boolean isDisplayed(WebElement e) {
		boolean displayed = e.isDisplayed();
		return displayed;
	}
	public static boolean isEnabled(WebElement e) {
		boolean enabled = e.isEnabled();
		return enabled;
	}
	public static boolean isSelected(WebElement e) {
		boolean selected = e.isSelected();
		return selected;
	}
	public static void frameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	public static void frameBySring(String id) {
		driver.switchTo().frame(id);
	}
	public static void frameByWebElements(WebElement e) {
		driver.switchTo().frame(e);
	}
	public static void screenshot(String filename) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshot\\"+filename+"_"+System.currentTimeMillis()+".png");
		FileUtils.copyFile(src, des);
	}
	public static void elementScreenShot(WebElement e,String filename) throws IOException {
		File src = e.getScreenshotAs(OutputType.FILE);
		File des=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Screenshot\\"+filename+" "+System.currentTimeMillis()+".png");
		FileUtils.copyDirectory(src, des);
	}
	public static void jsClick(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", e);
	}
	public static void jsSendKeys(WebElement e,String text) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+text+"')", e);
	}
	public static String jsgetAttribute(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Object ess = js.executeScript("return arguments[0].getAttribute('value')", e);
		System.out.println(ess);
		String text = ess.toString();
		return text;
	}
	public static void scrollDown(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	public static void scrollUp(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", e);
	}
	public static void windowHandle() {
		String parent = driver.getWindowHandle();
		Set<String> all = driver.getWindowHandles();
		for(String each:all) {
			if(!parent.equals(each)) {
				driver.switchTo().window(each);
			}
		}
	}
	public static void windowHandleCount(int no) {
		
		Set<String> all = driver.getWindowHandles();
		int count=1;
		for(String each:all) {
			if(count==no) {
				driver.switchTo().window(each);
			}
			count++;
		}
	}
	public static void windowHandleId(int index) {
		
		Set<String> all = driver.getWindowHandles();
		List<String> li=new LinkedList<String>();
		li.addAll(all);
		String st = li.get(index);
		driver.switchTo().window(st);
	}
	
	public static String excelRead(String filename,String sheetname,int row,int cell) throws IOException {
		File loc=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel\\"+filename+".xlsx");
		
		FileInputStream fs=new FileInputStream(loc);
		
		Workbook w=new XSSFWorkbook(fs);
		
		Sheet sheet = w.getSheet(sheetname);
		Row r = sheet.getRow(row);
		Cell c = r.getCell(cell);
		int type = c.getCellType();
		String value="";
		if(type==1) {
			value = c.getStringCellValue();
		}
		else {
			if(DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat sf=new SimpleDateFormat("DD/MM/YYYY");
				value = sf.format(date);
			}
			else {
				double db = c.getNumericCellValue();
				long num=(long) db;
				value = String.valueOf(num);
			}
		}
		return value;


	}
//	public static void assertTrue(String text) {
//		String currentUrl = driver.getCurrentUrl();
//		boolean contains = currentUrl.contains(text);
//		Assert.assertTrue("verify the url", contains);
//
//	}
//	public static void assertEquals(String text1,WebElement e,String text) {
//		String attribute = e.getAttribute("value");
//		Assert.assertEquals(text1,text, attribute);
//
//	}
	
	
	
	
	
	
	
	
	
	

}
