package Beans;

import java.io.Serializable;

import Beans.Etudiant;

public class Etudiant implements  Serializable, Comparable<Etudiant> {
	
	private int id;
	private String nom;
	private String prenom;
	private String branche;
	private String filiere;
	private String mail;
	
	public Etudiant(){
		
	}
	
	public Etudiant(int i, String n, String p, String b, String f,String m){
		this.id = i;
		this.nom = n;
		this.prenom = p;
		this.branche = b;
		this.filiere = f;
		this.mail = m;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getBranche() {
		return branche;
	}
	public void setBranche(String branche) {
		this.branche = branche;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Override
	public int compareTo(Etudiant e){
		return this.id == e.id ? 1 : 0 ;
	}
	
	

}
