package com.javaids.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Calendar;
//import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.createMD5;

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
        String formType=request.getParameter("formType");
        String query1="";
        int nb_scientists=0;
        

        
        try {
        	con = DriverManager.getConnection(url, user, password);
            if(formType.equals("newAccount")){
    	        String newName = request.getParameter("newName");
    	        String newPassword = request.getParameter("newPassword");
    	        String [] domain_ids = { request.getParameter("domain_ids") };
    	        Array domain_ids_array = con.createArrayOf("NUMERIC", domain_ids);
    	        //crypto
    	        newPassword=createMD5.getMd5(newPassword);
    	        
    	        pstmt = con.prepareStatement("insert into scientists (name,pwd,domain_ids) VALUES (?,?,?)");
    	        pstmt.setString(1, newName);
    	        pstmt.setString(2, newPassword);
            	pstmt.setArray(3, domain_ids_array);
            	
            }else if(formType.equals("signIn")){
            	String userName = request.getParameter("login");
            	String userPassword = createMD5.getMd5(request.getParameter("password"));
            	pstmt = con.prepareStatement("SELECT COUNT(*) AS nb_scientists FROM scientists WHERE name=? AND pwd=?;");
    	        pstmt.setString(1, userName);
    	        pstmt.setString(2, userPassword);
            }
	        
	        rs = pstmt.executeQuery();
	        
	        while (rs.next()) {
	        	
	        	 nb_scientists=Integer.parseInt( rs.getString(1));
	        	 System.out.println("nb_scientists=" + nb_scientists);
	        	 
	        	if(nb_scientists>0){
	        		response.sendRedirect("/sr03/page_accueil.jsp");
	        	//}else{
	        		//PrintWriter printWriter = response.getWriter();
	        		//printWriter.print("<script type=\"text/javascript\">alert(\"Sign in failed.\");</script>");
	        	}
	        	
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
        
        response.sendRedirect("/sr03/page_login.jsp");
        
	}

}
