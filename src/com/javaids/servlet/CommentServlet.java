package com.javaids.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.sql.Array;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/commentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
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
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        //Db connection init
      	String url = "jdbc:postgresql://localhost:5432/sr03";
        String user = "toto2";
        String password = "azerty";
        
        //retrieve post params
        String reqString = getRequestPayload(request);
        
        System.out.println("reqString: "+reqString);
         
        //trouver des valeurs
        Map<String, String> mapRequest = new HashMap<String, String>();
        String[] arrSplit=null;        
        arrSplit=reqString.split("[&]");
        for(String strSplit : arrSplit){

        	String[] arrSplitEqual=null;
        	arrSplitEqual=strSplit.split("[=]");
        	
        	if(arrSplitEqual.length>1)
        	{
        		mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
        	}
        	else{
        		 if(arrSplitEqual[0]!="")
                 {
        			 mapRequest.put(arrSplitEqual[0], "");      
        	     }
        	}
        
        }
        
        
        String scientistId = mapRequest.get("scientistId");
        String ideaId = mapRequest.get("ideaId");
        String content = mapRequest.get("content");

        System.out.println("scientistId="+scientistId+",ideaId="+ideaId+",content="+content);
        
        try {
        	con = DriverManager.getConnection(url, user, password);
        	
        	pstmt = con.prepareStatement("insert into comments (scientist_id,date,idea_id,content) VALUES (?,?,?,?)");
        	
        	pstmt.setInt(1,  Integer.parseInt(scientistId));
        	pstmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
        	pstmt.setInt(3, Integer.parseInt(ideaId));
        	pstmt.setString(4, content);
        	
        	System.out.println("avant executeQuery.");
        	rs = pstmt.executeQuery();
            
	        response.setHeader("REQUEST_AUTH", "2");
	        System.out.println("fin");
	        
        }catch (SQLException ex) {
        	System.out.println(ex);
            /*Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);*/

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                	pstmt.close();
                }
                if (con != null) {
                    con.close();
                    System.out.println("close");
                }

            } catch (SQLException ex) {
                /*Logger lgr = Logger.getLogger(Version.class.getName());*/
                /*lgr.log(Level.WARNING, ex.getMessage(), ex);*/
            }
        }
	
	}//doPost

}
