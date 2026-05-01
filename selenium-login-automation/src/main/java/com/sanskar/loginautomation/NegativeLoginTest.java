package com.sanskar.loginautomation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NegativeLoginTest {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("wrong_user");
		driver.findElement(By.id("password")).sendKeys("wrong_password");
		driver.findElement(By.id("login-button")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.error-message-container"), "Epic sadface"));
		WebElement element = driver.findElement(By.cssSelector("div.error-message-container"));	    	
		String text = element.getText();
			if(text.contains("Epic sadface"))
				{
					System.out.println("Error displayed correctly");
				}
			else
				{
					System.out.println("Error not displayed correctly");
				}		
		driver.quit();

	}

}
