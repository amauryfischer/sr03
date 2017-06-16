package com.javaids.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
;/**
 * Servlet implementation class IdeasServlet
 */
@WebServlet("/ideasServlet")
public class IdeasServlet extends HttpServlet {
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
        
        //trouver des valeurs
        Map<String, String> mapRequest = new HashMap<String, String>();
        String[] arrSplit=null;        
        arrSplit=reqString.split("[&]");
        for(String strSplit : arrSplit){
        	//System.out.println("strSplit:  "+strSplit+" >0<"); //ok
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
        
        
        
        String title = mapRequest.get("title");
        String scientist_id = mapRequest.get("scientistId");
        String content = mapRequest.get("content");
        String [] domain_ids = { mapRequest.get("domainIds") }; 
        
        //Date current_date = Calendar.getInstance().getTime();
        String [] comment_ids = { mapRequest.get("commentIds") };
        
        //test
        //System.out.println("title="+title+",scientist_id="+scientist_id+",content="+content+",domain_ids="+domain_ids+"  >0<.");
        
        
        //printWriter.print(firstName);
        try {
	        con = DriverManager.getConnection(url, user, password);
	        
	        //Array comment_ids_array = con.createArrayOf("NUMERIC", comment_ids);
	        Array domain_ids_array = con.createArrayOf("NUMERIC", domain_ids);
	        Array comment_ids_array = con.createArrayOf("NUMERIC", comment_ids);
	        
	        pstmt = con.prepareStatement("insert into ideas (title,content,created_at,comment_ids,scientist_id,domain_ids) VALUES (?,?,?,?,?,?)");
        	pstmt.setString(1, title);
        	pstmt.setString(2, content);
        	pstmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
        	pstmt.setArray(4, comment_ids_array);
        	pstmt.setInt(5, Integer.parseInt(scientist_id));
        	pstmt.setArray(6, domain_ids_array);
        	
	        rs = pstmt.executeQuery();
	        
	        //pstmt = con.prepareStatement("UPDATE scientists SET idea_ids=? WHERE id=?");
	        
	        //pstmt.setInt(2, Integer.parseInt(scientist_id));

        } catch (SQLException ex) {
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
                }

            } catch (SQLException ex) {
                /*Logger lgr = Logger.getLogger(Version.class.getName());*/
                /*lgr.log(Level.WARNING, ex.getMessage(), ex);*/
            }
        }
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
