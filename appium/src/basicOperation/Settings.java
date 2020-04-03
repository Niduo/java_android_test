package basicOperation;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;


public class Settings
{
	
	public static AppiumDriver driver;

	public static void config() throws Exception
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformName", "Android"); // ָ������ƽ̨
		cap.setCapability("deviceName", "QLXBBBB621806285"); // ָ�����Ի���ID,ͨ��adb����`adb G7SBY15122014222
		cap.setCapability("platformVersion", "5.1"); // devices`��ȡ

		// no need sign ��װʱ����apk������ǩ�������ú��б�Ҫ�������е�apk����ǩ��֮���޷�����ʹ��
		// �Զ���keystore��apk����ǩ��������ʵ�֣��������
		cap.setCapability("noSign", true);

		// no reinstall the test APP when each test
		cap.setCapability("noReset", true);
		// support Chinese֧����������
		cap.setCapability("unicodeKeyboard", true);
		// �������뷨ΪϵͳĬ��
		cap.setCapability("resetKeyboard", true);		

		// �������ȡ���İ�����Activity������Ϊֵ
		cap.setCapability("appPackage", "com.hoomsun.hxb");
		// A new session could not be created�Ľ������
		cap.setCapability("appWaitActivity", "com.hoomsun.hxb.module.welcome.WelcomeActivity");

		// ÿ������ʱ����session������ڶ��κ����лᱨ�����½�session
		cap.setCapability("sessionOverride", true);
		System.out.println("����session�ɹ�");
		// ��ʼ�� AppiumDriver
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		System.out.println("��ʼ�� AppiumDriver�����");
	}

}
