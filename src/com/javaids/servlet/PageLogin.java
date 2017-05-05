package com.javaids.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class PageLogin
 */
@WebServlet("/comments")
public class PageLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;
		String url = "jdbc:postgresql://localhost:5432/sr03";
        String user = "toto2";
        String password = "azerty";
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<!DOCTYPE html>");
        printWriter.print("<html>");
        printWriter.print("<head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        printWriter.print("<title>Session Test Servlet</title></head><body>");
        printWriter.print("List of comments");
        //String firstName = request.getParameter("fname");
        //printWriter.print(firstName);
        try {
	        //String query1 = "INSERT INTO comments (scientist_id,date,idea_id,content) VALUES (50,'30 Dec 2017',1,'COOOOOOOOOOOOOL');";
	        String query2 = "SELECT * FROM comments;";
	        con = DriverManager.getConnection(url, user, password);
	        st = con.createStatement();
	        rs = st.executeQuery(query2);
            while (rs.next()) {
            	printWriter.print("<p>");
            	printWriter.print("<br/>id : " + rs.getString(1));
            	printWriter.print("<br/>scientist_id : " + rs.getString(2));
            	printWriter.print("<br/>date : " + rs.getString(3));
            	printWriter.print("<br/>idea_id :" + rs.getString(4));
            	printWriter.print("<br/>content :" + rs.getString(5));
            	printWriter.print("</p>");
            }
            printWriter.print("</body></html>");
        } catch (SQLException ex) {
        	System.out.println(ex);
            /*Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);*/

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                /*Logger lgr = Logger.getLogger(Version.class.getName());*/
                /*lgr.log(Level.WARNING, ex.getMessage(), ex);*/
            }
        }
        
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;
		String url = "jdbc:postgresql://localhost:5432/sr03";
        String user = "toto2";
        String password = "azerty";
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<!DOCTYPE html>");
        printWriter.print("<html>");
        printWriter.print("<head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        printWriter.print("<title>Session Test Servlet</title></head><body>");
        String scientistId = request.getParameter("scientistId");
        Date current_date = Calendar.getInstance().getTime();
        String ideaId = request.getParameter("ideaId");
        String content = request.getParameter("content");
        //printWriter.print(firstName);
        try {
        	con = DriverManager.getConnection(url, user, password);
        	PreparedStatement pstmt = con.prepareStatement("insert into comments (scientist_id,date,idea_id,content) VALUES (?,?,?,?)");
        	pstmt.setInt(1, Integer.parseInt(scientistId));
        	pstmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
        	pstmt.setInt(3, Integer.parseInt(ideaId));
        	pstmt.setString(4, content);
	        rs = pstmt.executeQuery();
            while (rs.next()) {
            }
            printWriter.print("</body></html>");
        } catch (SQLException ex) {
        	System.out.println(ex);
            /*Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);*/

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                /*Logger lgr = Logger.getLogger(Version.class.getName());*/
                /*lgr.log(Level.WARNING, ex.getMessage(), ex);*/
            }
        }
        
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
