package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/profile/delete")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("user");
        long userId = currentUser.getId();

        DaoFactory.getUsersDao().deleteUser(userId);
        /*try {
            DaoFactory.getAdsDao().deleteByUser(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        request.getSession().invalidate();
        request.getRequestDispatcher("/WEB-INF/delete.jsp").forward(request, response);
    }
}
