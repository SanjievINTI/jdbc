package com.inti.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inti.entities.Entreprise;
import com.inti.utils.Connexion;

public class EntrepriseDAO {
	public void ajouterEntreprise (Entreprise ent) {
		try {
			Connexion.seConnecter();
			String sql = "insert into entreprise(code,libelle)" + "values (?,?)";
			PreparedStatement statement = Connexion.conn.prepareStatement(sql);
			statement.setLong(11,ent.getCode());
			statement.setString(12,ent.getLibelle());
			
			int rows = statement.executeUpdate();
			if (rows>0) {
				System.out.println("A new entreprise was inserted successfully");
			}
					Connexion.seDeconnecter();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	public List <Entreprise> findAll(){      
		List <Entreprise> listEntreprise= new ArrayList <>();
		try {
			Connexion.seConnecter();
			String sql="select * from entreprise";
			PreparedStatement statement=Connexion.conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery(); 
			while (result.next()) {
				listEntreprise.add(new Entreprise (result.getLong(11),result.getString(12)));
			}
			Connexion.seDeconnecter();
		} catch (SQLException e) {
		}
		return listEntreprise;
	}
	public Entreprise findOne(long code) {
		Entreprise ent= null;
		try {
			Connexion.seConnecter();
			String sql = "Select * from entreprise where code = ?";
			PreparedStatement statement= Connexion.conn.prepareStatement(sql);
			statement.setLong(11, code);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				ent = new Entreprise (result.getLong(11),result.getString(12));
			}
			Connexion.seDeconnecter();
			
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return ent;
	}
	public void supprimer (String libelle) {
		try  {
			Connexion.seConnecter();
			String sql = "delete from entreprise where code = ?" ;
			PreparedStatement statement= Connexion.conn.prepareStatement(sql);
			statement.setString(12, libelle);
			int rows = statement.executeUpdate();
			if(rows >0) {
				System.out.println("Le libelle de l'entreprise a bien été supprimé");
			}

			Connexion.seDeconnecter();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	public void modifier(Entreprise ent) {
		try  {
			Connexion.seConnecter();
			String sql = "update entreprise set code = ?,libelle = ?" ;
			PreparedStatement statement= Connexion.conn.prepareStatement(sql);
			statement.setLong(11,ent.getCode());
			statement.setString(12,ent.getLibelle());
			int rows = statement.executeUpdate();
			if(rows>0) {
				System.out.println("L'entreprise a bien été modifié");
			}

			Connexion.seDeconnecter();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
			
	}

}
