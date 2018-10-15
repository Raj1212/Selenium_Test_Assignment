package selenium_Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Selenium_Assignment {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\raazk\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://quickfuseapps.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS) ;
		CallModule CM= new CallModule(driver);
		CM.NewPage();
	//	driver.quit();
	}


}
