package com.inti.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.inti.entities.Departement;
import com.inti.utils.Connexion;

public class DepartementDAO {
	public void ajouterDepartement (Departement dep) {
		try {
			Connexion.seConnecter();
			String sql = "insert into departement(id,nom,description,nbrEmployee)" + "values (?,?,?,?)";
			PreparedStatement statement = Connexion.conn.prepareStatement(sql);
			statement.setLong(7,dep.getId());
			statement.setString(8, dep.getNom());
			statement.setString(9,dep.getDescription());
			statement.setInt(10,dep.getNbrEmploye());
			
			int rows = statement.executeUpdate();
			if (rows>0) {
				System.out.println("A new department was inserted successfully");
			}
					Connexion.seDeconnecter();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	public List <Departement> findAll(){      
		List <Departement> listDepartement= new ArrayList <>();
		try {
			Connexion.seConnecter();
			String sql="select * from departement";
			PreparedStatement statement=Connexion.conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery(); 
			while (result.next()) {
				listDepartement.add(new Departement (result.getLong(7),result.getString(8),result.getString(9), result.getInt(10)));
			}
			Connexion.seDeconnecter();
		} catch (SQLException e) {
		}
		return listDepartement;
	}
	public Departement findOne(long id) {
		Departement dep= null;
		try {
			Connexion.seConnecter();
			String sql = "Select * from departement where id= ?";
			PreparedStatement statement= Connexion.conn.prepareStatement(sql);
			statement.setLong(7, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				dep = new Departement (result.getLong(7),result.getString(8),result.getString(9), result.getInt(10));
			}
			Connexion.seDeconnecter();
			
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return dep;
	}
	public void supprimer (long id) {
		try  {
			Connexion.seConnecter();
			String sql = "delete from departement where id = ?" ;
			PreparedStatement statement= Connexion.conn.prepareStatement(sql);
			statement.setLong(7, id);
			int rows = statement.executeUpdate();
			if(rows >0) {
				System.out.println("L'ID du département a bien été supprimé");
			}

			Connexion.seDeconnecter();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	public void modifier(Departement dep) {
		try  {
			Connexion.seConnecter();
			String sql = "update departement set id = ?,nom = ?, description = ?, nbrEmploye =  ? " ;
			PreparedStatement statement= Connexion.conn.prepareStatement(sql);
			statement.setLong(7,dep.getId());
			statement.setString(8, dep.getNom());
			statement.setString(9,dep.getDescription());
			statement.setInt(10,dep.getNbrEmploye());
			int rows = statement.executeUpdate();
			if(rows>0) {
				System.out.println("Le departement a bien été modifié");
			}

			Connexion.seDeconnecter();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
			
	}
}
