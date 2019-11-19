package fr.afcepf.al34.adopt.dog.test;

import java.util.Scanner;

import fr.afcepf.al34.adopt.dog.dao.UserDao;
import fr.afcepf.al34.adopt.dog.entities.User;

public class App {
	
	private static Scanner scanner = new Scanner(System.in); 
	
	public static void main(String[] args) {
		System.out.println("Bonjour Veuillez entrer vos informations : ");
		System.out.print("Votre prénom : ");
		String firstName = scanner.nextLine();
		System.out.print("Votre nom : ");
		String lastName = scanner.nextLine();
		System.out.print("Votre login : ");
		String login = scanner.nextLine();
		System.out.print("Votre mail : ");
		String email = scanner.nextLine();
		System.out.print("Votre mot de passe : ");
		String password = scanner.nextLine();
		User user = new User(firstName, lastName, login, email, password);
		UserDao dao = new UserDao();
		dao.insert(user);
	}

}
