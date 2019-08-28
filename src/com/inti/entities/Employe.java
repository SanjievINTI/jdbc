package com.inti.entities;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Employe {
private Long code;
private String nom;
private String prenom;
private String  dateNaissance;



@Override
public String toString() {
	return "Employe [code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + "]";
}
public Employe() {
	super();
	
}
public Employe(Long code, String nom, String prenom, String dateNaissance) {
	super();
	this.code = code;
	this.nom = nom;
	this.prenom = prenom;
	this.dateNaissance = dateNaissance;
}
public Long getCode() {
	return code;
}
public void setCode(Long code) {
	this.code = code;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getDateNaissance() {
	return dateNaissance;
}
public void setDateNaissance(String dateNaissance) {
	this.dateNaissance = dateNaissance;
}


}
