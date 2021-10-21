package com.buubiu;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @comment:
 * @author: buubiu
 * @create: 2021/10/21 15:08
 */
public class HelloSeleniumNoGUI {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
			"/Users/bufanxiang/myDoc/tools/IDEA/bufx/github/selenium-xuexi/xuexi-01/webdriver/chrome/95/chromedriver");
		WebDriver webDriver = null;
		try {
			String url = "https://baidu.com";
			ChromeOptions chromeOptions = new ChromeOptions();
			//设置 chrome 的无头模式
			chromeOptions.setHeadless(Boolean.TRUE);
			//启动一个 chrome 实例
			webDriver = new ChromeDriver(chromeOptions);
			//访问网址
			webDriver.get(url);

			webDriver.findElement(By.name("wd")).sendKeys("buubiu" + Keys.ENTER);
			WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
			WebElement firstResult = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h3")));
			System.out.println(firstResult.getAttribute("textContent"));
		}finally {
			webDriver.quit();
		}
	}

}
