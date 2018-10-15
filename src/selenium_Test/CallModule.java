package selenium_Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CallModule{
	private static  WebDriver driver;
	private static Actions act;
	public static int xoff=650, yoff=50,i=2;

	static String NodeID="//*[starts-with(@id,'node-')]";
	static String RecID="//*[starts-with(@id,'rec-')]";
	public CallModule(WebDriver driver) {
		CallModule.driver=driver;
		CallModule.act=new Actions(driver);
	}

	public  void  NewPage() {

		driver.findElement(By.id("link-create")).click();
		By locator = By.xpath("//button[text()=\"Let's get started!\"]");
		Func.Wait2(locator,driver);
		driver.findElement(locator).click();
		driver.findElement(By.id("add-page")).click();
		driver.findElement(By.cssSelector("input.indented.submitonenter")).sendKeys("Test"+"\n");
		Messaging();

	}

	private  void Messaging() {

		driver.findElement(By.xpath("//a[text()[contains(.,'Messaging')]]")).click();
		Send_SMS();
	}
	private   void Send_SMS()

	{
		WebElement Start = driver.findElement(By.id("module-1"));
		WebElement SendSMS=driver.findElement(By.xpath("//li[text()[contains(.,'Send an SMS')]]"));		
		act.dragAndDropBy(SendSMS, 1000,-125).build().perform();
		By PN = By.name("phone_constant");
		Func.Wait2(PN,driver);
		WebElement SMS = driver.findElement(By.id("module-2"));
		WebElement StartNode = Start.findElement(By.xpath("//div[@id='module-1']"+NodeID));
		WebElement SMSRec = SMS.findElement(By.xpath(RecID));
		List<WebElement> SMSNode = SMS.findElements(By.xpath("//div[@id='module-2']"+NodeID));
		act.dragAndDrop(StartNode, SMSRec).build().perform();
		SMS.findElement(PN).sendKeys("9020827384");
		SMS.findElement(By.name("message_phrase[]")).sendKeys(" Hire  Me");
		Send_Mail(SMSNode);
		Exit(SMSNode.get(0));
	}
	private  void Send_Mail(List<WebElement> SMSNode)

	{
		WebElement SendEmail= driver.findElement(By.xpath("//li[text()[contains(.,'Send an Email')]]"));
		act.dragAndDropBy(SendEmail, 300,40).build().perform();
		By SMTP = By.name("smtp_url");
		Func.Wait2(SMTP,driver);
		WebElement MAIL = driver.findElement(By.id("module-3"));
		List<WebElement> EmailNode = driver.findElements(By.xpath("//div[@id='module-3']"+NodeID));
		WebElement EmailRec = MAIL.findElement(By.xpath("//div[@id='module-3']"+RecID));
		act.dragAndDrop(SMSNode.get(1), EmailRec).build().perform();

		driver.findElement(SMTP).sendKeys("plivo.com");
		driver.findElement(By.name("port")).sendKeys("8888");
		driver.findElement(By.name("username")).sendKeys("Raj");
		driver.findElement(By.name("from_constant")).sendKeys("raazkr1212@gmail.com");
		driver.findElement(By.name("to_constant")).sendKeys("Rahul@plivo.com");
		driver.findElement(By.name("subject_constant")).sendKeys("SDET JOB_PROFILE");
		driver.findElement(By.name("cc_constant")).sendKeys("shreya@plivo.com");
		driver.findElement(By.name("password")).sendKeys("Abcd");
		MAIL.findElement(By.name("message_phrase[]")).sendKeys("Hello again, Hire me.:)");
		Basic();
		Func.Loop(EmailNode);
	}
	private static void Basic() {
		driver.findElement(By.xpath("//a[text()[contains(.,'Basic')]]")).click();
	}
	public static  void Exit(WebElement node) {

		WebElement From3= driver.findElement(By.xpath("//li[text()[contains(.,'Hang Up or Exit')]]"));
		act.dragAndDropBy(From3, xoff, yoff).build().perform();
		By ExitLocator=By.xpath("//div[text()[contains(.,'Exit App')]]");
		Func.Wait2(ExitLocator,driver);;
		List<WebElement> ExitRec = driver.findElements(By.xpath(RecID));

		act.dragAndDrop(node,ExitRec.get(i)).build().perform();
		xoff+=100;
		yoff+=100;
		i++;

	}
}
