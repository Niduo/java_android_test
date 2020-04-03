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
		cap.setCapability("platformName", "Android"); // 指定测试平台
		cap.setCapability("deviceName", "QLXBBBB621806285"); // 指定测试机的ID,通过adb命令`adb G7SBY15122014222
		cap.setCapability("platformVersion", "5.1"); // devices`获取

		// no need sign 安装时不对apk进行重签名，设置很有必要，否则有的apk在重签名之后无法正常使用
		// 自定义keystore对apk进行签名，不好实现，最好舍弃
		cap.setCapability("noSign", true);

		// no reinstall the test APP when each test
		cap.setCapability("noReset", true);
		// support Chinese支持中文输入
		cap.setCapability("unicodeKeyboard", true);
		// 重置输入法为系统默认
		cap.setCapability("resetKeyboard", true);		

		// 将上面获取到的包名和Activity名设置为值
		cap.setCapability("appPackage", "com.hoomsun.hxb");
		// A new session could not be created的解决方法
		cap.setCapability("appWaitActivity", "com.hoomsun.hxb.module.welcome.WelcomeActivity");

		// 每次启动时覆盖session，否则第二次后运行会报错不能新建session
		cap.setCapability("sessionOverride", true);
		System.out.println("创建session成功");
		// 初始化 AppiumDriver
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		System.out.println("初始化 AppiumDriver已完成");
	}

}
