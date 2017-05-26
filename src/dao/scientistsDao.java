package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.scientist;

public class scientistsDao {

	
	public static List<scientist> findAll() {

		List<scientist> lu = new ArrayList<scientist>();

		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
	

			String sql = "SELECT id, name, pwd, domain_ids, idea_ids, comment_ids FROM scientists";
			PreparedStatement ps = cnx.prepareStatement(sql);
			

			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new scientist(res.getInt("id"),
						res.getString("name"),
						res.getString("pwd"),
						res.getString("idea_ids"),
						res.getString("domain_ids"),
						res.getString("comment_ids")));
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
