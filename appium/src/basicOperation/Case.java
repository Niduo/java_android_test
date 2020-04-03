package basicOperation;
import java.sql.SQLException;

import org.openqa.selenium.WebElement;

import basicOperation.HXBevent;
import io.appium.java_client.AppiumDriver;

public class Case {
	static AppiumDriver newdriver=new Settings().driver;
	static String message,user_id,idNo;
	static boolean result;
	
	public static void welcome()
	{
		System.out.println("******��ӭҳ******");
		HXBevent.goSleep(5000);
		// welcome page
		HXBevent.swipeToLeft(newdriver, 500, 1);
		HXBevent.swipeToLeft(newdriver, 500, 1);
		HXBevent.swipeToLeft(newdriver, 500, 1);
		HXBevent.swipeToLeft(newdriver, 500, 1);
		// entered into APP,press ��������
		newdriver.findElementById("com.hoomsun.hxb:id/ensure").click();
		HXBevent.goSleep(2000);
		// ϵͳȨ��
		try {
			WebElement allow = newdriver.findElementById("com.android.packageinstaller:id/permission_allow_button");
			if (allow != null)
			{
				allow.click();
				HXBevent.goSleep(2000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// entered into APP,press �ݲ�����
		try {
			WebElement update = newdriver.findElementById("com.hoomsun.hxb:id/left_btn");
			if (update != null)
			{
				update.click();
				HXBevent.goSleep(2000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		
		// ��������
		try {
			WebElement newUser = newdriver.findElementById("com.hoomsun.hxb:id/cancel");
			if (newUser != null)
			{
				newUser.click();
				HXBevent.goSleep(2000);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
//		HXBevent.background(newdriver, 10);
		
	}
//��¼
	public static boolean login(String mobile,String password)
	{

		System.out.println("��¼");
		try {
			newdriver.findElementById("com.hoomsun.hxb:id/home_sign_in_up").click();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/login_userName").clear();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/login_userName").sendKeys(mobile);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/login_password").sendKeys(password);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/login_button").click();
		HXBevent.goSleep(5000);
		String test=newdriver.findElementById("com.hoomsun.hxb:id/home_sign_in_up").getText();
		String test1="ע�� / ��¼";
		if (test.equals(test1)) {
			System.out.println("��¼ʧ��");
			result = false;
		}else {
			System.out.println("��¼�ɹ�");
			result = true;
		}
		return result;

	}
//����
	public static void sign_in(String name,String idno,String password,String bankno,String mobile) throws Exception
	{

		System.out.println("����");
		HXBevent.goSleep(5000);
		newdriver.sendKeyEvent(4);
		HXBevent.goSleep(2000);
		newdriver.findElementById("com.hoomsun.hxb:id/home_sign_in_up").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/success_safe_verify").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/safe_name").sendKeys(name);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/safe_identity_code").sendKeys(idno);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/safe_payment_password").sendKeys(password);
		HXBevent.goSleep(1000);		
		HXBevent.inputComsumeInfo(newdriver.findElementById("com.hoomsun.hxb:id/ed_bankNumber"), bankno);
		HXBevent.goSleep(1000);
		HXBevent.swipeToUp(newdriver, 500, 1);
		newdriver.findElementById("com.hoomsun.hxb:id/ed_phoneNumber").sendKeys(mobile);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/safe_confirm").click();
		String test=newdriver.findElementById("com.hoomsun.hxb:id/home_sign_in_up").getText();
		String test1="������ͨ����˻�";
		if (test.equals(test1)) {
			System.out.print("����ʧ��");
		}else {
			System.out.print("�����ɹ�");
		}

	}
//��
	public static void bind_card(String bankno,String mobile) throws Exception
	{

		System.out.println("��");
		HXBevent.goSleep(5000);
		newdriver.sendKeyEvent(4);
		HXBevent.goSleep(2000);
		newdriver.findElementById("com.hoomsun.hxb:id/tab_user").click();
		HXBevent.goSleep(1000);	
		newdriver.findElementById("com.hoomsun.hxb:id/user_account").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/tv_userBankCardInfo").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/bankNum_bindCard");
		HXBevent.goSleep(1000);
		HXBevent.inputComsumeInfo(newdriver.findElementById("com.hoomsun.hxb:id/bankNum_bindCard"), bankno);
		HXBevent.goSleep(1000);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/phoneNum_bindCard").sendKeys(mobile);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/safe_confirm").click();
		String test=newdriver.findElementById("com.hoomsun.hxb:id/home_sign_in_up").getText();
		String test1="�����п�";
		if (test.equals(test1)) {
			System.out.print("��ʧ��");
		}else {
			System.out.print("�󿨳ɹ�");
		}

	}
//��ֵ
	@SuppressWarnings("unused")
	public static void recharge(String money)
	{

		System.out.println("��ֵ");
		HXBevent.goSleep(5000);
		newdriver.sendKeyEvent(4);
		HXBevent.goSleep(2000);
		newdriver.findElementById("com.hoomsun.hxb:id/tab_user").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/user_recharge").click();
		HXBevent.goSleep(5000);
		newdriver.findElementById("com.hoomsun.hxb:id/recharge_value").sendKeys(money);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/submit_btn").click();
		HXBevent.goSleep(1000);
//		try {
//			message = Mysql.sql("SELECT validCode FROM mobile_valid WHERE mobile="+mobile,"validCode");
//		} catch (ClassNotFoundException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO �Զ����ɵ� catch ��
//			e.printStackTrace();
//		}
		newdriver.findElementById("com.hoomsun.hxb:id/dialog_imput_sms").sendKeys("000000");
		HXBevent.goSleep(1000);
		while (newdriver.getPageSource().contains("com.hoomsun.hxb:id/confirmBtn"))
		{
			newdriver.findElementById("com.hoomsun.hxb:id/confirmBtn").click();
		}
		HXBevent.goSleep(5000);
		String test=newdriver.findElementById("com.hoomsun.hxb:id/tv_resultTitle").getText();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/tv_keepRechange").click();
		String test1="��ֵ�ɹ�";
		if(test1.equals(test)){
			System.out.println("��ֵ�ɹ�");
		} else{
			System.out.println("��ֵʧ��");
		}
				
	}
//����
	public static void cash(String money,String mobile)
	{

		System.out.println("����");
		HXBevent.goSleep(5000);
		newdriver.sendKeyEvent(4);
		HXBevent.goSleep(2000);
		newdriver.findElementById("com.hoomsun.hxb:id/tab_user").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/user_withdraw").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/with_draw_value").sendKeys(money);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/submit_btn").click();
		HXBevent.goSleep(1000);
		try {
			message = Mysql.sql("SELECT validCode FROM mobile_valid WHERE mobile="+mobile,"validCode");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		newdriver.findElementById("com.hoomsun.hxb:id/dialog_imput_sms").sendKeys(message);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/confirmBtn").click();
		HXBevent.goSleep(5000);
		String test=newdriver.findElementByClassName("android.widget.TextView").getText();
		String test1="��������������";
		if(test1.equals(test)){
			System.out.println("���ֳɹ�");
		} else{
			System.out.println("����ʧ��");
		}	
	}
//����ƻ�
	public static void buy(int type,String money,String password)
	{

		System.out.println("����ƻ�");
		HXBevent.goSleep(2000);
		newdriver.sendKeyEvent(4);
		HXBevent.goSleep(2000);
		newdriver.findElementById("com.hoomsun.hxb:id/tab_plan_and_loan").click();
		HXBevent.goSleep(2000);
		newdriver.findElementsByClassName("android.support.v7.app.ActionBar$Tab").get(type).click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/state").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/submit_btn").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/button_money_to_edit").sendKeys(money);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/submit_btn").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/inputView").sendKeys(password);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/confirmBtn").click();
		HXBevent.goSleep(1000);
		String test=newdriver.findElementById("com.hoomsun.hxb:id/message_tv").getText();
		String test1="����ɹ�";
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/topBar_leftImg_id").click();
		if(test1.equals(test)){
			System.out.println("����ɹ�");
		} else{
			System.out.println("����ʧ��");
		}	
	}
//��ֵ����
	public static void recharge_buy(int type,String money,String password,String mobile)
	{

		System.out.println("��ֵ����");
		HXBevent.goSleep(5000);
		newdriver.sendKeyEvent(4);
		HXBevent.goSleep(2000);
		newdriver.findElementById("com.hoomsun.hxb:id/tab_plan_and_loan").click();
		HXBevent.goSleep(2000);
		newdriver.findElementsByClassName("android.support.v7.app.ActionBar$Tab").get(type).click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/state").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/submit_btn").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/button_money_to_edit").sendKeys(money);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/submit_btn").click();
		HXBevent.goSleep(5000);
		try {
			message = Mysql.sql("SELECT validCode FROM mobile_valid WHERE mobile="+mobile,"validCode");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		newdriver.findElementById("com.hoomsun.hxb:id/dialog_imput_sms").sendKeys(message);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/confirmBtn").click();
		HXBevent.goSleep(5000);
		String test=newdriver.findElementById("com.hoomsun.hxb:id/message_tv").getText();
		String test1="����ɹ�";
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/topBar_leftImg_id").click();
		if(test1.equals(test)){
			System.out.println("����ɹ�");
		} else{
			System.out.println("����ʧ��");
		}
		
	}
