package com.ha.advance;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CitiMultipleTabs {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Components\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.online.citibank.co.in/"); 
		
		driver.findElement(By.linkText("APPLY FOR CREDIT CARDS")).click();
		 
		List<String> windows=new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(windows.get(1));
		
		driver.findElement(By.linkText("Travel")).click();
		driver.close();
		driver.switchTo().window(windows.get(0));
		String title = driver.getTitle();
		System.out.println(title);
	}

}
