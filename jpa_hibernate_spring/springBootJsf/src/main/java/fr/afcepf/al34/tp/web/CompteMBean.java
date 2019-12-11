package fr.afcepf.al34.tp.web;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import fr.afcepf.al34.tp.entity.Compte;
import fr.afcepf.al34.tp.service.CompteService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@RequestScoped
@Getter @Setter @NoArgsConstructor
public class CompteMBean {
	
	private Long numClient;
	
	@Inject //ou @Autowired
	private CompteService compteService;
	
	private List<Compte> comptes; //à afficher dans h:dataTable
	
	@PostConstruct
	public void init() {
		this.comptes = this.compteService.rechercherTousLesComptes();
	}
	
}
