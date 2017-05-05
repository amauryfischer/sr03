package com.javaids.servlet;

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

/**
 * Servlet implementation class IdeasServlet
 */
@WebServlet("/ideas")
public class IdeasServlet extends HttpServlet {
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
        
        PrintWriter printWriter = response.getWriter();
        
        //printwrite beginning of document
        printWriter.print("<!DOCTYPE html>");
        printWriter.print("<html>");
        printWriter.print("<head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        printWriter.print("<title>Session Test Servlet</title></head><body>");
        
        //retrieve post params
        String title = request.getParameter("title");
        String scientist_id = request.getParameter("scientistId");
        String content = request.getParameter("content");
        Date current_date = Calendar.getInstance().getTime();
        String [] comment_ids = { request.getParameter("commentIds") };
        String [] domain_ids = { request.getParameter("domainIds") };
        
        //printWriter.print(firstName);
        try {
	        con = DriverManager.getConnection(url, user, password);
	        Array comment_ids_array = con.createArrayOf("NUMERIC", comment_ids);
	        Array domain_ids_array = con.createArrayOf("NUMERIC", domain_ids);
	        pstmt = con.prepareStatement("insert into ideas (title,content,created_at,comment_ids,scientist_id,domain_ids) VALUES (?,?,?,?,?,?)");
        	pstmt.setString(1, title);
        	pstmt.setString(2, content);
        	pstmt.setDate(3, new java.sql.Date(System.currentTimeMillis()));
        	pstmt.setArray(4, comment_ids_array);
        	pstmt.setInt(5, Integer.parseInt(scientist_id));
        	pstmt.setArray(6, domain_ids_array);
        	pstmt.executeUpdate();
	        rs = pstmt.executeQuery();
            while (rs.next()) {
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

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
