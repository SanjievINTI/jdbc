package com.inti.entities;

import java.sql.Date;

public class Cadre extends Employe {
	
	private String specialite;
	private String office;

	public Cadre(String specialite) {
		super();
		this.specialite = specialite;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public Departement departement;

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Cadre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cadre(Long code, String nom, String prenom, String dateNaissance, String specialite) {
		super(code, nom, prenom, dateNaissance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cadre [specialite=" + specialite + ", departement=" + departement + "]";
	}

}
