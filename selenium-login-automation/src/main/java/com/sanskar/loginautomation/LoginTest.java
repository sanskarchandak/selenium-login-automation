package com.sanskar.loginautomation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	public static void main(String[] args) 
	{
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
			String url = driver.getCurrentUrl();			   
				if(url.contains("inventory"))
				{
					System.out.println("Login success");   //prints when login is success
				}
				else
					System.out.println("Login failed");
			driver.quit();
	}

}
