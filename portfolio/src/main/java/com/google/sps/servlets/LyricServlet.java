package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests sent to /lyric URL
 */
@WebServlet("/lyric")
public class LyricServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().print("That Arizona sky burnin' in your eyes \n You look at me and, babe, I wanna catch on fire \n It's buried in my soul like California gold \n You found the light in me that I couldn't find");
    }
}
