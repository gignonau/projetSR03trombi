package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.Etudiant;
import Beans.SeanceUV;
import Beans.UV;


public class EtudiantDAO {

	public static int insert(Etudiant u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "INSERT INTO Etudiant(nom,prenom,branche,mail) " +
					"VALUES(?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getNom());
			ps.setString(2, u.getPrenom());
			ps.setString(3, u.getBranche());
			ps.setString(4, u.getFiliere());
			ps.setString(5, u.getMail());
			
			
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int update(Etudiant u) {
		int res = 0;
		
		Connection cnx=null;
		
		try {
			// chargement du driver
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "UPDATE Etudiant SET nom=?,prenom=?,branche=?,filiere=?,mail=? WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getNom());
			ps.setString(2, u.getPrenom());
			ps.setString(3, u.getBranche());
			ps.setString(4, u.getFiliere());
			ps.setString(5, u.getMail());
			ps.setInt(6, u.getId());
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int delete(int id) {
		int res = 0,res1 =0, res2 = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

				
			//Requete
			String sql1 = "DELETE FROM EtuUV WHERE idEtu=?";
			PreparedStatement ps1 = cnx.prepareStatement(sql1);
			ps1.setInt(1,id);
			
			//Execution et traitement de la réponse
			res1 = ps1.executeUpdate();
			
			
			//Requete
			String sql2 = "DELETE FROM EtuSeance WHERE idEtu=?";
			PreparedStatement ps2 = cnx.prepareStatement(sql2);
			ps2.setInt(1,id);
			
			//Execution et traitement de la réponse
			res2 = ps2.executeUpdate();
			
			
			//Requete
			String sql = "DELETE FROM Etudiant WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,id);
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res+res1+res2;
	}
	
	
	
	public static List<Etudiant> findAll() {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		List<Etudiant> lu = new ArrayList<Etudiant>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			String sql = "SELECT id,nom,prenom,branche,filiere,mail FROM Etudiant";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new Etudiant(res.getInt("id"),
						res.getString("nom"),
						res.getString("prenom"),
						res.getString("branche"),
						res.getString("filiere"),
						res.getString("mail")));
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lu;
	}
	
	public static Etudiant find(int id) {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		Etudiant u = null;
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id,nom,prenom,branche,filiere,mail FROM Etudiant WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				u = new Etudiant(res.getInt("id"),
						res.getString("nom"),
						res.getString("prenom"),
						res.getString("branche"),
						res.getString("filiere"),
						res.getString("mail")
						);
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
	
	public static List<Etudiant> find(String exp) {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		List<Etudiant> u = new ArrayList<Etudiant>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id,nom,prenom,branche,filiere,mail FROM Etudiant WHERE nom LIKE '%"+exp+"%'";
			PreparedStatement ps = cnx.prepareStatement(sql);
			//ps.setString(1, exp);
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				u.add(new Etudiant(res.getInt("id"),
						res.getString("nom"),
						res.getString("prenom"),
						res.getString("branche"),
						res.getString("filiere"),
						res.getString("mail")
						));
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return u;  
	}
	public static List<Etudiant> findAllEtudiantFromUV(UV u) {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		List<Etudiant> lu = new ArrayList<Etudiant>();
		
		Connection cnx=null;
		try {
			
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id,nom,prenom,branche,filiere,mail FROM Etudiant,EtuUV WHERE Etudiant.id =EtuUV idEtu  AND EtuUV.codeUV = ? ";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getUV());
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new Etudiant(res.getInt("id"),
						res.getString("nom"),
						res.getString("prenom"),
						res.getString("branche"),
						res.getString("filiere"),
						res.getString("mail")));
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lu;
	}
	public static List<Etudiant> findAllEtudiantFromSeanceUV(SeanceUV u) {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		List<Etudiant> lu = new ArrayList<Etudiant>();
		
		Connection cnx=null;
		try {
			
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id,nom,prenom,branche,filiere,mail FROM Etudiant,EtuSeance WHERE Etudiant.id =EtuSeance.idEtu  AND EtuSeance.idSeance = ? ";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, u.getId());
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new Etudiant(res.getInt("id"),
						res.getString("nom"),
						res.getString("prenom"),
						res.getString("branche"),
						res.getString("filiere"),
						res.getString("mail")));
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

