package tp.util;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.LoggerFactory;

public class MyPropertiesUtil {
	
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(MyPropertiesUtil.class);
	
	public static Properties propertiesFromCPRelativePathFile(String relativePathFile)
	{
		Properties props = new Properties();
		try {
			InputStream inStream =  Thread.currentThread().getContextClassLoader().getResourceAsStream(relativePathFile);
			props.load(inStream);
		} catch (Exception e) {
			logger.error("cannot load properties file : " + relativePathFile , e.getMessage() );
		}
		return props;
	}
	
	public static String propertyValueFromEntryOfPropertyFile(String relativePathPropertyFile,String propertyName)
	{
		String propValue=null;
		Properties props = propertiesFromCPRelativePathFile(relativePathPropertyFile);
		propValue=props.getProperty(propertyName);
		return propValue;
	}


}
