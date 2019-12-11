package fr.afcepf.al34.tp.web;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import fr.afcepf.al34.tp.entity.Client;
import fr.afcepf.al34.tp.entity.Compte;
import fr.afcepf.al34.tp.service.ClientService;
import fr.afcepf.al34.tp.service.CompteService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@RequestScoped
@Getter @Setter @NoArgsConstructor
public class ClientMBean {
	
	@Inject
	private ClientService clientService;
	
	List<Client> clients;
	
	@PostConstruct
	public void init() {
		this.clients = this.clientService.rechercherTousLesClient();
	}
	
}
