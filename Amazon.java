package Testcases;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Utils.BrowserManager;


public class Amazon {

	
	WebDriver driver= BrowserManager.getDriver("chrome");
	@BeforeTest
	public void launchAmazon()
	{
		
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		
	}

	@Test(priority=1)
	public void validLogin() throws InterruptedException 

	{ 	
		WebElement signIn=driver.findElement(By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]"));
		signIn.click();
		WebElement email= driver.findElement(By.xpath("//input[@type=\"email\"and @name=\"email\"]"));
		email.sendKeys("bhumikagupta924@gmail.com");
		WebElement Continue= driver.findElement(By.xpath("//span[@id=\"continue\"]"));
		Continue.click();
		WebElement password= driver.findElement(By.xpath("//input[@type=\"password\"and @name=\"password\"]"));
		password.sendKeys("Bhumika@123");
		WebElement signInButton= driver.findElement(By.xpath("//input[@type=\"submit\" and @id=\"signInSubmit\"]"));
		signInButton.click();
	
	}
	@Test(priority=2)
	public void searchLaptop() throws InterruptedException
	{
		
		WebElement search=driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\" and @aria-label=\"Search\"]"));
		search.sendKeys("laptop");
		WebElement search_icon=driver.findElement(By.xpath("//div[@class=\"nav-search-submit nav-sprite\"]"));
		search_icon.click();
		WebElement star04_and_Above_Filter=driver.findElement(By.xpath("//i[@class=\"a-icon a-icon-star-medium a-star-medium-4\"]"));
		star04_and_Above_Filter.click();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,100)");
		WebElement hP=driver.findElement(By.linkText("HP"));
		hP.click();
		JavascriptExecutor js1= (JavascriptExecutor)driver;
		js1.executeScript("window.scroll(0,200)");
		WebElement priceRange = driver.findElement(By.linkText("₹40,000 – ₹50,000"));
		priceRange.click();
	}
	@Test(priority=3)
	public void laptopSelect() throws InterruptedException
	{
		WebElement laptop1= driver.findElement(By.xpath("//img[@data-image-index=\"1\"]"));
		laptop1.click();
		
		
	}
	@Test(priority=4)
	public void addToBag()
		{
		Set<String> handles= driver.getWindowHandles();
		Iterator<String> it= handles.iterator();
		String parentID = (String)it.next();
		String childID = (String)it.next();
		driver.switchTo().window(childID);
	    driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		JavascriptExecutor js2= (JavascriptExecutor)driver;
		js2.executeScript("window.scroll(0,500)");
		WebElement addToCart= driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']"));
		addToCart.click();
	}


	}


