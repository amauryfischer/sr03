package com.javaids.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Array;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.createMD5;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		PreparedStatement pstmt = null;
        ResultSet rs = null;
        
      //Db connection init
  		String url = "jdbc:postgresql://localhost:5432/sr03";
        String user = "toto2";
        String password = "azerty";
        
      //  PrintWriter printWriter = response.getWriter();
        
      //retrieve post params
        String reqString = getRequestPayload(request);
        //System.out.println("reqString:  "+reqString+" >0<");//ok
        
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
       
        
        
        String formType = mapRequest.get("formType"); 
        int nb_scientists=0;
        
        
       
       // System.out.println("formType////:  "+formType+" >0<"); //ok
        
        try {
        	con = DriverManager.getConnection(url, user, password);
            if(formType.equals("newAccount")){
            	
            	 //System.out.println("newAccount. >0<");
            	
    	        String newName = mapRequest.get("newName");
    	        String newPassword = mapRequest.get("newPassword");
    	        String [] domain_ids = { mapRequest.get("domain_ids") };
    	        Array domain_ids_array = con.createArrayOf("NUMERIC", domain_ids);
    	        //crypto
    	        newPassword=createMD5.getMd5(newPassword);
    	        
    	        pstmt = con.prepareStatement("insert into scientists (name,pwd,domain_ids) VALUES (?,?,?)");
    	        pstmt.setString(1, newName);
    	        pstmt.setString(2, newPassword);
            	pstmt.setArray(3, domain_ids_array);
            	
            }else if(formType.equals("signIn")){
            	
            	
            	 System.out.println("signIn. >0<");
            	
            	String userName = mapRequest.get("login");
            	String userPassword = createMD5.getMd5(mapRequest.get("password"));
            	
            	pstmt = con.prepareStatement("SELECT COUNT(*) AS nb_scientists FROM scientists WHERE name=? AND pwd=?;");
    	        pstmt.setString(1, userName);
    	        pstmt.setString(2, userPassword);
            }
	        
            //ececute SQL
	        rs = pstmt.executeQuery();
	        
	        //response
	        if(formType.equals("signIn")){
		        while (rs.next()) {
		        	
		        	 nb_scientists=Integer.parseInt( rs.getString(1));
		        	 //printout
		        	 System.out.println("avant nb scientists");
		        	 System.out.println("nb_scientists=" + nb_scientists);
		        	 System.out.println("apres nb scientists");
		        	 
		        	if(nb_scientists>0){
		        		
		        		//login reussi
		        		
		        		response.setHeader("REQUEST_AUTH", "2"); 
		        		
		        		//session
		        		
		        		HttpSession session = request.getSession();
		        		session.setAttribute("userName", mapRequest.get("login"));
		        		System.out.println("userName="+mapRequest.get("login"));
		        		
		        		//setting session to expiry in 30 mins
		        		
		        		session.setMaxInactiveInterval(30*60);
		        		Cookie userName = new Cookie("userName", mapRequest.get("login"));
		        		userName.setMaxAge(30*60);
		        		response.addCookie(userName);
		        		
		        	}else{
		        		response.setHeader("REQUEST_AUTH", "1"); 
		        	}
		        	
		        }
	        }else if(formType.equals("newAccount")){
	        	response.setHeader("REQUEST_AUTH", "2"); 
	        }

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


}
