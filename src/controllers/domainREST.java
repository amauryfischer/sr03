package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.domain;
import dao.domainsDao;
import net.sf.json.JSONObject;

import java.util.List;
import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonWriter;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;



/**
 * Servlet implementation class ideaREST
 */
@WebServlet("/domains")
public class domainREST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public domainREST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			domain domain;
			List<domain> listdomain=domainsDao.findAll();
			int i = 1;
			response.getWriter().append("[");
			for(domain domain1 : listdomain){
				
				if(domain1!=null){
					
					JsonObject jsonComment = Json.createObjectBuilder()
							.add("id",domain1.getId())
							.add("title",domain1.getTitle())
							.add("description",domain1.getDescription())
							.build();
					response.getWriter().append(jsonComment.toString());
				    if (i++ != listdomain.size()) {
				    	response.getWriter().append(",");
				    }
					//response.getWriter().append(jsonComment.toString());
				}
			}
			response.getWriter().append("]");
			
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
