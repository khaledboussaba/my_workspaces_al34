package fr.listener;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionListener {

	private static final Logger LOG = Logger.getLogger("SessionListener");
	
	private int sessionCounter = 0;
	
    public void sessionCreated(HttpSessionEvent se)  {
    	synchronized (this) {
    		sessionCounter++;			
		}
    	LOG.log(Level.INFO, "======>démarage session " + sessionCounter);
    }

    public void sessionDestroyed(HttpSessionEvent se)  {
    	synchronized (this) {
    		sessionCounter--;			
		}
    	LOG.log(Level.INFO, "======>fin session " + sessionCounter);
    }
	
}
