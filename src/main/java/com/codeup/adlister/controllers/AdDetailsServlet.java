package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Servlet to display the details of a specific ad
@WebServlet("/ads/details")
public class AdDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ad", DaoFactory.getAdsDao().findById(Long.parseLong(request.getParameter("adId"))));
        request.getRequestDispatcher("/WEB-INF/ads/details.jsp").forward(request, response);
    }
}
