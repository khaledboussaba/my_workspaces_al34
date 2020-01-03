package fr.afcepf.al34.ws;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import fr.afcepf.al34.ws.service.ICalculTva;



@Configuration
@EnableAutoConfiguration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class CxfSoapConfig {

	@Autowired
    private ApplicationContext applicationContext;
	
	// Replaces the need for web.xml
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext context) {
        return new ServletRegistrationBean(new CXFServlet(), "/service/*");
    }
    
    @Autowired 
    private ICalculTva calculTva; //service spring interne
 
    // Replaces cxf-servlet.xml
    @Bean
    // <jaxws:endpoint id="tvaServiceEndpoint" implementor="#calcuTvaImpl" address="/calculTva"/>
    public EndpointImpl tvaServiceEndpoint() {
        Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);
        EndpointImpl endpoint = new EndpointImpl(bus, calculTva /* implementor */);
        endpoint.publish("/calculTva");
        //URL soap complete:
        //http://localhost:8080/springBootWsApp/service/calculTva
        //http://localhost:8080/springBootWsApp/service/calculTva?wsdl
        return endpoint;
    }
 

}
