package fr.afcepf.al34.adopt.dog.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSouceFactory {

	public static DataSource getDataSource() {
		MysqlDataSource ds = null;

		try {
			InputStream stream = DataSouceFactory.class.getClassLoader().getResourceAsStream("db.properties");
			Properties props = new Properties();
			props.load(stream);
			ds = new MysqlDataSource();
			ds.setURL(props.getProperty("MYSQL_DB_URL"));
			ds.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			ds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ds;
	}

}
