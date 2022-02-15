package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//<% when the user goes to the ad page, it redirects them to show the individual ads that were created %>
@WebServlet(name = "IndividualAdServlet", urlPatterns = "/showAd")
public class IndividualAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String pathInfo = request.getPathInfo();
//        int adId = Integer.parseInt(pathInfo.substring(1));
        Long adId = Long.parseLong(request.getParameter("adId"));
        request.setAttribute("ad", DaoFactory.getAdsDao().getAdById(adId));
        request.getRequestDispatcher("/WEB-INF/ads/showAds.jsp").forward(request, response);
    }
}
