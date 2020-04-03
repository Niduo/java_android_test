package basicOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysql
{

	public static String sql(String num, String key) throws ClassNotFoundException, SQLException
	{
		String URL = "jdbc:mysql://192.168.1.30:3306/hoomxb28?useUnicode=true&amp;characterEncoding=utf-8";
		String USER = "root";
		String PASSWORD = "password";
		String valid = null;
		// 1.������������
		Class.forName("com.mysql.jdbc.Driver");
		// 2.������ݿ�����
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		// 3.ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ飨ʹ��Statement�ࣩ
		// String s="SELECT validCode FROM mobile_valid WHERE mobile=?";
		PreparedStatement pst = conn.prepareStatement(num);

		ResultSet rs = pst.executeQuery();
		// 4.�������ݿ�ķ��ؽ��(ʹ��ResultSet��)
		while (rs.next())
		{
			valid = rs.getString(key);
			System.out.println(valid);
		}
		// �ر���Դ
		rs.close();
		pst.close();
		conn.close();
		return valid;
	}
}