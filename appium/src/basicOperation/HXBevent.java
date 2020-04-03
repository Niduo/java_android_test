package basicOperation;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class HXBevent
{
	//定义变量
	static Logger logger = Logger.getAnonymousLogger();
	
	
	
	
	
	//定义方法
	/**
	 * 等待方法
	 */
	public static void goSleep(int i)
	{
		// TODO Auto-generated method stub
		try
		{
			Thread.sleep(i);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 运行adb命令
	 */
	public static void excuteAdbShell(String s)
	{
		Runtime runtime = Runtime.getRuntime();
		try
		{
			runtime.exec(s);
		} catch (Exception e)
		{
			System.out.println("执行命令:" + s + "出错");
		}
	}

	// driver（就是把appiumdriver驱动对象也就是通常的driver）
	// during（滑动时间：这里是填写毫秒数，这里的 毫秒数越小 滑动的速度越快~ 一般设定在500~1000，如果你想快速滑动
	// 那就可以设置的更加小）
	// num（是指滑动的次数，本人在做相册 翻页测试什么的 滑动 或者滑动到列表底部。就直接输入次数就行了）
	/**
	 * 上滑
	 * 
	 * @param driver
	 * @param during
	 * @param num
	 */
	public static void swipeToUp(AppiumDriver driver, int during, int num)
	{
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		for (int i = 0; i < num; i++)
		{
			driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, during);
			goSleep(3000);
		}
	}

	/**
	 * 下拉
	 * 
	 * @param driver
	 * @param during
	 * @param num
	 */
	public static void swipeToDown(AppiumDriver driver, int during, int num)
	{
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		System.out.println(width);
		System.out.println(height);
		for (int i = 0; i < num; i++)
		{
			driver.swipe(width / 2, height / 4, width / 2, height * 3 / 4, during);
			goSleep(3000);
		}
	}

	/**
	 * 向左滑动
	 * 
	 * @param driver
	 * @param during
	 * @param num
	 */
	public static void swipeToLeft(AppiumDriver driver, int during, int num)
	{
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		for (int i = 0; i < num; i++)
		{
			driver.swipe(width * 3 / 4, height / 2, width / 4, height / 2, during);
			goSleep(3000);
		}
	}

	/**
	 * 向右滑动
	 * 
	 * @param driver
	 * @param during
	 * @param num
	 */
	public static void swipeToRight(AppiumDriver driver, int during, int num)
	{
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		for (int i = 0; i < num; i++)
		{
			driver.swipe(width / 4, height / 2, width * 3 / 4, height / 2, during);
			goSleep(3000);
		}
	}

	/**
	 * 解锁锁屏密码
	 */
	public static void unLockScreen(AppiumDriver driver)
	{
		if (driver.getPageSource().contains("android.view.View"))
		{
			System.out.println("需要解锁！");
			// 亮起屏幕
			excuteAdbShell("adb shell input keyevent 26");
			// 500毫秒快速上划2次 ，1次不能成功-swipe up
			swipeToUp(driver, 500, 2);

			// 图案解锁
			WebElement element = driver.findElementById("com.android.keyguard:id/lockPatternView");
			int startx = element.getLocation().getX(); // 获取控件的左上角坐标
			int starty = element.getLocation().getY();
			int height = element.getSize().getHeight(); // 获取控件的height、width
			int width = element.getSize().getWidth();

			int beginx = startx + width / 6;
			int beginy = starty + height / 6; // 起始点

			int xstep = width / 3; // 每次移动x,y的相对距离
			int ystep = height / 3;

			TouchAction action = new TouchAction(driver);
			action.press(beginx, beginy).moveTo(0, ystep).moveTo(0, ystep).moveTo(xstep, 0).moveTo(xstep, 0).release()
					.perform();

			if (driver.getPageSource().contains("com.android.deskclock:id/analog_appwidget"))
			{
				System.out.println("解锁成功！");
			} else
			{
				System.out.println("解锁失败！");
			}
		} else
		{
			System.out.println("无需解锁！");
		}
	}

	/**
	 * 图形转换成数字校验 1.Redis查询在对应数据库db2数据库里 2.获取token，如果后续token逻辑改变后 3. "captcha":
	 * "2083"对应字符串 4.现在不变写
	 */
	// public static void imageToNum()
	// {
	// // 原理：下载image文件，比较后转换成数字
	//
	// }

	/**
	 * 解锁手势密码
	 *
	 * // 画了一条斜线，全部用的坐标点不符合方法使用规范 // TouchAction action = new
	 * TouchAction(driver); // action.press(beginx, beginy).moveTo(beginx,
	 * beginy - ystep).moveTo(beginx, beginy - 2 * ystep).moveTo(2 * xstep,
	 * beginy - 2 * ystep).moveTo(3 * xstep, beginy -2 *
	 * ystep).release().perform(); // 测试画折现可以实现，但是超级不稳定 //action.press(beginx,
	 * beginy).moveTo(0, xstep).moveTo(0, xstep).moveTo(xstep, 0).moveTo(xstep,
	 * 0).release().perform(); //画折现稳定方法，每一步都需要等待一下，保持画的稳定和准确
	 * 
	 */
	@SuppressWarnings("unused")
	public static void unLockMenuScreen(AppiumDriver driver)
	{
		if (driver.getPageSource().contains("android.view.View"))
		{
			System.out.println("需要解锁");

			// 图案解锁
			WebElement elementUp = driver.findElementById("com.hoomsun.hxb:id/gestureUnlock");
			int heightUp = elementUp.getSize().getHeight(); // 获取上边控件的高
			int width = elementUp.getSize().getWidth(); // 获取上边控件的宽

			int xstep = width / 4; // 每次移动x,y的相对距离

			int beginx = width / 4; // 起始点x
			int beginy = heightUp / 2 - xstep; // 起始点y

			TouchAction action = new TouchAction(driver);
			action.press(beginx, beginy).waitAction(500).moveTo(0, xstep).waitAction(500).moveTo(0, xstep)
					.waitAction(500).moveTo(xstep, 0).waitAction(500).moveTo(xstep, 0).waitAction(500).release()
					.perform();
			goSleep(3000);// 等待新页面出现
			if (driver.getPageSource().contains("com.hoomsun.hxb:id/gestureUnlock"))
			{
				System.out.println("解锁失败！");
			} else
			{
				System.out.println("解锁成功！");
			}
		} else
		{
			System.out.println("无需解锁！");
		}
	}

	/**
	 * 输入带空格长的数字符号
	 * // 原理：
	 */



	public static void inputComsumeInfo(WebElement element, String cardnum) throws Exception
	{
		
		String actual = "";
		int i = 0;
		do
		{
			element.click();
			String[] str = cardnum.split("");
			for (int j = 0; j < str.length; j++)
			{
				pressKeyCode(Integer.parseInt(str[j]) + 7);
				// 如果当前长度超过预期的值说明多输入了一个数字，需要回删一个字符
				if (element.getText().replace(" ", "").length() > (j + 1))
				{
					logger.info("长度输入超过预期，需要回删一个字符");
					pressKeyCode(67);// delete
				}

				// if (j == str.length / 2)
				// {
				// element.click(); // 点击元素，确保与Appium有交互，否则会超时自动关闭session
				// pressKeyCode(123); //将光标移动到末尾
				// }

				if (j != str.length)
				{
					element.click(); // 点击元素，确保与Appium有交互，否则会超时自动关闭session
					pressKeyCode(123); // 将光标移动到末尾
				}
			}
			actual = element.getText().replace(" ", "");
			logger.info("第 " + (i + 1) + " 次输入,期望值为: " + cardnum + " 实际值为：" + actual + " " + cardnum.equals(actual));
			i++;
			if (!actual.equals(cardnum))
			{
				element.clear();
			}
		} while (!actual.equals(cardnum));
		assertEquals(actual, cardnum);
	}

	/**
	 * 模拟键盘输入
	 * 
	 * @param keyCode
	 */
	private static void pressKeyCode(int keyCode)
	{
		String cmdStr = "adb shell input keyevent " + keyCode + "";
		try
		{
			Runtime.getRuntime().exec(cmdStr);
			goSleep(1000);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static void assertEquals(String actual, String cardnum)
	{
		// TODO 自动生成的方法存根

	}
	public static void background(AppiumDriver driver,int j)
	{
		//页面点击
		System.out.println("app至于后台,3s后自动吊起app");
		for (int i = 1; i <= j; i++)
		{
			System.out.println(i);
			// app至于后台,3s后自动吊起app
			driver.runAppInBackground(3);
			System.out.println("至于后台次数：" + i);
		}

	}
}
