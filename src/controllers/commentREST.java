package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.comment;
import dao.commentsDao;
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
@WebServlet("/comments")
public class commentREST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public commentREST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			comment comment;
			List<comment> listcomment=commentsDao.findAll();
			
			for(comment comment1 : listcomment){
				
				if(comment1!=null){
					
					JsonObject jsonComment = Json.createObjectBuilder()
							.add("id",comment1.getId())
							.add("date",comment1.getDate())
							.add("scientist_id",comment1.getScientistId())
							.add("idea_id", comment1.getIdeaId())
							.add("content",comment1.getContent())
							.build();
					
					response.getWriter().append(jsonComment.toString());
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
