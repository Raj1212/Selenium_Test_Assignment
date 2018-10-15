package selenium_Test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Func {

	public static void Loop(List<WebElement> Nodes) {		
		Iterator<WebElement> Node = Nodes.iterator();

		while(Node.hasNext()) {
			WebElement Node1= Node.next();
			CallModule.Exit(Node1);
		}
	}
	static void Wait2(By locator, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
