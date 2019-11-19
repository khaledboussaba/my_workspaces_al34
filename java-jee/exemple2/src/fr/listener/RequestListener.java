package fr.listener;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {

	private static final Logger LOG = Logger.getLogger("RequestListener");

	public void requestInitialized(ServletRequestEvent event)  { 
		HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
		request.setAttribute("startTime", System.currentTimeMillis());
	}

	public void requestDestroyed(ServletRequestEvent sre)  { 
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		long startTime = (Long) request.getAttribute("startTime");
		LOG.log(Level.INFO, "++++++++++++++ {0} millliseconds", System.currentTimeMillis() - startTime);
	}


}