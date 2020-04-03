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
		// 1.加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		// 2.获得数据库链接
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		// 3.通过数据库的连接操作数据库，实现增删改查（使用Statement类）
		// String s="SELECT validCode FROM mobile_valid WHERE mobile=?";
		PreparedStatement pst = conn.prepareStatement(num);

		ResultSet rs = pst.executeQuery();
		// 4.处理数据库的返回结果(使用ResultSet类)
		while (rs.next())
		{
			valid = rs.getString(key);
			System.out.println(valid);
		}
		// 关闭资源
		rs.close();
		pst.close();
		conn.close();
		return valid;
	}
}