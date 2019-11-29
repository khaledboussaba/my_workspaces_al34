package tp.ds;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.slf4j.LoggerFactory;

import tp.util.MyPropertiesUtil;

public class MyParamDataSource implements DataSource {
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyParamDataSource.class);

	private String jdbcDriver;//"com.mysql.jdbc.Driver" ou "org.h2.Driver" ou ...
	private String dbUrl;//"jdbc:mysql://localhost/test_designPatterns_db" ou "jdbc:h2:~/test_designPatterns_db" ou ...
	private String username; // "root" ou "sa" ou ...
	private String password;// "root" ou "" ou "formation" ou ...
	
	/*
	// in old version (without ioc) only:
	private void initDbProperties(){
		Properties props= MyPropertiesUtil.propertiesFromCPRelativePathFile("myDB.properties");
		logger.info("database properties extracted from myDB.properties if not already setted");
		if(jdbcDriver==null) jdbcDriver = props.getProperty("jdbcDriver");
		if(dbUrl==null) dbUrl = props.getProperty("url");
		if(username==null) username = props.getProperty("username");
		if(password==null) password = props.getProperty("password");
	}
	*/
	
	@Override
	public Connection getConnection() throws SQLException{
		/*
		// in old version (without ioc) only:
		if(jdbcDriver==null || dbUrl == null || username ==null || password ==null){
		    initDbProperties();
		    logger.info("jdbcDriver="+jdbcDriver + " dbUrl="+dbUrl + " username=" + username + " password=" + password);
		}
		*/
		
		Connection cn=null;
		try {
			Class.forName(jdbcDriver);
			cn = DriverManager.getConnection(dbUrl,username,password);
		} catch (ClassNotFoundException e) {
			logger.error("cannot load jdbc driver class", e);
			throw new RuntimeException("cannot load jdbc driver class:", e);
		} catch (SQLException e) {
			logger.error("cannot connect to database", e);
			throw new RuntimeException("cannot connect to database:", e);
		}
		return cn;
	}
	
	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