//�޸��ֻ���
	public static void revise_mobile(String mobile,String newmobile,String password)
	{

		System.out.println("�޸��ֻ���");
		HXBevent.goSleep(5000);
		newdriver.sendKeyEvent(4);
		HXBevent.goSleep(2000);
		newdriver.findElementById("com.hoomsun.hxb:id/tab_user").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/user_account").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/account_safe").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/bind_mobile").click();
		if (newdriver.getPageSource().contains("com.hoomsun.hxb:id/id_card_view")) {
			HXBevent.goSleep(1000);
			try {
				user_id = Mysql.sql("SELECT userId FROM user_ WHERE mobile="+mobile,"userId");
				idNo = Mysql.sql("SELECT idNo FROM idcard_info WHERE user_="+user_id,"idNo");
			} catch (ClassNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			newdriver.findElementById("com.hoomsun.hxb:id/id_card_view").sendKeys(idNo);
			HXBevent.goSleep(1000);
		}
		newdriver.findElementById("com.hoomsun.hxb:id/getVerifyCodeTv").click();
		HXBevent.goSleep(1000);
		try {
			message = Mysql.sql("SELECT validCode FROM mobile_valid WHERE mobile="+mobile,"validCode");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		newdriver.findElementById("com.hoomsun.hxb:id/verifyCodeEt").sendKeys(message);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/submit_btn").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/new_mobile_et").sendKeys(newmobile);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/getVerifyCodeTv").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/dialog_imput_captcha").sendKeys("ͼ����֤��");
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/confirmBtn").click();
		HXBevent.goSleep(1000);
		try {
			message = Mysql.sql("SELECT validCode FROM mobile_valid WHERE mobile="+newmobile,"validCode");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		newdriver.findElementById("com.hoomsun.hxb:id/verifyCodeEt").sendKeys(message);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/submit_btn").click();
		HXBevent.goSleep(1000);
		boolean a=login(newmobile, password);
		if(a){
			System.out.println("�޸��ֻ��ųɹ�");
		} else{
			System.out.println("�޸��ֻ���ʧ��");
		}
		
	}
