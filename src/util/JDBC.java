package util;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC {
	static Connection connection=null;
	public static Connection getConnection() {
		try {
			if(connection==null || connection.isClosed()){
				Properties prop = new Properties(); 
				try {
					prop.load(new BufferedInputStream (JDBC.class.getResourceAsStream("jdbc.properties")));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					System.out.println("JDBC配置文件未找到！");
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("JDBC配置文件读取错误！");
				}
				String driver=prop.getProperty("driverClass","com.mysql.jdbc.Driver");
				String url=prop.getProperty("jdbcUrl", "jdbc:mysql://localhost:3306/authserver?userUnicode=true&characterEncoding=utf-8");
				String user = prop.getProperty("user","root");
				String pass=prop.getProperty("password", "root");
				try {
					Class.forName(driver);
					connection=DriverManager.getConnection(url, user, pass);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					System.out.println("JDBC驱动类未找到！");
				}
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeAll()
	{
		try {
			if(!JDBC.connection.isClosed()){connection.close();}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JDBC连接关闭失败！");
		}
	}
}
