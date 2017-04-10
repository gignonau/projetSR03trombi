package Beans;
import java.io.Serializable;

public class UV implements Serializable, Comparable<UV>{
	
	private String UV;
	private String responsable;
	private String intitule;
	
	public UV(){
		
	}
	
	public UV(String uV, String responsable, String intitule) {
		super();
		UV = uV;
		this.responsable = responsable;
		this.intitule = intitule;
	}



	public String getUV() {
		return UV;
	}


	public void setUV(String uV) {
		UV = uV;
	}


	public String getResponsable() {
		return responsable;
	}


	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public int compareTo(UV u){
		return this.UV == u.UV ? 1 :0 ;
	}

}
