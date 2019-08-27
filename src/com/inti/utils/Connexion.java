package com.inti.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
private final static String dbURL="jdbc:mysql://localhost:3306/test";
private final static String username= "root";
private final static String password= "";

public static Connection conn;
public static void seConnecter () {
	try {
		conn= DriverManager.getConnection(dbURL, username, password);
				if (conn!= null) {
					System.out.println("Connecté");
				} else {
					System.out.println("Connexion échouée");
				}
	}
	catch (SQLException ex) {
		ex.printStackTrace();
	}
}
public static void seDeconnecter() {
	try {
		conn.close();
		System.out.println("Connexion fermée");
	}catch (SQLException ex) {
		ex.printStackTrace();
	}
}
}


