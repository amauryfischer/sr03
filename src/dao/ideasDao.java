package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.idea;

public class ideasDao {

	
	public static List<idea> findAll() {
		/*
		 * List<beans.Utilisateur> lu = new ArrayList<Utilisateur>(); lu.add(new
		 * Utilisateur(1,"nom1","tel1","username1","pwd1")); lu.add(new
		 * Utilisateur(2,"nom2","tel2","username2","pwd2")); lu.add(new
		 * Utilisateur(3,"nom3","tel3","username3","pwd3"));
		 */

		List<idea> lu = new ArrayList<idea>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			String sql = "SELECT id, title, content, created_at, comment_ids, scientist_id, domain_ids FROM ideas";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la reponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new idea(res.getInt("id"),
						res.getString("title"),
						res.getString("content"),
						res.getString("created_at"),
						res.getString("comment_ids"),
						res.getInt("scientist_id"),
						res.getString("domain_ids")));
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return lu;
	}
	
	
}
