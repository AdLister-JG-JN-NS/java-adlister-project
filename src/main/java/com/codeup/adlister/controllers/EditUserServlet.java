package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// Servlet to edit a user
@WebServlet("/user/edit")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/users/editUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long userId = Long.parseLong(request.getParameter("userId"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirmPassword");

        // validate input
        boolean inputHasErrors = username.isEmpty()
                || email.isEmpty();

        if (inputHasErrors) {
            response.sendRedirect("/user/edit");
            return;
        }

        User user;
        if(password.isEmpty() || (! password.equals(passwordConfirmation))){
            user = new User(userId, username, email);
        }else {
            user = new User(userId, username, email, password);
        }

        DaoFactory.getUsersDao().edit(user);
        request.getSession().removeAttribute("user");
        request.getSession().setAttribute("user", user);
        response.sendRedirect("/profile");
    }
}
