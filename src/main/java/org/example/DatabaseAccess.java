package org.example;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class DatabaseAccess extends HttpServlet{
    private static final long serialVersionUID = 1L;
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";  
    static final String DB_URL="jdbc:mariadb://localhost/marbdb";

    //  Database credentials
    static final String USER = "marb";
    static final String PASS = "secret";

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      
      out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor = \"#f0f0f0\">\n" +
         "<h1 align = \"center\">" + title + "</h1>\n");

      try {
         // Register JDBC driver
         Class.forName("org.mariadb.jdbc.Driver");
         // Open a connection


         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         Statement stmt= conn.createStatement();
         String sql;
         sql = "SELECT name, note FROM marvin";
         ResultSet rs = stmt.executeQuery(sql);

         // Extract data from result set
         while(rs.next()){
            //Retrieve by column name
            String first = rs.getString("name");
            String last = rs.getString("note");

            //Display values
            out.println("Name: " + first + "<br>");
            out.println(", Note: " + last + "<br>");
         }
         out.println("</body></html>");

         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      } catch(SQLException se) {
         //Handle errors for JDBC
         se.printStackTrace();
      } catch(Exception e) {
         //Handle errors for Class.forName
         e.printStackTrace();
      } finally {
         //finally block used to close resources
        //  try {
        //     if(stmt!=null) stmt.close();
        //  } catch(SQLException se2) {
        //  } // nothing we can do
        //  try {
        //     if(conn!=null) conn.close();
        //  } catch(SQLException se) {
        //     se.printStackTrace();
        //  } //end finally try
      } //end try
   }
} 