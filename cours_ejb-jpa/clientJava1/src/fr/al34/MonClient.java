package fr.al34;

import java.util.Properties;

import javax.naming.InitialContext;

public class MonClient {

	public static void main(String[] args) {
		
		try {
			Properties props = new Properties();
			props.put("java.naming.factory.initial", "org.wildfly.naming.client.WildFlyInitialContextFactory");
			
			InitialContext context = new InitialContext(props);
			
			String nomEJB = "ejb:/ejbServeur1//MonEJB!fr.al34.MonEJBRemote";
			
			String nomEJB2 = "ejb:/ejbServeur1//MonDeuxiemEJB!fr.al34.MonDeuxiemEJBRemote";
			
			MonEJBRemote r = (MonEJBRemote) context.lookup(nomEJB);
			MonDeuxiemEJBRemote r2 = (MonDeuxiemEJBRemote) context.lookup(nomEJB2);
			
			System.out.println(r.sayHello());
			System.out.println(r2.sayBy());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}