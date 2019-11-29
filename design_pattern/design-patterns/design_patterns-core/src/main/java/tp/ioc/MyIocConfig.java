package tp.ioc;

import java.util.HashMap;
import java.util.Map;

/*
 * MyIocConfig represente une config IOC chargee en mémoire
 * sous forme de map entre idDeBean et MyIocBeanConf 
 */

public class MyIocConfig {
	
	private Map<String,MyIocBeanConf> beanMap = new HashMap<String,MyIocBeanConf>();
	
	public void addBeanConf(String id,MyIocBeanConf beanConf) {
		beanMap.put(id, beanConf);
	}
	
	public MyIocBeanConf getBeanConf(String id)
	{
		return beanMap.get(id);
	}
	

}
