package com.javaids.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

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
        Statement st = null;
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
        String comment_ids = request.getParameter("commentIds");
        String scientist_id = request.getParameter("scientistId");
        String domain_ids = request.getParameter("domainIds");
        String content = request.getParameter("content");
        Date current_date = Calendar.getInstance().getTime();
        
        //printWriter.print(firstName);
        try {
	        String query1 = "INSERT INTO ideas (title,content,created_at,comment_ids,scientist_id,domain_ids) VALUES ('"+title+"','"+content+"','"+current_date+"','{"+comment_ids+"}','"+scientist_id+"','{"+domain_ids+"}');";
	        con = DriverManager.getConnection(url, user, password);
	        st = con.createStatement();
	        rs = st.executeQuery(query1);
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
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
