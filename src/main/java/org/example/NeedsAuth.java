package org.example;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class
public class NeedsAuth extends HttpServlet {
 
   // Method to handle GET method request.
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      // Set error code and reason.
      response.sendError(405, "Need authentication!!!" );
   }
   
   // Method to handle POST method request.
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      doGet(request, response);
   }
}