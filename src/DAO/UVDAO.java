package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.Etudiant;
import Beans.UV;


public class UVDAO {

	public static int insert(UV u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "INSERT INTO UV(code,responsable,intitule) " +
					"VALUES(?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getUV());
			ps.setString(2, u.getResponsable());
			ps.setString(3, u.getIntitule());
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int update(UV u) {
		int res = 0;
		
		Connection cnx=null;
		
		try {
			// chargement du driver
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "UPDATE UV SET responsable=?,intitule=? WHERE code=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, u.getResponsable());
			ps.setString(2, u.getIntitule());
			
			ps.setString(6, u.getUV());
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int delete(UV u) {
		int res1 = 0 ,res2 = 0 ,res3 = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			
			//Requete
			String sql1 = "DELETE FROM EtuUV WHERE codeUV=?";
			
			PreparedStatement ps1 = cnx.prepareStatement(sql1);
			ps1.setString(1,u.getUV());
			
			//Execution et traitement de la réponse
			res2 = ps1.executeUpdate();
			
//			//Requete
//			String sql2 = "DELETE FROM EtuSeance WHERE idSeance=?";
//			
//			PreparedStatement ps2 = cnx.prepareStatement(sql2);
//			ps2.setString(1,u.getUV());
//			
//			//Execution et traitement de la réponse
//			res3 = ps2.executeUpdate();
			

			
			//Requete
			String sql = "DELETE FROM UV WHERE code=?";
			
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1,u.getUV());
			
			//Execution et traitement de la réponse
			res1 = ps.executeUpdate();
			
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res1+res2+res3;
	}
	
	
	
	public static List<UV> findAll() {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		List<UV> lu = new ArrayList<UV>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			String sql = "SELECT code,responsable,intitule FROM UV";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new UV(res.getString("code"),
						res.getString("responsable"),
						res.getString("intitule"))
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
	
	public static UV find(String a) {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		UV u = null;
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT code, responsable, intitule FROM UV WHERE code=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, a);
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				u = new UV(res.getString("code"),
						res.getString("responsable"),
						res.getString("intitule")
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
	
	
	public static List<UV> findAllUVFromEtudiant(Etudiant u) {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		List<UV> lu = new ArrayList<UV>();
		
		Connection cnx=null;
		try {
			
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT code,responsable,intitule FROM UV,EtuUV WHERE UV.code = EtuUV.codeUV AND EtuUV.idEtu = ?   ";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, u.getId());
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new UV(res.getString("code"),
						res.getString("responsable"),
						res.getString("intitule")
						));
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lu;
	}
	
	public static int countUV(){
		
		int counter = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
		
			String sql = "SELECT COUNT(*) FROM UV";
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

