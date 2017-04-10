package Beans;

import java.io.Serializable;

import Beans.Utilisateur;

public class Utilisateur implements Serializable, Comparable<Utilisateur> {
	private String login;
	private String mdp;
	
	public Utilisateur(){
		
	}

	public Utilisateur(String s, String m){
		this.login = s;
		this.mdp =m;
		
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	@Override
	public int compareTo(Utilisateur o) {
		return this.login.compareTo(o.login) & this.mdp.compareTo(o.mdp);
	}
	
	
}
