package lambda.Lambdaproject;


import org.junit.Assert;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Scenario1{
	private RemoteWebDriver driver;
    private String Status = "failed";
    String username = System.getenv("LT_USERNAME") == null ? "gomathiabi2000" : System.getenv("LT_USERNAME");
    String authkey = System.getenv("LT_ACCESS_KEY") == null ? "WhzkcL3dvdA5Z54ESIk8QqsEqLIL3lPyF56uS2Xd18cVDiVtnZ" : System.getenv("LT_ACCESS_KEY");
    String hub = "@hub.lambdatest.com/wd/hub";
    String testurl="https://www.lambdatest.com/selenium-playground/";
	 
    @BeforeTest
	  @Parameters(value={"browser","version","platform", "resolution"})
	    public void setup(String browser, String version, String platform, String resolution) throws MalformedURLException {
	        

		  DesiredCapabilities caps = new DesiredCapabilities();
	       caps.setCapability("build", "[LambdaTest] Demonstration of Selenium Automation Testing");
	       caps.setCapability("name", "[LambdaTest] Demonstration of Selenium Automation Testing");
	       caps.setCapability("platform", platform);
	       caps.setCapability("browserName", browser);
	       caps.setCapability("version",version);
	       caps.setCapability("resolution",resolution);
	       caps.setCapability("tunnel",false);
	       caps.setCapability("network",true);
	       caps.setCapability("console",true);
	       caps.setCapability("visual",true);

	        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
	        caps.setCapability("tags", Tags);

	        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
	    }
    @Test
	public void scenario1() throws InterruptedException {
		
    driver.get(testurl);
    driver.manage().window().maximize();
    Thread.sleep(3000);
    JavascriptExecutor js = (JavascriptExecutor)driver;	
    WebElement button=driver.findElement((By.cssSelector("#__next > div.wrapper > section.my-50 > div > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(1) > a")));
    js.executeScript("arguments[0].click();", button);
    String url= driver.getCurrentUrl();
    System.out.println(url);
     if(url.contains("simple-form-demo"))
    {
	  System.out.println("The url contains this text");
    }
       
       String msg ="Welcome to LambdaTest";
       driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(msg);

       driver.findElement(By.xpath("//button[@id='showInput']")).click();
      Thread.sleep(2000);
  String msg2=driver.findElement(By.xpath("//p[@id='message']")).getText();
  Assert.assertEquals(msg2, "Welcome to LambdaTest");
  Thread.sleep(1000);
  driver.close();
    }
    @Test
    public void scenario2() throws InterruptedException {
    		driver.get("https://www.lambdatest.com/selenium-playground/");
            driver.manage().window().maximize();
            Thread.sleep(2000);
            
            JavascriptExecutor js = (JavascriptExecutor)driver;	
            WebElement button=driver.findElement((By.cssSelector("#__next > div.wrapper > section.my-50 > div > div > div:nth-child(1) > div:nth-child(2) > ul > li:nth-child(3) > a")));
            js.executeScript("arguments[0].click();", button);
            Thread.sleep(1000);
            WebElement slider =driver.findElement(By.xpath("//div[@id='slider3']/div/input[@class='sp__range']"));
            Actions move = new Actions(driver);
    	    Action action = (Action) move.dragAndDropBy(slider, 119, 0).build();
    	     action.perform();
            Thread.sleep(1000);
            
           String range= driver.findElement(By.xpath("//output[@id='rangeSuccess']")).getText();
            System.out.println(range);
            if(range.equalsIgnoreCase("95")) {
            	System.out.println("Same range");
            	
            }
            //Assert.assertEquals("95", range);
            driver.close();

    	}
  @Test
	public void scenario3() throws InterruptedException {
		
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor)driver;	
        WebElement button=driver.findElement((By.cssSelector("#__next > div.wrapper > section.my-50 > div > div > div:nth-child(1) > div:nth-child(1) > ul > li:nth-child(5) > a")));
        js.executeScript("arguments[0].click();", button);
        WebElement sbtbutton=driver.findElement((By.xpath("//button[@type='submit']")));
        js.executeScript("arguments[0].click();", sbtbutton);
     
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Muthugomathi");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("gomathiabi2000@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12588");
        driver.findElement(By.xpath("//input[@ placeholder='Company']")).sendKeys("cts");
        driver.findElement(By.xpath("//input[@placeholder='Website']")).sendKeys("www.cts.com");
        Select  country = new Select(driver.findElement(By.xpath("//select[@name='country']")));
        country.selectByVisibleText("United States");
        driver.findElement(By.xpath("//input[@ placeholder='City']")).sendKeys("Rajapalayam");
        driver.findElement(By.xpath("//input[@placeholder='Address 1']")).sendKeys("127/153 mukill vannam strt");
        driver.findElement(By.xpath("//input[@placeholder='Address 2']")).sendKeys("27/153 mukill vannam strt");
        driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("Tamilnadu");
        driver.findElement(By.xpath("//input[@id=\"inputZip\"]")).sendKeys("626117");
        
        WebElement sbtbutton1=driver.findElement((By.xpath("//button[@type='submit']")));
        js.executeScript("arguments[0].click();", sbtbutton1);
       String successmsg= driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
       System.out.println(successmsg);
       Assert.assertEquals(successmsg, "Thanks for contacting us, we will get back to you shortly.");
        
      
        
       
       
	}


   
   
}