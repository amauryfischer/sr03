package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.domain;

public class domainsDao {

	
	public static List<domain> findAll() {

		List<domain> lu = new ArrayList<domain>();

		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
	

			String sql = "SELECT id, title, description FROM domains";
			PreparedStatement ps = cnx.prepareStatement(sql);
			

			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				lu.add(new domain(res.getInt("id"),
						res.getString("title"),
						res.getString("description")));
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
