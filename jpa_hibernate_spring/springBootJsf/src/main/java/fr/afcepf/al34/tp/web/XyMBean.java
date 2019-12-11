package fr.afcepf.al34.tp.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.afcepf.al34.tp.service.XyService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@RequestScoped
@Getter @Setter 
@NoArgsConstructor
public class XyMBean {
	
	private String data;
	
	private XyService xyService;
	
	public void init() {
		data="blabla";
	}
	
	
	

}
