package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
// servlet to delete a user
@WebServlet("/user/delete")
public class DeleteUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("deleteUsername");
        if(username != null){
            User user = DaoFactory.getUsersDao().findByUsername(username);
            List<Ad> ads = DaoFactory.getAdsDao().all();
            for (Ad ad : ads) {
                if (ad.getUserId() == user.getId()) {
                    System.out.printf("delete %s\n", ad.getTitle());
                    DaoFactory.getAdsDao().delete(ad);
                }
            }
            DaoFactory.getUsersDao().delete(user);
            System.out.printf("deleted %s%n", username);
            JOptionPane.showMessageDialog(null, "User deleted");
        }else{
            System.out.print("could not delete user");
        }
        response.sendRedirect("/logout");
    }
}
