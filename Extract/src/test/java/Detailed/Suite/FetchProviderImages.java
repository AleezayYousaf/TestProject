package Detailed.Suite;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.Test;
//
//import Objects.ProviderObject;
//import Objects.TestListener;
//import Objects.Utility;
//import Objects.Xls_Reader;
//import Objects.ZDObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class FetchProviderImages {
	// Objects
		Logger logger = Logger.getLogger("FetchProviders");
		public static WebDriver driver;
//		public static Xls_Reader excelfile = null;
//		TestListener tlistener=new TestListener();
//		Utility utility=new Utility();
//		int n=518;
//		int rowNumber=1,processedRecords;
		ChromeOptions options;
//		ZDObjects zdObj;
//		String Query= "", cs="jdbc:sqlserver://release01:1433;DatabaseName=LiveIssues_CureMD;user=curemd;password=cure2000;";
//		String user = "curemd";
//		String password = "cure2000";
//		
		
//		Connection conn;
//		Statement stmt;
//		ProviderObject providerObj;
		//Test Case: Charge Process
		@Features("Charge Process")
		@Stories("Charge Process") 
		@Title("Charge Process")
		@Test(priority=1 , description="Charge Process")
		public void preReq () throws InterruptedException, IOException {

			WebDriverManager.chromedriver().setup();
			String downloadFilepath = System.getProperty("user.dir");	
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath);
			options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);	
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(ChromeOptions.CAPABILITY, options);
			options.setExperimentalOption("useAutomationExtension", false);
			driver= new ChromeDriver(options);
			//		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\geckodriver.exe");
			//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			//		capabilities.setCapability("marionette",true);
			//		driver= new FirefoxDriver(capabilities);
//			zdObj= new ZDObjects(driver);
//			PropertyConfigurator.configure("Log4j.properties");
//			String filepath = System.getProperty("user.dir")+"\\Zocdoc.xlsx";
//			if(excelfile == null){
//				// load the Excel sheet
//				excelfile = new Xls_Reader(filepath);		
//			}
//			try {
//				conn = DriverManager.getConnection(cs, user, password);
//				stmt = conn.createStatement();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			driver.get("https://www.zocdoc.com/");
			driver.manage().window().maximize();
		}

