package Beans;
import java.io.Serializable;

@SuppressWarnings("serial")
public class SeanceUV implements Serializable, Comparable<SeanceUV>{
	
	private int id;
	private String codeUV;
	private String jour;
	private String horaireD;
	private String horaireF;
	private String salle;
	private String type;
	private String responsable;
	
	public SeanceUV(){
		
	}

	public SeanceUV(int id, String codeUV, String jour, String horaireD, String horaireF,
		String salle, String type, String responsable) {
	super();
	this.id = id;
	this.codeUV = codeUV;
	this.jour = jour;
	this.horaireD = horaireD;
	this.horaireF = horaireF;
	this.salle = salle;
	this.type = type;
	this.responsable = responsable;
}

	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}


	public String getCodeUV() {
		return codeUV;
	}

	public void setCodeUV(String codeUV) {
		this.codeUV = codeUV;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getHoraireD() {
		return horaireD;
	}


	public void setHoraireD(String horaireD) {
		this.horaireD = horaireD;
	}


	public String getHoraireF() {
		return horaireF;
	}


	public void setHoraireF(String horaireF) {
		this.horaireF = horaireF;
	}


	public String getSalle() {
		return salle;
	}


	public void setSalle(String salle) {
		this.salle = salle;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getResponsable() {
		return responsable;
	}


	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}


	public int compareTo(SeanceUV s){
		return this.id == s.id ? 1 : 0; 
	}

}
