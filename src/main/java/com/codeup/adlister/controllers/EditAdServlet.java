package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditAdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("edit"));
        Ad ad = DaoFactory.getAdsDao().findById(id);
        req.setAttribute("ad", ad);
        req.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("adId"));
        long userId = Long.parseLong(req.getParameter("userId"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String company = req.getParameter("company");
        long salary = Long.parseLong(req.getParameter("salary"));
        String jobType = req.getParameter("job_type");
        String location = req.getParameter("location");

        Ad ad = new Ad(id, userId, title, description, company, jobType, location, salary);
        DaoFactory.getAdsDao().edit(ad);

        resp.sendRedirect("/ads/details?adId=" + ad.getId());
    }
}
