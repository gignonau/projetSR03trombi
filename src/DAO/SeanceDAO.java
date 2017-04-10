package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.*;


public class SeanceDAO {

	public static int insert(SeanceUV u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "INSERT INTO Seance(codeUV,jour,horaireD,horaireF,salle,type,responsable) " +
					"VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getCodeUV());
			ps.setString(2, u.getJour());
			ps.setString(3, u.getHoraireD());
			ps.setString(4, u.getHoraireF());
			ps.setString(5, u.getSalle());
			ps.setString(6, u.getType());
			ps.setString(7, u.getResponsable());
			
			
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int update(SeanceUV u) {
		int res = 0;
		
		Connection cnx=null;
		
		try {
			// chargement du driver
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "UPDATE Seance SET codeUV=?,jour=?,horaireD=?,horaireF=?,salle=?,Type=?, responsable=? WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getCodeUV());
			ps.setString(2, u.getJour());
			ps.setString(3, u.getHoraireD());
			ps.setString(4, u.getHoraireF());
			ps.setString(5, u.getSalle());
			ps.setString(6, u.getType());
			ps.setString(7, u.getResponsable());
			ps.setInt(8, u.getId());
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int delete(SeanceUV u) {
		int res = 0, res2 = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

				
			//Requete
			String sql2 = "DELETE FROM EtuSeance WHERE idSeance=?";
			PreparedStatement ps2 = cnx.prepareStatement(sql2);
			ps2.setInt(1,u.getId());
			
			//Execution et traitement de la réponse
			res2 = ps2.executeUpdate();
			
			
			//Requete
			String sql = "DELETE FROM Seance WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,u.getId());
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
					
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res+res2;
	}
	
	
	
	public static List<SeanceUV> findAll() {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		List<SeanceUV> lu = new ArrayList<SeanceUV>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			String sql = "SELECT id,codeUV,jour, horaireD,horaireF,salle,type,responsable FROM Seance";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new SeanceUV(res.getInt("id"),
						res.getString("codeUV"),
						res.getString("jour"),
						res.getString("horaireD"),
						res.getString("horaireF"),
						res.getString("salle"),
						res.getString("type"),
						res.getString("responsable")));
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lu;
	}
	
	public static SeanceUV find(int s) {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		SeanceUV u = null;
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id,codeUV,jour, horaireD,horaireF,salle,type,responsable FROM Seance WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, s);
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				u = new SeanceUV(res.getInt("id"),
						res.getString("codeUV"),
						res.getString("jour"),
						res.getString("horaireD"),
						res.getString("horaireF"),
						res.getString("salle"),
						res.getString("type"),
						res.getString("responsable"));
				break;
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return u;
	}
	
	
	public static List<SeanceUV> findAllSeanceUVFromEtudiant(Etudiant et) {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		List<SeanceUV> lu = new ArrayList<SeanceUV>();
		
		Connection cnx=null;
		try {
			
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id,codeUV,jour, horaireD,horaireF,salle,type,responsable FROM Seance,EtuSeance WHERE EtuSeance.idEtu =?  AND EtuSeance.idSeance = Seance.id ";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, et.getId());
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new SeanceUV(res.getInt("id"),
						res.getString("codeUV"),
						res.getString("jour"),
						res.getString("horaireD"),
						res.getString("horaireF"),
						res.getString("salle"),
						res.getString("type"),
						res.getString("responsable"))
				
						);
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lu;
	}
	
	public static List<SeanceUV> findAllSeanceUVFromUV(UV u) {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		List<SeanceUV> lu = new ArrayList<SeanceUV>();
		
		Connection cnx=null;
		try {
			
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id,codeUV,jour, horaireD,horaireF,salle,type,responsable FROM Seance WHERE codeUV = ? ";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getUV());
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new SeanceUV(res.getInt("id"),
						res.getString("codeUV"),
						res.getString("jour"),
						res.getString("horaireD"),
						res.getString("horaireF"),
						res.getString("salle"),
						res.getString("type"),
						res.getString("responsable"))
				);
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lu;
	}
	
	public static int countUsers(){
		
		int counter = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
		
			String sql = "SELECT COUNT(*) FROM Etudiant";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
			 counter = res.getInt("COUNT(*)");
			 break;
				
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return counter;
	}
	
}

