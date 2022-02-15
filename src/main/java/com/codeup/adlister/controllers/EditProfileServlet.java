package com.codeup.adlister.controllers;

import com.codeup.adlister.models.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile-edit")
public class EditProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("user");
        if (currentUser == null) {
            response.sendRedirect("/login");
            return;
        } else {
            String username = currentUser.getUsername();
            String email = currentUser.getEmail();
            int id = (int) currentUser.getId();
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("email", email);
            request.getSession().setAttribute("id", id);
        }
        request.getRequestDispatcher("/WEB-INF/profile-edit.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
