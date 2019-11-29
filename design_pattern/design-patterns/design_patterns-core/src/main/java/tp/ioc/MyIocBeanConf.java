package tp.ioc;

import java.util.Properties;

/*
 * MyIocBeanConf représente en mémoire une configuration d'un composant 
 * configuré en xml via <bean id="idComp" class="package.ClassImplComp">
 *                         <property name="..." value="..." />
 *                         <property name="..." value="..." />
 *                         <property name="..." ref="..." />
 *                         <property name="..." ref="..." />
 *                      </bean>
 */

public class MyIocBeanConf {
	
	private String idBean; // valeur de id="..."
	private String implClass; //valeur de class="..."
	
	private Properties stringProps =new Properties();//sous-map des proprietes avec value="..."
	private Properties refProps=new Properties();//sous-map des proprietes avec ref="..." (injection)
	
	public String getIdBean() {
		return idBean;
	}
	public void setIdBean(String idBean) {
		this.idBean = idBean;
	}
	public String getImplClass() {
		return implClass;
	}
	public void setImplClass(String implClass) {
		this.implClass = implClass;
	}
	public Properties getStringProps() {
		return stringProps;
	}
	public void setStringProps(Properties stringProps) {
		this.stringProps = stringProps;
	}
	public Properties getRefProps() {
		return refProps;
	}
	public void setRefProps(Properties refProps) {
		this.refProps = refProps;
	}
	
	
	

}
