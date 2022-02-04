package com.ha.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GotoMeetingTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Components\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.goto.com/meeting/"); 
		
		//button[text()='Accept Recommended Settings']
		driver.findElement(By.id("truste-consent-button")).click();
		
		driver.findElement(By.linkText("Try Free")).click();
		driver.findElement(By.id("first-name")).sendKeys("balaji");
		
		driver.findElement(By.id("login__email")).sendKeys("bala@outlook.com");
		
		Select select=new Select(driver.findElement(By.id("CompanySize")));
//		select.selectByVisibleText("10 - 99");
		select.selectByValue("10 - 99");
//		select.selectByIndex(0);
	
		
		//button[contains(text(),'Start')]
		driver.findElement(By.xpath("//button[text()='Start My Trial']")).click();
		
		String header=driver.findElement(By.xpath("//h1[contains(text(),'free')]")).getText();
		System.out.println(header);
		
		String error= driver.findElement(By.xpath("//div[@class='inputField__requirements']")).getText();
		System.out.println(error);
		
		String href=driver.findElement(By.linkText("Terms of Service")).getAttribute("href");
		System.out.println(href);
		
		String tagname=driver.findElement(By.linkText("Terms of Service")).getTagName();
		System.out.println(tagname);
	}

}
