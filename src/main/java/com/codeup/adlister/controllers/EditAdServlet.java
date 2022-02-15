package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLAdsDao;
import com.codeup.adlister.models.Ad;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ads/editAd")
public class EditAdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adId = req.getParameter("id");
        Ad existingAd = DaoFactory.getAdsDao().getAdById(Long.valueOf(adId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/ads/edit.jsp");
        req.setAttribute("ad", existingAd);
        dispatcher.forward(req, resp);
    }
}