//�޸ĵ�¼����
	public static void revise_password(String mobile,String old_pass,String new_pass)
	{

		System.out.println("�޸ĵ�¼����");
		HXBevent.goSleep(5000);
		newdriver.sendKeyEvent(4);
		HXBevent.goSleep(2000);
		newdriver.findElementById("com.hoomsun.hxb:id/tab_user").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/user_account").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/account_safe").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/notify_login_password").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/old_pass").sendKeys(old_pass);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/pass").sendKeys(new_pass);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/submit_btn").click();
		HXBevent.goSleep(1000);
		boolean a=login(mobile, new_pass);
		if(a){
			System.out.println("�޸ĵ�¼����ɹ�");
		} else{
			System.out.println("�޸ĵ�¼����ʧ��");
		}
		
	}
//�޸Ľ�������
	public static void revise_cash_password(String mobile,String cash_password)
	{

		System.out.println("�޸Ľ�������");
		HXBevent.goSleep(5000);
		newdriver.sendKeyEvent(4);
		HXBevent.goSleep(2000);
		newdriver.findElementById("com.hoomsun.hxb:id/tab_user").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/user_account").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/account_safe").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/notify_recharge_password").click();
		HXBevent.goSleep(1000);
		try {
			user_id = Mysql.sql("SELECT userId FROM user_ WHERE mobile="+mobile,"userId");
			idNo = Mysql.sql("SELECT idNo FROM idcard_info WHERE user_="+user_id,"idNo");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		newdriver.findElementById("com.hoomsun.hxb:id/id_card_view").sendKeys(idNo);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/getVerifyCodeTv").click();
		HXBevent.goSleep(1000);
		try {
			message = Mysql.sql("SELECT validCode FROM mobile_valid WHERE mobile="+mobile,"validCode");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		newdriver.findElementById("com.hoomsun.hxb:id/verifyCodeEt").sendKeys(message);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/submit_btn").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/inputView").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/inputView").sendKeys(cash_password);
		HXBevent.goSleep(1000);
		if(newdriver.getPageSource().contains("com.hoomsun.hxb:id/inputView")){
			System.out.println("�޸Ľ�������ʧ��");
		} else{
			System.out.println("�޸Ľ�������ɹ�");
			newdriver.findElementById("com.hoomsun.hxb:id/topBar_leftImg_id").click();
			HXBevent.goSleep(1000);
			newdriver.findElementById("com.hoomsun.hxb:id/topBar_leftImg_id").click();
			HXBevent.goSleep(1000);
		}		
	}
