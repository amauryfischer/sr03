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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        printWriter.print("welcome");
        String firstName = request.getParameter("fname");
        printWriter.print(firstName);
        try {
	        String query1 = "INSERT INTO comments (scientist_id,date,idea_id,content) VALUES (50,'30 Dec 2017',1,'COOOOOOOOOOOOOL');";
	        String query2 = "SELECT * FROM comments;";
	        con = DriverManager.getConnection(url, user, password);
	        st = con.createStatement();
	        rs = st.executeQuery(query2);
            while (rs.next()) {
            	printWriter.print(rs.getString(1));
            	printWriter.print(rs.getString(2));
            	printWriter.print(rs.getString(3));
            	printWriter.print(rs.getString(4));
            	printWriter.print(rs.getString(5));
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
