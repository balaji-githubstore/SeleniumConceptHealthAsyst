package com.ha.advance;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class AlertTest2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Components\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://netbanking.hdfcbank.com/netbanking/IpinResetUsingOTP.htm");

//		driver.findElement(By.xpath("//img[contains(@src,'go.gif')]")).click();

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);
		
		WebElement blockedOverlay = wait.until(new Function<WebDriver>() {
	        public void apply(WebDriver webd) {
	            return webd.findElement(By.xpath("//img[contains(@src,'go.gif')]"));
	        }
	    });
		
		wait.until(new Function<WebDriver, WebElement>() {
	        public WebElement apply(WebDriver d) {
	            return d.findElement(By.xpath("//img[contains(@src,'go.gif')]"));
	        }
	    });
		
		
		
		blockedOverlay.click();

//		WebElement foo = (WebElement) wait.until(new Function() {
//			@Override
//			public WebElement apply(Object driver) {
//				return ((WebDriver) driver).findElement(By.xpath("//img[contains(@src,'go.gif')]"));
//			}
//		});
	}

	
}
