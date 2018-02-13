package com.qa.project.TAFW.driverfactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DriverFactory {

		public static WebDriver driver;
		public static final String url = "http://10.0.1.86/tatoc";
		
		public static void initDriver(){
			System.setProperty("webdriver.chrome.driver","src//test//java//com//qa//project//TAFW//driver//chromedriver.exe");
			if(driver==null){
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			}
		}
		
		public static WebElement elementByXpath(String xpath){
			return driver.findElement(By.xpath(xpath));
		}
		
		public static void clickByXpath(String xpath){
			elementByXpath(xpath).click();
		}

		public static void sendKeysByXpath(String xpath, String content){
			elementByXpath(xpath).sendKeys(content);
		}
		
		public static String getTextByXpath(String xpath){
			return elementByXpath(xpath).getText();
		}
		
		public static void hoverAndClick(WebElement elementToHover, WebElement elementToClick){
			Actions action = new Actions(driver);
			action.moveToElement(elementToHover).click(elementToClick).build().perform();
		}
}
