package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.idea;
import dao.ideasDao;
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
@WebServlet("/ideaREST")
public class ideaREST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ideaREST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			idea idea;
			List<idea> listidea=ideasDao.findAll();
			
			for(idea idea1 : listidea){
				
				if(idea1!=null){
					

					JsonObject jsonIdea = Json.createObjectBuilder()
							.add("id",idea1.getId())
							.add("title",idea1.getTitle())
							.add("content",idea1.getContent())
							.add("date",idea1.getCreatedAt())
							.add("commentIds",idea1.getCommentIds())
							.add("scientId",idea1.getScientistId())
							.build();
					
					response.getWriter().append(jsonIdea.toString());
				}
			}
			
		} catch (Exception e) {

		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
