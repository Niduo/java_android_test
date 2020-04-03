package basicOperation;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class HXBevent
{
	//�������
	static Logger logger = Logger.getAnonymousLogger();
	
	
	
	
	
	//���巽��
	/**
	 * �ȴ�����
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
	 * ����adb����
	 */
	public static void excuteAdbShell(String s)
	{
		Runtime runtime = Runtime.getRuntime();
		try
		{
			runtime.exec(s);
		} catch (Exception e)
		{
			System.out.println("ִ������:" + s + "����");
		}
	}

	// driver�����ǰ�appiumdriver��������Ҳ����ͨ����driver��
	// during������ʱ�䣺��������д������������� ������ԽС �������ٶ�Խ��~ һ���趨��500~1000�����������ٻ���
	// �ǾͿ������õĸ���С��
	// num����ָ�����Ĵ���������������� ��ҳ����ʲô�� ���� ���߻������б�ײ�����ֱ��������������ˣ�
	/**
	 * �ϻ�
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
	 * ����
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
	 * ���󻬶�
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
	 * ���һ���
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
	 * ������������
	 */
	public static void unLockScreen(AppiumDriver driver)
	{
		if (driver.getPageSource().contains("android.view.View"))
		{
			System.out.println("��Ҫ������");
			// ������Ļ
			excuteAdbShell("adb shell input keyevent 26");
			// 500��������ϻ�2�� ��1�β��ܳɹ�-swipe up
			swipeToUp(driver, 500, 2);

			// ͼ������
			WebElement element = driver.findElementById("com.android.keyguard:id/lockPatternView");
			int startx = element.getLocation().getX(); // ��ȡ�ؼ������Ͻ�����
			int starty = element.getLocation().getY();
			int height = element.getSize().getHeight(); // ��ȡ�ؼ���height��width
			int width = element.getSize().getWidth();

			int beginx = startx + width / 6;
			int beginy = starty + height / 6; // ��ʼ��

			int xstep = width / 3; // ÿ���ƶ�x,y����Ծ���
			int ystep = height / 3;

			TouchAction action = new TouchAction(driver);
			action.press(beginx, beginy).moveTo(0, ystep).moveTo(0, ystep).moveTo(xstep, 0).moveTo(xstep, 0).release()
					.perform();

			if (driver.getPageSource().contains("com.android.deskclock:id/analog_appwidget"))
			{
				System.out.println("�����ɹ���");
			} else
			{
				System.out.println("����ʧ�ܣ�");
			}
		} else
		{
			System.out.println("���������");
		}
	}

	/**
	 * ͼ��ת��������У�� 1.Redis��ѯ�ڶ�Ӧ���ݿ�db2���ݿ��� 2.��ȡtoken���������token�߼��ı�� 3. "captcha":
	 * "2083"��Ӧ�ַ��� 4.���ڲ���д
	 */
	// public static void imageToNum()
	// {
	// // ԭ������image�ļ����ȽϺ�ת��������
	//
	// }

	/**
	 * ������������
	 *
	 * // ����һ��б�ߣ�ȫ���õ�����㲻���Ϸ���ʹ�ù淶 // TouchAction action = new
	 * TouchAction(driver); // action.press(beginx, beginy).moveTo(beginx,
	 * beginy - ystep).moveTo(beginx, beginy - 2 * ystep).moveTo(2 * xstep,
	 * beginy - 2 * ystep).moveTo(3 * xstep, beginy -2 *
	 * ystep).release().perform(); // ���Ի����ֿ���ʵ�֣����ǳ������ȶ� //action.press(beginx,
	 * beginy).moveTo(0, xstep).moveTo(0, xstep).moveTo(xstep, 0).moveTo(xstep,
	 * 0).release().perform(); //�������ȶ�������ÿһ������Ҫ�ȴ�һ�£����ֻ����ȶ���׼ȷ
	 * 
	 */
	@SuppressWarnings("unused")
	public static void unLockMenuScreen(AppiumDriver driver)
	{
		if (driver.getPageSource().contains("android.view.View"))
		{
			System.out.println("��Ҫ����");

			// ͼ������
			WebElement elementUp = driver.findElementById("com.hoomsun.hxb:id/gestureUnlock");
			int heightUp = elementUp.getSize().getHeight(); // ��ȡ�ϱ߿ؼ��ĸ�
			int width = elementUp.getSize().getWidth(); // ��ȡ�ϱ߿ؼ��Ŀ�

			int xstep = width / 4; // ÿ���ƶ�x,y����Ծ���

			int beginx = width / 4; // ��ʼ��x
			int beginy = heightUp / 2 - xstep; // ��ʼ��y

			TouchAction action = new TouchAction(driver);
			action.press(beginx, beginy).waitAction(500).moveTo(0, xstep).waitAction(500).moveTo(0, xstep)
					.waitAction(500).moveTo(xstep, 0).waitAction(500).moveTo(xstep, 0).waitAction(500).release()
					.perform();
			goSleep(3000);// �ȴ���ҳ�����
			if (driver.getPageSource().contains("com.hoomsun.hxb:id/gestureUnlock"))
			{
				System.out.println("����ʧ�ܣ�");
			} else
			{
				System.out.println("�����ɹ���");
			}
		} else
		{
			System.out.println("���������");
		}
	}

	/**
	 * ������ո񳤵����ַ���
	 * // ԭ��
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
				// �����ǰ���ȳ���Ԥ�ڵ�ֵ˵����������һ�����֣���Ҫ��ɾһ���ַ�
				if (element.getText().replace(" ", "").length() > (j + 1))
				{
					logger.info("�������볬��Ԥ�ڣ���Ҫ��ɾһ���ַ�");
					pressKeyCode(67);// delete
				}

				// if (j == str.length / 2)
				// {
				// element.click(); // ���Ԫ�أ�ȷ����Appium�н���������ᳬʱ�Զ��ر�session
				// pressKeyCode(123); //������ƶ���ĩβ
				// }

				if (j != str.length)
				{
					element.click(); // ���Ԫ�أ�ȷ����Appium�н���������ᳬʱ�Զ��ر�session
					pressKeyCode(123); // ������ƶ���ĩβ
				}
			}
			actual = element.getText().replace(" ", "");
			logger.info("�� " + (i + 1) + " ������,����ֵΪ: " + cardnum + " ʵ��ֵΪ��" + actual + " " + cardnum.equals(actual));
			i++;
			if (!actual.equals(cardnum))
			{
				element.clear();
			}
		} while (!actual.equals(cardnum));
		assertEquals(actual, cardnum);
	}

	/**
	 * ģ���������
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
		// TODO �Զ����ɵķ������

	}
	public static void background(AppiumDriver driver,int j)
	{
		//ҳ����
		System.out.println("app���ں�̨,3s���Զ�����app");
		for (int i = 1; i <= j; i++)
		{
			System.out.println(i);
			// app���ں�̨,3s���Զ�����app
			driver.runAppInBackground(3);
			System.out.println("���ں�̨������" + i);
		}

	}
}
