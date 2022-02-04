package com.ha.advance;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTest {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Components\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://netbanking.hdfcbank.com/netbanking/IpinResetUsingOTP.htm"); 
		
		driver.findElement(By.xpath("//img[contains(@src,'go.gif')]")).click();
		
		
		String alertText=driver.switchTo().alert().getText();
		System.out.println(alertText);
		
//		driver.switchTo().alert().sendKeys("hello"); //chrome it may not support
		
		driver.switchTo().alert().dismiss();
	}

}


