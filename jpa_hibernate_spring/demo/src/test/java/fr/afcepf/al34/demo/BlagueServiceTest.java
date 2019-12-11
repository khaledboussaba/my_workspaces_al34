package fr.afcepf.al34.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.afcepf.al34.demo.business.BlagueService;
import fr.afcepf.al34.demo.entity.Blague;

@SpringBootTest
public class BlagueServiceTest {
	
	@Autowired
	private BlagueService blagueService;
	
	@Test
	public void testTranfertNote() {
		Blague bA = new Blague(null,"blague A" , "texte blague A"); bA.setNote(2);
		blagueService.sauvegarderBlague(bA);
		Blague bB = new Blague(null,"blague B" , "texte blague B"); bB.setNote(3);
		blagueService.sauvegarderBlague(bB);
		
		blagueService.transfererNote(1, bA.getId(), bB.getId());
		
		Blague bArelu = blagueService.rechercherBlagueParId(bA.getId());
		System.out.println("apres bon transfert , bArelu="+bArelu.toString());
		Assertions.assertTrue(bArelu.getNote() == bA.getNote() - 1);
		
		Blague bBrelu = blagueService.rechercherBlagueParId(bB.getId());
		System.out.println("apres bon transfert , bBrelu="+bBrelu.toString());
		Assertions.assertTrue(bBrelu.getNote() == bB.getNote() + 1);
	}
	
	@Test
	public void testTranfertNoteAvecEchecVolontaire() {
		Blague bA = new Blague(null,"blague A" , "texte blague A"); bA.setNote(2);
		blagueService.sauvegarderBlague(bA);
		Blague bB = new Blague(null,"blague B" , "texte blague B"); bB.setNote(3);
		blagueService.sauvegarderBlague(bB);
		
		try {
			blagueService.transfererNote(1, bA.getId(), -5L); //la blague de id -5L n'exite pas 
			Assertions.fail("une exception aurait du remonter");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("echec normal : " + e.getMessage());
		}
		
		Blague bArelu = blagueService.rechercherBlagueParId(bA.getId());
		System.out.println("apres mauvais transfert , bArelu="+bArelu.toString());
		
		Blague bBrelu = blagueService.rechercherBlagueParId(bB.getId());
		System.out.println("apres mauvais transfert , bBrelu="+bBrelu.toString());
		
		Assertions.assertTrue(bArelu.getNote() == bA.getNote() );
		Assertions.assertTrue(bBrelu.getNote() == bB.getNote() );
	}

}
