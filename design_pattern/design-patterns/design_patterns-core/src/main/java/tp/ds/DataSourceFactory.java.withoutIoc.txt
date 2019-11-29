package tp.ds;

import java.sql.Connection;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Singleton
 * Factory of DataSource
 */
public class DataSourceFactory {
	
	private static Logger logger = LoggerFactory.getLogger(DataSourceFactory.class);
	
	private static DataSourceFactory uniqueInstance = null;
	
	public synchronized static DataSourceFactory getInstance()	{
		if(uniqueInstance==null){
			uniqueInstance=new DataSourceFactory();
			logger.debug("uniqueInstance=" + uniqueInstance.toString());
		}
		return uniqueInstance;
	}
	
		
	private DataSourceFactory()	{
		super();
	}
	
	public DataSource getDataSource(){
		DataSource ds =null;
		try {
			//tentative 1 en version JNDI (ideal en production):
			ds =  new MyJndiDataSource();
			Connection cn = ds.getConnection();//simple test connection possible ou pas (selon contexte)
			if(cn!=null) cn.close();
			logger.info("success connection test with MyJndiDataSource ");
		} catch (Exception e) {
			//tentative 2 en version DEV/PARAM (ideal en developpement/tests):
			ds =  new MyParamDataSource();	
			logger.info("failed connection test with MyJndiDataSource , use MyParamDataSource instead");
		}
		return ds;
	}


}
