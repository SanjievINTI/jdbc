package com.inti.test;

import com.inti.dao.CadreDAO;
import com.inti.dao.DepartementDAO;
import com.inti.dao.EntrepriseDAO;
import com.inti.dao.OuvrierDAO;
import com.inti.entities.Cadre;
import com.inti.entities.Departement;
import com.inti.entities.Entreprise;
import com.inti.entities.Ouvrier;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import java.sql.Date;

public class Test {

	public static void main(String[] args) {
// ---------------------OUVRIER--------------------------------------------------
	Ouvrier ouvr1=new Ouvrier (1l,"Jean","Rio","01-06-1994",35);
	Ouvrier ouvr2=new Ouvrier (2l,"Pierre","Paolo","12-07-1994",45);
	OuvrierDAO ouvrierDAO = new OuvrierDAO ();
	ouvrierDAO.ajouterOuvrier(ouvr1);
	//ouvrierDAO.ajouterOuvrier(ouvr2);
	
	List<Ouvrier> listOuvrier = OuvrierDAO.findAll ();
	for (Ouvrier ouvrier : listOuvrier) {
		System.out.println(ouvrier.toString());
	}
	
	Ouvrier ouvrierExpert = ouvrierDAO.findOne(45);
	System.out.println(ouvrierExpert.toString());
	
	ouvrierDAO.supprimer(45);
	System.out.println("--Affichage après supprimer");
	List<Ouvrier> listOuvrierAfter = OuvrierDAO.findAll ();
	for (Ouvrier ouvrier : listOuvrierAfter) {
		System.out.println(ouvrier.toString());
	}
	System.out.println("Modification d'un ouvrier");
	Ouvrier ouvrMod= ouvrierDAO.findOne(35);
			ouvrMod.setCode(3l);
			ouvrMod.setNom("Paulie");
			ouvrMod.setPrenom("Paula");
			ouvrMod.setDateNaissance("15-06-1996");
//----------------------------CADRE--------------------------------------------
			
			Cadre cadre1=new Cadre (12l,"Moussa","Paolo", "15/06/1990", "Comptable");
			Cadre cadre2=new Cadre (14l,"Dialo","Ayew", "01/08/1991", "Pirate");
			CadreDAO cadreDAO = new CadreDAO ();
			cadreDAO.ajouterCadre(cadre1);
			cadreDAO.ajouterCadre(cadre2);
		List <Cadre> listCadre= CadreDAO.findAll();
		for (Cadre cadre: listCadre) {
			System.out.println(cadre.toString());
		}
		Cadre cadreExpert = cadreDAO.findOne("Pirate");
		System.out.println(ouvrierExpert.toString());
		
		cadreDAO.supprimer("Pirate");
		System.out.println("--Affichage après supprimer");
		List<Cadre> listCadreAfter = CadreDAO.findAll();
		for (Cadre cadre: listCadreAfter) {
			System.out.println(cadre.toString());
		}
		System.out.println("Modification d'un cadre");
		Cadre cadMod= cadreDAO.findOne("Comptable");
				cadMod.setCode(15l);
				cadMod.setNom("Henry");
				cadMod.setPrenom("Thierry");
				cadMod.setDateNaissance("14-09-1988");
				cadMod.setSpecialite("ExpertComptable");
				
//-------------------------------DEPARTEMENT----------------------------------------
	
Departement dep1= new Departement (91l, "Info", "Maintenance", 50);
Departement dep2= new Departement (92l, "Prod", "Creation", 25);

DepartementDAO departementDAO= new DepartementDAO();

departementDAO.ajouterDepartement(dep1);
departementDAO.ajouterDepartement(dep2);

System.out.println("---Affichage avant de supprimer");
List<Departement> listDepartement = departementDAO.findAll();
for (Departement departement: listDepartement) {
	System.out.println(departement.toString());
}
Departement DepartementExpert= departementDAO.findOne(92);
System.out.println(DepartementExpert.toString());

	System.out.println("---Supprimer");
	departementDAO.supprimer(92l);
	System.out.println("----Affichage apres supprime");
	List<Departement> listDepartementAfter = departementDAO.findAll();
	for (Departement departement: listDepartementAfter) {
		System.out.println(departement.toString());
		
		System.out.println("----Modification des paramètre Departement");
		Departement depMod = departementDAO.findOne(91l);
		depMod.setId(93l);
		depMod.setNom("Gogo");
		depMod.setDescription("Traitement expert");
		depMod.setNbrEmploye(30);
//------------------------------ENTREPRISE----------------------
		

	Entreprise ent1=new Entreprise (156l, "Carrefour");
	Entreprise ent2= new Entreprise (157l,"Monoprix");
	EntrepriseDAO entrepriseDAO= new EntrepriseDAO();
	
	entrepriseDAO.ajouterEntreprise(ent1);
	entrepriseDAO.ajouterEntreprise(ent2);
	
System.out.println("---Affichage avant suppression");
	List <Entreprise> listEntreprise = entrepriseDAO.findAll();
	for (Entreprise entreprise: listEntreprise) {
		System.out.println(entreprise.toString());
	}
	
	Entreprise entrepriseRecherche= entrepriseDAO.findOne(156l);
			System.out.println(entrepriseRecherche.toString());
	
	System.out.println("---Suppression");
	entrepriseDAO.supprimer("Monoprix");
	System.out.println("----Affichage après suppression");
	List <Entreprise> listEntrepriseAfter = entrepriseDAO.findAll();
	for (Entreprise entreprise: listEntrepriseAfter) {
		System.out.println(entreprise.toString());
	}
	
	Entreprise entMod=entrepriseDAO.findOne(156l);
	entMod.setCode(159l);
	entMod.setLibelle("Franprix");
	System.out.println(entMod.toString());
	}
	
	}
	

}
