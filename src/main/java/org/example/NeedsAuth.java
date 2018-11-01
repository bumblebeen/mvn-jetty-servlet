package org.example;

// Import required java libraries
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;// Import required java libraries

// Extend HttpServlet class
public class NeedsAuth extends HttpServlet {
    private static final long serialVersionUID = 4L;
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