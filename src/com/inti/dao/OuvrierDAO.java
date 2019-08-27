package com.inti.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.inti.entities.Ouvrier;
import com.inti.utils.Connexion;

public class OuvrierDAO {
public  void ajouterOuvrier (Ouvrier ouvr) {
	try {
		Connexion.seConnecter();
		String sql = "insert into ouvrier(code,nom,prenom,dateNaissance,nbheure)" + "values (?,?,?,?,?)";
		PreparedStatement statement = Connexion.conn.prepareStatement(sql);
		statement.setLong(1,ouvr.getCode());
		statement.setString(2, ouvr.getNom());
		statement.setString(3,ouvr.getPrenom());
		statement.setString(4, ouvr.getDateNaissance());
		statement.setInt(5, ouvr.getNbheure());
		int rows = statement.executeUpdate();
		if (rows>0) {
			System.out.println("A new ouvrier was inserted successfully");
		}
				Connexion.seDeconnecter();
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
}
public static  List <Ouvrier> findAll(){      
	List <Ouvrier> listOuvrier= new ArrayList <>();
	try {
		Connexion.seConnecter();
		String sql="select * from ouvrier";
		PreparedStatement statement=Connexion.conn.prepareStatement(sql);
		ResultSet result = statement.executeQuery(); 
		while (result.next()) {
			listOuvrier.add(new Ouvrier (result.getLong(1),result.getString(2),result.getString(3), result.getString(4), result.getInt(5)));
		}
		Connexion.seDeconnecter();
	} catch (SQLException e) {
	}
	return listOuvrier;
}
public Ouvrier findOne(int nbrheure) {
	Ouvrier ouvr= null;
	try {
		Connexion.seConnecter();
		String sql = "Select * from ouvrier where nbrheure= ?";
		PreparedStatement statement= Connexion.conn.prepareStatement(sql);
		statement.setInt(5, nbrheure);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			ouvr = new Ouvrier (result.getLong(1),result.getString(2),result.getString(3), result.getString(4), result.getInt(5));
		}
		Connexion.seDeconnecter();
		
	
} catch (SQLException e) {
	e.printStackTrace();
}
	return ouvr;
}
public void supprimer (int nbrheure) {
	try  {
		Connexion.seConnecter();
		String sql = "delete from ouvrier where nbrheure = ?" ;
		PreparedStatement statement= Connexion.conn.prepareStatement(sql);
		statement.setInt(5, nbrheure);
		int rows = statement.executeUpdate();
		if(rows >0) {
			System.out.println("Le nb d'heure de l'ouvrier a bien été supprimé");
		}

		Connexion.seDeconnecter();
	} catch (SQLException e) {
		e.printStackTrace();
		
	}
}
public void modifier(Ouvrier ouvr) {
	try  {
		Connexion.seConnecter();
		String sql = "update ouvrier set code = ?,nom = ?, prenom=?, dateNaissance=?, nbrheure=?" ;
		PreparedStatement statement= Connexion.conn.prepareStatement(sql);
		statement.setLong(1,ouvr.getCode());
		statement.setString(2, ouvr.getNom());
		statement.setString(3,ouvr.getPrenom());
		statement.setString(4, ouvr.getDateNaissance());
		statement.setInt(5, ouvr.getNbheure());
		int rows = statement.executeUpdate();
		if(rows>0) {
			System.out.println("L'ouvrier a bien été modifié");
		}

		Connexion.seDeconnecter();
	}catch (SQLException e) {
		e.printStackTrace();
		
	}
		
}


}
