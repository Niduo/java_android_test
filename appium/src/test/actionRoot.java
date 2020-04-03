package test;

import basicOperation.Settings;
import basicOperation.Case;
import basicOperation.HXBevent;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import io.appium.java_client.AppiumDriver;

//@SuppressWarnings("unused")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class actionRoot
{
	// ����
	@SuppressWarnings("static-access")
	AppiumDriver newdriver = new Settings().driver;

	@BeforeClass
	public static void setup() throws Exception
	{
		Settings.config();
	}

	@Test
	public void test00()
	{
		// welcome page
		Case.welcome();
	}

	@Test
	public void test01()
	{
		// ��¼
		Case.login("17012340001", "1234qwer");
	}


	@Test
	public void test03()
	{
		// ��ֵ
		Case.recharge("9.9");
		Case.recharge("10000");
	}


	@AfterClass
	public static void tearDown() throws Exception
	{
		Settings.driver.quit();
	}

}
