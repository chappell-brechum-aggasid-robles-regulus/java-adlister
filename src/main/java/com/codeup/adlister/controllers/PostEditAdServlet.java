package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ads/updateAd")
public class PostEditAdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect("/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("user");
        long userId = currentUser.getId();
        long id = Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String[] categories = req.getParameterValues("category");
        Ad ad = new Ad(id, userId, title, description);
        DaoFactory.getAdsDao().editAdById(ad, categories);
        resp.sendRedirect("/profile");
    }
}
