package com.qa.tatoc.Advance.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DriverFactory {
	WebDriver driver;
	private static DriverFactory ob;
	
	// A private Constructor prevents any other class from instantiating.
	private DriverFactory(){
	}
	
	//Static 'instance' method 
	public static DriverFactory getInstance() {
		if(ob==null){
			ob=new DriverFactory();
		}
		return ob;
	}
	
	public void initDriver(){
		System.setProperty("webdriver.chrome.driver","C:\\Users\\manishpatel\\Downloads\\chromedriver_win32\\chromedriver.exe");
		if(driver==null){
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");
		driver.manage().window().maximize();
		}
	}
	
	public WebElement elementByXpath(String xpath){
		return driver.findElement(By.xpath(xpath));
	}
	
	public void clickByXpath(String xpath){
		elementByXpath(xpath).click();
	}

	public void sendKeysByXpath(String xpath, String content){
		elementByXpath(xpath).sendKeys(content);
	}
	
	public String getTextByXpath(String xpath){
		return elementByXpath(xpath).getText();
	}
	
	public void hoverAndClick(WebElement elementToHover, WebElement elementToClick){
		Actions action = new Actions(driver);
		action.moveToElement(elementToHover).click(elementToClick).build().perform();
	}

}
