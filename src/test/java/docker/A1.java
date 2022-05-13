package docker;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class A1 {
	
	//Jenkins uname/pwd: srirammithra/webdriver1984

	RemoteWebDriver driver;
	String varURL = "http://www.google.com";
	String varHUB = "http://localhost:4444";
	//String varHUB = "http://172.17.0.2:4444";
	
	@BeforeSuite
	public void StartDocker() throws IOException, InterruptedException {
		StartDocker objStartDocker = new StartDocker();
		objStartDocker.StartFile();
	}
	
	@AfterSuite
	public void StopDocker() throws IOException, InterruptedException {
		StopDocker objStopDocker = new StopDocker();
		objStopDocker.StopFile();
	}

	@BeforeTest
	public void SetUp() throws MalformedURLException {
		DesiredCapabilities objDesiredCapabilities = new DesiredCapabilities();
		objDesiredCapabilities.setBrowserName("firefox");
		objDesiredCapabilities.setPlatform(Platform.LINUX);
		//ChromeOptions objChromeOptions = new ChromeOptions();
		driver = new RemoteWebDriver(new URL(varHUB), objDesiredCapabilities);
	}

	@Test
	public void DockerTest1() {
		driver.get(varURL);
		System.out.println("DockerTest1 In Firefox..");
		System.out.println(driver.getTitle());
	}

}
