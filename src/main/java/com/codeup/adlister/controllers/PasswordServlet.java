package com.codeup.adlister.controllers;

import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reset")
public class PasswordServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User currentUser = (User) request.getSession().getAttribute("user");
        if (currentUser == null) {
            response.sendRedirect("/login");
            return;
        } else {
            String username = currentUser.getUsername();
            int id = (int) currentUser.getId();
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("id", id);
            request.getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User currentUser = (User) request.getSession().getAttribute("user");
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");
        String passwordConfirmation = request.getParameter("confirm_password");
        boolean incorrectPass = Password.check(oldpassword, currentUser.getPassword());
        boolean inputHasErrors = oldpassword.isEmpty()
                || newpassword.isEmpty()
                || (! newpassword.equals(passwordConfirmation));
        if(incorrectPass){
            // Add Error Message, Password Incorrect
            response.sendRedirect("/reset");
        } else if (inputHasErrors){
            // Add Error Message, New Password and Confirmation do not match
            response.sendRedirect("/reset");
        } else {
            // Add usersDAO function to change password
            // Add Success Message
            response.sendRedirect("/reset");
        }

    }

}