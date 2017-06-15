package controllers;

import java.io.BufferedReader;
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
    
	private String getRequestPayload(HttpServletRequest req) {  
        StringBuilder sb = new StringBuilder();  
        try(BufferedReader reader = req.getReader();) {  
                 char[]buff = new char[1024];  
                 int len;  
                 while((len = reader.read(buff)) != -1) {  
                          sb.append(buff,0, len);  
                 }  
        }catch (IOException e) {  
                 e.printStackTrace();  
        }  
        return sb.toString();  
	}  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("comments GET.////// ");
		
		String ideaId = request.getParameter("idea");
		System.out.println("ideaId : "+ ideaId);
		

		try {
			comment comment;
			List<comment> listcomment;
			if(ideaId!=null && ideaId!="0"){
				System.out.println("getComments : "+ ideaId);
				listcomment=commentsDao.getComments(ideaId);
			}else{
				
				System.out.println("findAll : "+ ideaId);
				listcomment=commentsDao.findAll();
			}
			

			
			String finalJson="[";
			int i = 1;
			for(comment comment1 : listcomment){
				
				if(comment1!=null){
					
					JsonObject jsonComment = Json.createObjectBuilder()
							.add("id",comment1.getId())
							.add("date",comment1.getDate())
							.add("scientist_id",comment1.getScientistId())
							.add("idea_id", comment1.getIdeaId())
							.add("content",comment1.getContent())
							.build();
					finalJson+=jsonComment.toString();
				    if (i++ != listcomment.size()) {
				    	finalJson+=",";
				    };
				}
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
