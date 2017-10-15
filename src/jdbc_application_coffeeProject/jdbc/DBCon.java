package jdbc_application_coffeeProject.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DBCon {
	private static final DBCon instance = new DBCon();
	private Connection connection;	

	public static DBCon getInstance() {
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}
	
	private DBCon() {
		Properties properties = getProperties("conf.properties");
		
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String pwd = properties.getProperty("pwd");
		
		try {
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	private Properties getProperties(String propertiesPath) {
		Properties properites = new Properties();
		InputStream is = ClassLoader.getSystemResourceAsStream(propertiesPath);
		
		try {
			properites.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properites;
	}
	
	
}
