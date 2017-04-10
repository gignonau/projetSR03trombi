package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Beans.*;

public class LienDAO {

	
	public static int assignUVtoEtudiant(Etudiant e, UV u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "INSERT INTO EtuUV(idEtu,codeUV) " +
					"VALUES(?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, e.getId());
			ps.setString(2, u.getUV());
				
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException o) {
			o.printStackTrace();
		}

		return res;
	}
	
	
	public static int suppUVFromEtudiant(Etudiant e, UV u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "DELETE FROM EtuUV WHERE idEtu = ? AND codeUV = ?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, e.getId());
			ps.setString(2, u.getUV());
				
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException o) {
			o.printStackTrace();
		}

		return res;
	}
	
	public static int assignSeanceUVtoEtudiant(Etudiant e, SeanceUV u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "INSERT INTO EtuSeance(idEtu,idSeance) " +
					"VALUES(?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, e.getId());
			ps.setInt(2, u.getId());
				
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException o) {
			o.printStackTrace();
		}

		return res;
	}
	
	public static int suppSeanceUVFromEtudiant(Etudiant e, SeanceUV u) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "DELETE FROM EtuSeance WHERE idEtu = ? AND idSeance = ?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, e.getId());
			ps.setString(2, u.getCodeUV());
				
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException o) {
			o.printStackTrace();
		}

		return res;
	}
}
