package docker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class B2 {

	RemoteWebDriver driver;
	String varURL = "http://www.google.com";
	String varHUB = "http://localhost:4444";
	//String varHUB = "http://172.17.0.2:4444";

	@BeforeTest
	public void SetUp() throws MalformedURLException {
		DesiredCapabilities objDesiredCapabilities = new DesiredCapabilities();
		objDesiredCapabilities.setBrowserName("chrome");
		objDesiredCapabilities.setPlatform(Platform.LINUX);
		//ChromeOptions objChromeOptions = new ChromeOptions();
		driver = new RemoteWebDriver(new URL(varHUB), objDesiredCapabilities);
	}

	@Test
	public void DockerTest4() {
		driver.get(varURL);
		System.out.println("DockerTest4 In Chrome..");
		System.out.println(driver.getTitle());
	}

}
