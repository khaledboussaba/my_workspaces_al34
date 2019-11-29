package tp.ds;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.LoggerFactory;

/*
 *  NB: cette implémentation de fonctionne bien qu'au sein d'un serveur d'application JEE (ex: Tomcat, Jboss, ...)
 */

//public class MyJndiDataSource implements MyDataSource {
public class MyJndiDataSource implements DataSource /* predefined javax.sql.DataSource*/ {
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyJndiDataSource.class);

	private String jndiName="java:comp/env/jdbc/myDB";//defaultValue
	
	
	
	public String getJndiName() {
		return jndiName;
	}


	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}



	public MyJndiDataSource() {
		super();
	}


	public MyJndiDataSource(String jndiName) {
		super();
		this.jndiName = jndiName;
	}


	@Override
	public Connection getConnection() throws SQLException{
		Connection cn=null;
		try {
			InitialContext ic = new InitialContext();
			javax.sql.DataSource ds = (javax.sql.DataSource) ic.lookup(jndiName);
			cn = ds.getConnection();
		} catch (Exception e) {
					logger.error("connection error:", e.getMessage());
					throw new RuntimeException("connection error:", e);
		}
		return cn;
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
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Connection getConnection(String arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
