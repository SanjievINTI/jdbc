package com.inti.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inti.entities.Cadre;
import com.inti.utils.Connexion;

public class CadreDAO {
	public void ajouterCadre (Cadre cad) {
		try {
			Connexion.seConnecter();
			String sql = "insert into cadre(code,nom,prenom,dateNaissance,specialite)" + "values (?,?,?,?,?)";
			PreparedStatement statement = Connexion.conn.prepareStatement(sql);
			statement.setLong(1,cad.getCode());
			statement.setString(2, cad.getNom());
			statement.setString(3,cad.getPrenom());
			statement.setString(4, cad.getDateNaissance());
			statement.setString(6, cad.getSpecialite());
			int rows = statement.executeUpdate();
			if (rows>0) {
				System.out.println("A new cadre was inserted successfully");
			}
					Connexion.seDeconnecter();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	public static List <Cadre> findAll(){      
		List <Cadre> listCadre= new ArrayList <>();
		try {
			Connexion.seConnecter();
			String sql="select * from cadre";
			PreparedStatement statement=Connexion.conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery(); 
			while (result.next()) {
				listCadre.add(new Cadre (result.getLong(1),result.getString(2),result.getString(3), result.getString(4), result.getString(6)));
			}
			Connexion.seDeconnecter();
		} catch (SQLException e) {
		}
		return listCadre;
	}
	public Cadre findOne(String specialite) {
		Cadre cad= null;
		try {
			Connexion.seConnecter();
			String sql = "Select * from cadre where specialite= ?";
			PreparedStatement statement= Connexion.conn.prepareStatement(sql);
			statement.setString(6, specialite);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				cad = new Cadre (result.getLong(1),result.getString(2),result.getString(3), result.getString(4), result.getString(6));
			}
			Connexion.seDeconnecter();
			
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return cad;
	}
	public void supprimer (String specialite) {
		try  {
			Connexion.seConnecter();
			String sql = "delete from cadre where specialite = ?" ;
			PreparedStatement statement= Connexion.conn.prepareStatement(sql);
			statement.setString(6, specialite);
			int rows = statement.executeUpdate();
			if(rows >0) {
				System.out.println("La specialite du cadre a bien été supprimé");
			}

			Connexion.seDeconnecter();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	public void modifier(Cadre cad) {
		try  {
			Connexion.seConnecter();
			String sql = "update cadre set code = ?,nom = ?, prenom=?, dateNaissance=?, specialite=?" ;
			PreparedStatement statement= Connexion.conn.prepareStatement(sql);
			statement.setLong(1,cad.getCode());
			statement.setString(2, cad.getNom());
			statement.setString(3,cad.getPrenom());
			statement.setString(4, cad.getDateNaissance());
			statement.setString(6, cad.getSpecialite());
			int rows = statement.executeUpdate();
			if(rows>0) {
				System.out.println("Le cadre a bien été modifié");
			}

			Connexion.seDeconnecter();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
			
	}

}
