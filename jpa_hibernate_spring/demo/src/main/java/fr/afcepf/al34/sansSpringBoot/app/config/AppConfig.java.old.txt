package fr.afcepf.al34.sansSpringBoot.app.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceConfig.class})
@ComponentScan({"fr.afcepf.al34.demo"})//pour trouver sous packages .dao , .business
                                     //avec @Autowired , @Service, @Component , ...
public class AppConfig {
	// cette classe remplace l'ancien fichier /mySpringConf.xml
}
