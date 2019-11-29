package fr.factory;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.annotation.MyInject;

public class MegaFactoryAvecInjection extends MegaFactory {
	
	static Logger logger = LoggerFactory.getLogger(MegaFactoryAvecInjection.class);
	
	public MegaFactoryAvecInjection() {
		super();
	}
	
	public static void injectDependenciesInObject(Object obj) {

		Class metaClass = obj.getClass();
		logger.trace("injection au sein de " + metaClass.getName());
		for(Field f : metaClass.getDeclaredFields()) {
			logger.trace("\t attribut =  " + f.getName() + " de type " + f.getType().getSimpleName());
			MyInject annotMyInject = f.getAnnotation(MyInject.class);
			if (annotMyInject != null) {
				Class typeDef = f.getType();
				Object instance = MegaFactory.getInstance().create(typeDef);
				//plus qu'a affecter instance en tant que nouvelle valeur de f
				//probleme a regler : f est souvent private
				f.setAccessible(true);
				try {
					f.set(obj, instance);//demander a changer la valeur de l'attribut f dans l'objet obj
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
