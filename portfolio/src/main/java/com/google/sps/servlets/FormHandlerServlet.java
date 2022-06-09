package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String name = request.getParameter("form-name");
    String email = request.getParameter("form-email");
    String message = request.getParameter("form-message");

    // Print the value so you can see it in the server logs.
    System.out.println("Hi " + name + "! Thank you for your message as: " + message + "\n and I will get back to you ASAP");

    // Write the value to the response so the user can see it.
    response.getWriter().println("Hi " + name + "! Thank you for your message as: " + message + "\n and I will get back to you ASAP");
    response.getWriter().println(email);

    // Redirect back to main page
    response.sendRedirect("http://dle-sps-summer22.appspot.com/");
  }
}