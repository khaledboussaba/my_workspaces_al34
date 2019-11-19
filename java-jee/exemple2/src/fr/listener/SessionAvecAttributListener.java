package fr.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class SessionAvecAttributListener
 *
 */
@WebListener
public class SessionAvecAttributListener implements HttpSessionAttributeListener {

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         String attributeName = event.getName();
         Object attributeValue = event.getValue();
         System.out.println("Attribut ajouté : " + attributeName + " : " + attributeValue);
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    	String attributeName = event.getName();
        Object attributeValue = event.getValue();
        System.out.println("Attribut enlevé : " + attributeName + " : " + attributeValue);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    	String attributeName = event.getName();
        Object attributeValue = event.getValue();
        System.out.println("Attribut remplacé : " + attributeName + " : " + attributeValue);
    }
	
}
