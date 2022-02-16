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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currentUser = (User) req.getSession().getAttribute("user");
        long userId = currentUser.getId();
        System.out.println("User Id:" + userId);
        String adId = req.getParameter("adId");
        System.out.println("Ad Id thru url: "+ adId);
        String id = req.getParameter("id");
        System.out.println("Ad Id thru jsp: " + id);
        String title = req.getParameter("title");
        System.out.println("Title: " + title);
        String description = req.getParameter("description");
        System.out.println("Description: " + description);
        Ad ad = new Ad(Long.parseLong(id), userId, title, description);
        DaoFactory.getAdsDao().editAdById(ad);
        resp.sendRedirect("/profile");
    }
}
