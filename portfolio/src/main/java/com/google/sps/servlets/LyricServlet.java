package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles requests sent to /lyric URL
 */
@WebServlet("/lyric")
public class LyricServlet extends HttpServlet {

    private static final ArrayList<String> lyrics = new ArrayList<>(List.of("That Arizona sky burnin' in your eyes", "You look at me and, babe, I wanna catch on fire", "It's buried in my soul like California gold", "You found the light in me that I couldn't find"));
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        String lyric = convertToJSON(lyrics);
        response.getWriter().print(lyric);
    }

    private static final String convertToJSON(List<String> list)
    {
        Gson converter = new Gson();
        return converter.toJson(list);
    }
}
