package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.idea;
import dao.ideasDao;

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
@WebServlet("/ideas")
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
			String finalJson="[";
			int i = 1;
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
					finalJson+=jsonIdea.toString();
				    if (i++ != listidea.size()) {
				    	finalJson+=",";
				    };
					
				};
			}
			finalJson+="]";
			response.getWriter().append(finalJson);
			
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
