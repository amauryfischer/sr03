package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.comment;

public class commentsDao {

	
	public static List<comment> findAll() {

		List<comment> lu = new ArrayList<comment>();

		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();

			String sql = "SELECT id, scientist_id, date, idea_id, content FROM comments";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la reponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new comment(res.getInt("id"),
						res.getString("date"),
						res.getInt("scientist_id"),
						res.getInt("idea_id"),
						res.getString("content")));
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
