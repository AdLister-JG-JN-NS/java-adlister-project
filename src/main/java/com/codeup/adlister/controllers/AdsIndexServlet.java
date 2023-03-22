package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Servlet to display all ads
@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery = request.getParameter("searchbar");
        if(searchQuery == null){
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
        }else{
            if(searchQuery.equals("*") || searchQuery.equals("") || searchQuery.equals(" ")){
                request.setAttribute("ads", DaoFactory.getAdsDao().all());
            }else {
                request.setAttribute("ads", DaoFactory.getAdsDao().search(searchQuery));

            }
        }

        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);

    }
}
