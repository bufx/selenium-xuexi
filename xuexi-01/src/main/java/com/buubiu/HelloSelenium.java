package com.buubiu;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @comment:
 * @author: buubiu
 * @create: 2021/10/21 15:08
 */
public class HelloSelenium {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
			"/Users/bufanxiang/myDoc/tools/IDEA/bufx/github/selenium-xuexi/xuexi-01/webdriver/chrome/95/chromedriver");
		WebDriver webDriver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
		try {
			webDriver.get("https://baidu.com");
			webDriver.findElement(By.name("wd")).sendKeys("buubiu" + Keys.ENTER);
			WebElement firstResult = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3")));
			System.out.println(firstResult.getAttribute("textContent"));
		} finally {
			webDriver.quit();
		}
	}

}
