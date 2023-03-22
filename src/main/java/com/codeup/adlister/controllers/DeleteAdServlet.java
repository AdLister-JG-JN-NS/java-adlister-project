package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
// Servlet to delete an ad
@WebServlet(name = "DeleteAdServlet", value = "/delete")
public class DeleteAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/ads");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String adId = request.getParameter("delete");
        if(adId != null){
            DaoFactory.getAdsDao().delete(DaoFactory.getAdsDao().findById(Long.parseLong(adId)));
            System.out.printf("deleted %s%n", adId);
        }else{
            System.out.printf("could not delete %s%n", adId);
        }
        response.sendRedirect("/ads");

    }
}
