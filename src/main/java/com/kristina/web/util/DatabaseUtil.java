package com.kristina.web.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
	
	private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                InputStream inputStream = DatabaseUtil.class.getClassLoader().getResourceAsStream("database.properties");
                System.out.println("hasil input : " +inputStream);
                prop.load(inputStream);
                String driver = prop.getProperty("DB_DRIVER_CLASS");
                System.out.println(driver);
                String url = prop.getProperty("DB_URL");
                System.out.println(url);
                String user = prop.getProperty("DB_USERNAME");
                System.out.println(user);
                String password = prop.getProperty("DB_PASSWORD");
                System.out.println(password);
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }

}