//		//Test Case
//		@Test(priority=2,dataProvider="get_test_data")
//		public void GetProviders(String Specialties,String Status,String Execution) throws InterruptedException, IOException, ParseException, AWTException {
//			rowNumber++;
//			if(Status=="") {
//				
//				utility.checkPageIsReady(driver);
//				int currentRecord=0;
//				JavascriptExecutor executor = (JavascriptExecutor)driver;
//				try {	
//					utility.Pause(driver,zdObj.DoctorNameField  , "Visibility", 30);
//				} catch (Exception excep) {}
//				utility.PomFindClick(driver, zdObj.DoctorNameField);
//				logger.info("Doctor Speciality field clicked");
//
//				Thread.sleep(4000);
//				int size= zdObj.AllSpecialties.size();
//				logger.info(size);
//				WebElement currentSpecialty=null;
//				for(int i=0;i<size;i++) {
//					//
//					utility.checkPageIsReady(driver);
//					try {
//						executor.executeScript("arguments[0].click();", zdObj.DoctorNameField);
//						logger.info("Doctor Speciality field clicked");
//
//						Thread.sleep(4000);
//					}catch(Exception e) {}
//					String specialty = utility.PomReturnText(driver, zdObj.AllSpecialties.get(i));
//					if(Specialties.contains(specialty)) {
//						currentSpecialty= zdObj.AllSpecialties.get(i);
//						break;
//					}
//				}
//				processedRecords= Integer.parseInt(Execution);
//				executor.executeScript("arguments[0].click();", currentSpecialty);
//				logger.info(Specialties + " clicked");
//				Thread.sleep(3000);
//				executor.executeScript("arguments[0].click();", zdObj.SearchButton);
//				logger.info("Search button clicked");
//				Thread.sleep(3000);
//				int pagesCount= zdObj.Pages.size();
//				System.out.println("Pages: " + pagesCount);
//				//			for(int b=0;b<zdObj.DoctorNamesLinks.size();b++) {
//				//				System.out.println(zdObj.DoctorNamesLinks.get(b).getText());
//				//			}
//				for(int j=1;j<=pagesCount;j++) {
//					utility.checkPageIsReady(driver);
//					Thread.sleep(8000);
//					int recordsCount= zdObj.DoctorNamesLinks.size();
//					for(int k=0;k<recordsCount;k++) {
//						currentRecord++;
//						logger.info(currentRecord);
//						if(currentRecord>processedRecords) {
//							logger.info("Records processed- " + processedRecords);
//							driver.switchTo().defaultContent();
//							executor.executeScript("arguments[0].click();", zdObj.DoctorNamesLinks.get(k));
//							logger.info("Doc Name Link clicked");
//							providerObj= new ProviderObject();
//							try {	
//								utility.Pause(driver,zdObj.ProviderName  , "Visibility", 30);
//							} catch (Exception excep) {}
//							try {
//								providerObj.providerName= utility.PomReturnText(driver, zdObj.ProviderName);
//								providerObj.providerName = providerObj.providerName.replace("'", "''");
//								logger.info("Provider name fetched- " + providerObj.providerName);
//							}catch(Exception e) {}
//							try {
//								providerObj.npiNumber= utility.PomReturnText(driver, zdObj.NPI);
//								logger.info("NPI number fetched - " +providerObj.npiNumber);
//							}catch(Exception e) {
//
//							}
//							utility.PomFindClick(driver, zdObj.ImagesLink);
//							logger.info("Images link clicked");
//							//Locate Image
//							WebElement Image =driver.findElement(By.xpath("//img[contains(@data-test,'profile-picture-gallery-zoom')]"));
//							Thread.sleep(3000);
//							//Rihgt click on Image using contextClick() method.
//							Actions action= new Actions(driver);
//							action.contextClick(Image).build().perform();
//							Thread.sleep(3000);
//							//To perform press Ctrl + v keyboard button action.
//							// action.sendKeys(Keys.CONTROL, "S").build().perform();
//							Thread.sleep(3000);
//							Robot robot = new Robot();
//							// To press D key.
//							//						  robot.keyPress(KeyEvent.VK_CONTROL);
//							// To press : key.
//							robot.keyPress(KeyEvent.VK_DOWN);
//							Thread.sleep(1000);
//							robot.keyRelease(KeyEvent.VK_DOWN);
//							Thread.sleep(1000);
//							robot.keyPress(KeyEvent.VK_DOWN);
//							Thread.sleep(1000);
//							robot.keyRelease(KeyEvent.VK_DOWN);
//							Thread.sleep(1000);
//							robot.keyPress(KeyEvent.VK_ENTER);
//							Thread.sleep(1000);
//							robot.keyRelease(KeyEvent.VK_ENTER);
//							Thread.sleep(1000);
//							try {
//								robot.keyPress(KeyEvent.VK_BACK_SPACE);	
//								robot.keyRelease(KeyEvent.VK_BACK_SPACE);
//							}
//							catch(Exception ex)
//							{
//
//							}
//							StringSelection stringSelection;
//							Clipboard clipboard;
//							n++;
//							stringSelection = new StringSelection(System.getProperty("user.dir") +"\\Pictures\\"+ providerObj.providerName+ "-"+ providerObj.npiNumber+"_"+ n+".jpg");
//							clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//							clipboard.setContents(stringSelection, stringSelection);
//							Thread.sleep(3000);
//							robot.keyPress(KeyEvent.VK_CONTROL);
//							robot.keyPress(KeyEvent.VK_V);
//							robot.keyRelease(KeyEvent.VK_V);
//							robot.keyRelease(KeyEvent.VK_CONTROL);
//							Thread.sleep(3000);		
//							robot.keyPress(KeyEvent.VK_ENTER);	
//							robot.keyRelease(KeyEvent.VK_ENTER);
//							robot.keyPress(KeyEvent.VK_ENTER);
//							robot.keyRelease(KeyEvent.VK_ENTER);
//							Thread.sleep(3000);
//							utility.PomFindClick(driver, zdObj.CloseImage);
//							logger.info("Image closed");
//							Thread.sleep(3000);
//							driver.navigate().back();
//							utility.checkPageIsReady(driver);
//							processedRecords++;
//							logger.info("processed records: " + processedRecords + " , n: " + n);
//							excelfile.setCellData("Sheet1", "Execution", rowNumber, String.valueOf(processedRecords));
//						}
//						Thread.sleep(2000);
//					}
//					if(j!=pagesCount) {
//						executor.executeScript("arguments[0].click();", zdObj.Pages.get(j));
//						System.out.println("Page " + j + " clicked.");
//						utility.checkPageIsReady(driver);
//						try {	
//							utility.Pause(driver,zdObj.Loading  , "Invisibility", 30);
//						} catch (Exception excep) {}
//						Thread.sleep(2000);
//					}
//				}
//				//
//				Thread.sleep(2000);
//				excelfile.setCellData("Sheet1", "Status", rowNumber, "Processed");
//			}
//		}
}
