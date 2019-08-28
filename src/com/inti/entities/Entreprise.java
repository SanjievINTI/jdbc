package com.inti.entities;

public class Entreprise {
@Override
	public String toString() {
		return "Entreprise [code=" + code + ", libelle=" + libelle + "]";
	}
private long code ;
private String libelle ;
private String nom ; 
public Entreprise(long code, String libelle) {
	super();
	this.code = code;
	this.libelle = libelle;
}
public long getCode() {
	return code;
}
public void setCode(long code) {
	this.code = code;
}
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
} 

}
