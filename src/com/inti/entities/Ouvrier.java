package com.inti.entities;

import java.sql.Date;

public class Ouvrier extends Employe {
private int nbheure;

public Ouvrier(int nbheure) {
	super();
	this.nbheure = nbheure;
}




public Ouvrier() {
	super();
	// TODO Auto-generated constructor stub
}

public Departement departement;



public Departement getDepartement() {
	return departement;
}




public void setDepartement(Departement departement) {
	this.departement = departement;
}




public Ouvrier(Long code, String nom, String prenom, String dateNaissance,int nbrheure) {
	super(code, nom, prenom, dateNaissance);
	// TODO Auto-generated constructor stub
}




public int getNbheure() {
	return nbheure;
}

public void setNbheure(int nbheure) {
	this.nbheure = nbheure;
} 



	@Override
	public String toString() {
		return "Ouvrier [nbheure=" + nbheure + ", departement=" + departement + "]";
	}
	
}


