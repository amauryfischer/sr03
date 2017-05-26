package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.scientist;
import dao.scientistsDao;
import net.sf.json.JSONObject;

import java.util.List;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;



/**
 * Servlet implementation class ideaREST
 */
@WebServlet("/scientists")
public class scientistREST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public scientistREST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			scientist scientist;
			List<scientist> listscientist=scientistsDao.findAll();
			
			for(scientist scientist1 : listscientist){
				
				if(scientist1!=null){
					
					JsonObject jsonScientist = Json.createObjectBuilder()
							.add("id",scientist1.getId())
							.add("name",scientist1.getName())
							.add("pwd",scientist1.getPwd())
							.add("idea_ids", (scientist1.getIdea_ids() == null) ? "" : scientist1.getIdea_ids())
							.add("domain_ids",scientist1.getDomain_ids())
							.add("comment_ids", (scientist1.getComment_ids() == null) ? "" : scientist1.getComment_ids())
							.build();
					
					response.getWriter().append(jsonScientist.toString());
				}
			}
			
		} catch (Exception e) {

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
