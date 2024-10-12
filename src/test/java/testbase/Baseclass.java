package testbase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters; 


public class Baseclass {

public static WebDriver driver;
public Logger logger;           //log4j
public Properties p; 


	@BeforeClass(groups = {"Sanity","Regression", "master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		
		//Loading config.properties
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
	  logger=LogManager.getLogger(this.getClass());   //log4j2
	  
	  
//	  From line number 50 to 80 number code is for Grid Setup         //From line number 82 to 91 number code is for if Execution env is local we refer that code (Properties file we will mention local or remote)
	  if(p.getProperty("Execution_env").equalsIgnoreCase("remote"))
	  {
		  DesiredCapabilities Capabilities = new DesiredCapabilities();
		  
		  //os
		  if(os.equalsIgnoreCase("windows"))
		  {
			  Capabilities.setPlatform(Platform.WIN11);
		  }
		  
		  else if(os.equalsIgnoreCase("mac"))
		  {
			  Capabilities.setPlatform(Platform.MAC);
		  }
		  else
		  {
			  System.out.println("No matching os");
			  return;
		  }
					 
		  //Browser
		  switch(br.toLowerCase())
		  {
		  case "chrome": Capabilities.setBrowserName("chrome"); break;
		  case "edge": Capabilities.setBrowserName("MicrosoftEdge"); break;
		  case "firefox": Capabilities.setBrowserName("firefox"); break;
		  default: System.out.println("No Matching browser"); return;
		  }
		  
		  driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),Capabilities);
	  }
	  
	  
	  if(p.getProperty("Execution_env").equalsIgnoreCase("local"))
	  {
		  switch (br.toLowerCase())
		  {
		  case "chrome" : driver = new ChromeDriver(); break;
		  case "edge" : driver = new EdgeDriver(); break;
		  case "firefox" : driver = new FirefoxDriver(); break;
		  default : System.out.println("Invalid browser name.."); return ;
		  }  
	  }
	  
	  driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get(p.getProperty("appURL2"));  //Reading URL from Propereties file.
	  
	  driver.manage().window().maximize();
	  		  
	}
	
	@AfterClass(groups = {"Sanity","Regression", "master"})
	public void teardown() 
	{
	driver.quit();
	}
	
	
	
	public String randomstring()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
 	}
	
	
	public String randomnumber()
	{
		String generatednum=RandomStringUtils.randomNumeric(10);
		return generatednum;
	}
	
	public String randomalphanumeric()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedString+"@#$"+generatednumber);
	}
	
	public String captureScreen(String tname) throws IOException{
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp +".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	
}
