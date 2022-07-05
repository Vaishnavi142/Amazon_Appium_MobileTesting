package AmazonAutomation;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.MobileCapabilityType;

public class iphonePriceDisplay 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try 
		{			
			DesiredCapabilities dc= new DesiredCapabilities();
			dc.setCapability("adbExecTimeout" , 90000);
			dc.setCapability("appWaitDuration" , 50000);
			dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME,"MyDevice");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			AndroidDriver driver = new AndroidDriver(url, dc);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@content-desc = 'Amazon Shopping']")).click();
			System.out.println("Entered into amazon app.");
			Thread.sleep(5000);
			
			driver.findElement(By.id("com.amazon.mShop.android.shopping:id/chrome_action_bar_search_disabled")).click();
			System.out.println("clicked the search button.");
			Thread.sleep(3000);
			
			driver.findElement(By.id("com.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("Mobile Phones");
			System.out.println("Entered 'mobile phones' in search box.");
			Thread.sleep(3000);
			
			driver.findElement(By.id("com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text")).click();
			//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
			System.out.println("Selected 'mobile phones' from dropdown.");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@text = 'Filters']")).click();
			System.out.println("clicked on filters.");
			Thread.sleep(3000);
			
			WebElement ios= driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"BlackBerry\").instance(0))"));
			System.out.println("The iOS element is present in the location : " +ios.getLocation());
			Thread.sleep(5000);		
			
			driver.findElement(By.xpath("//*[@text = 'iOS']")).click();
			System.out.println("Selected 'iOS' from the filter.");
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@text = 'Close']")).click();
			System.out.println("Closed the filter window.");
			Thread.sleep(3000);
			
			WebElement element = (WebElement) driver.findElement(By.xpath("//*[@text='Simple Mobile Apple iPhone SE 5G (3rd Generation), 64GB, Black - Prepaid Smartphone, (SMAPISE3G64BKP5)']"));
			//WebElement element = driver.findElement(By.xpath("//*[@text='Apple iPhone 11 [64GB, Purple] + Carrier Subscription [Cricket Wireless]']"));
			String model = element.getText();
			Thread.sleep(3000);
			
			
			driver.findElement(By.xpath("//*[@text = 'Simple Mobile Apple iPhone SE 5G (3rd Generation), 64GB, Black - Prepaid Smartphone, (SMAPISE3G64BKP5)']")).click();
			//driver.findElement(By.xpath("//*[@text = 'Apple iPhone 11 [64GB, Purple] + Carrier Subscription [Cricket Wireless]']")).click();
			System.out.println("Clicked the relevant mobile phone.");
			Thread.sleep(3000);
			System.out.println("*************************************************************");
			System.out.println("YOUR RESULT: ");
			System.out.println("\n");
			System.out.println("Iphone Model: "+model);
			
			if(driver.findElement(By.xpath ("//*[@text='Enhance your purchase']")).isDisplayed()) //scroll till price
			{
				WebElement tradein=driver.findElement(By.xpath ("//*[@text='Trade In']"));//tradein
				if(tradein.isDisplayed())//scroll till price
				{
					WebElement pricescroll= driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Price:\"))"));
					WebElement price = driver.findElement(By.xpath ("//*[@text='$379.99']"));
					String iprice = price.getText();
					Thread.sleep(3000);
					System.out.println("iPhone price:  "+iprice);
					System.out.println("----------Successfully printed the iphone model name and its price----------");
				}
				
				else
				{
					WebElement price = driver.findElement(By.xpath ("//*[@text='$379.99']"));
					String iprice = price.getText();
					Thread.sleep(3000);
					System.out.println("iPhone price:  "+iprice);
					System.out.println("----------Successfully printed the iphone model name and its price----------");	
				}			
			}
			else
			{				
				System.out.println("iPhone currently unavailable!");
				WebElement pricescroll= driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Currently unavailable.\"))"));
				Thread.sleep(3000);
				System.out.println(pricescroll.getText());
				System.out.println("---------Testing done---------");	
			}		
			driver.quit();
		}		
		catch(Exception e)
		{
			System.out.println("Exception Found!!!! "+e);
		}

	}

}

	


