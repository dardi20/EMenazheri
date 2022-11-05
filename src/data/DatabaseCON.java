package data;

import java.sql.*;
import java.util.Properties;

public class DatabaseCON {

	Connection connection;

	DatabaseCON() throws SQLException, ClassNotFoundException {

		Class.forName("org.postgresql.Driver");

		String url = "jdbc:postgresql://localhost:5432/EMenazheri";

		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "dardi");
		this.connection = DriverManager.getConnection(url, props);

	}

	
}