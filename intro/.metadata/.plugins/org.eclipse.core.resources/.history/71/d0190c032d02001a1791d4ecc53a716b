package fr.afcepf.al34.adopt.dog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.afcepf.al34.adopt.dog.entities.User;
import fr.afcepf.al34.authenticator.AuthenticationManager;
import fr.afcepf.al34.authenticator.Credentials;
import fr.afcepf.al34.authenticator.exceptions.AuthenticationException;

public class UserDao {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	Connection connection = null;
	
	private static final String URL = "jdbc:mysql://localhost:3306/adopte_un_chien?serverTimezone=UTC";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "root";
	
	private static final String REQ_ADD = "INSERT INTO user (last_name, first_name, email, login, hashed_password, salt) "
										+ "VALUES (?, ?, ?, ?, ?, ?)";
	
	private static final String REQ_UNIQUE_LOGIN = "SELECT COUNT(login) from user WHERE login = ?";
	private static final String REQ_UNIQUE_EMAIL = "(SELECT COUNT(email) from user where email = ?) as count2";


	public void insert(User user) {
		Credentials credentials = new Credentials(user.getLogin());
		try {
			AuthenticationManager.initializeCredentials(user.getHashPassword(), credentials);
		} catch (AuthenticationException e1) {
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			
			PreparedStatement pstm = connection.prepareStatement(REQ_ADD);
			pstm.setString(1, user.getLastName());
			pstm.setString(2, user.getFirstName());
			pstm.setString(3, user.getEmail());
			pstm.setString(4, credentials.getLogin());
			pstm.setString(5, credentials.getHashedPassword());
			pstm.setString(6, credentials.getSalt());
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean isUnique(String login, String email) {
		
		try {
			connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			PreparedStatement pstm1 = connection.prepareStatement(REQ_UNIQUE_LOGIN);
			pstm1.setString(1, login);
			ResultSet rs1 = pstm1.executeQuery();
			
			
			rs1.getInt(1);
			
			PreparedStatement pstm2 = connection.prepareStatement(REQ_UNIQUE_EMAIL);
			pstm2.setString(1, email);
			ResultSet rs2 = pstm2.executeQuery();
			
			rs2.getInt(1);
			
			if (rs1.getInt(1) > 0 || rs2.getInt(1) > 0) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return true;
	}
	
}
