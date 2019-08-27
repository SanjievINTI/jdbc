package com.inti.entities;

import java.util.Arrays;

public class Departement {
private long id;
private String nom;
private String description;
private int nbrEmploye;
public Departement(long id, String nom, String description, int nbrEmploye) {
	super();
	this.id = id;
	this.nom = nom;
	this.description = description;
	this.nbrEmploye = nbrEmploye;
	
	
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getNbrEmploye() {
	return nbrEmploye;
}
public void setNbrEmploye(int nbrEmploye) {
	this.nbrEmploye = nbrEmploye;
}

public Ouvrier [] Ouvrier;
@Override
public String toString() {
	return "Departement [id=" + id + ", nom=" + nom + ", description=" + description + ", nbrEmploye=" + nbrEmploye
			+ ", Ouvrier=" + Arrays.toString(Ouvrier) + ", Cadre=" + Arrays.toString(Cadre) + "]";
}
public Ouvrier[] getOuvrier() {
	return Ouvrier;
}
public void setOuvrier(Ouvrier[] ouvrier) {
	Ouvrier = ouvrier;
}
public Cadre[] getCadre() {
	return Cadre;
}
public void setCadre(Cadre[] cadre) {
	Cadre = cadre;
}

public Cadre [] Cadre;
}