//�޸���������
	public static void revise_gesture(String password)
	{

		System.out.println("�޸���������");
		HXBevent.goSleep(5000);
		newdriver.sendKeyEvent(4);
		HXBevent.goSleep(2000);
		newdriver.findElementById("com.hoomsun.hxb:id/tab_user").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/user_account").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/account_safe").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/notify_gesture_password").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/edit_loginPass").sendKeys(password);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/submit_btn").click();
		HXBevent.goSleep(1000);

	}
//������������
//���õ�¼����	
	public static void login_forget(String mobile,String password)
	{

		System.out.println("���õ�¼����");
		HXBevent.goSleep(5000);
		newdriver.sendKeyEvent(4);
		HXBevent.goSleep(2000);
		newdriver.findElementById("com.hoomsun.hxb:id/tab_user").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/login_forget").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/forget_number").sendKeys(mobile);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/forget_btn").click();
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/dialog_imput_captcha").sendKeys("ͼ����֤��");
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/confirmBtn").click();
		HXBevent.goSleep(1000);
		try {
			message = Mysql.sql("SELECT validCode FROM mobile_valid WHERE mobile="+mobile,"validCode");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		newdriver.findElementById("com.hoomsun.hxb:id/verifyCodeEt").sendKeys(message);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/sms_password").sendKeys(password);
		HXBevent.goSleep(1000);
		newdriver.findElementById("com.hoomsun.hxb:id/sms_confirm").click();
		HXBevent.goSleep(1000);
		boolean a=login(mobile, password);
		if(a){
			System.out.println("���õ�¼����ɹ�");
		} else{
			System.out.println("���õ�¼����ʧ��");
		}		
	}
//ҳ����(Ԫ��Ψһ)
	public static void clik(String page,String element)
	{

		System.out.println(page);
		HXBevent.goSleep(5000);
		newdriver.findElementById(element).click();
		HXBevent.goSleep(5000);
		if(newdriver.getPageSource().contains(element)){
			System.out.println("���ʧ��");
		} else{
			System.out.println("����ɹ���ҳ����ת");
		}
	}
//ҳ����(Ԫ�ز�Ψһ)
	public static void cliks(String page,int i,String element)
	{

		System.out.println(page);
		HXBevent.goSleep(5000);
		newdriver.findElementsByClassName(element).get(i).click();
		HXBevent.goSleep(5000);
		if(newdriver.getPageSource().contains(element)){
			System.out.println("���ʧ��");
		} else{
			System.out.println("����ɹ���ҳ����ת");
		}
	}

	
}
