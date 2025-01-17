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

//<% when the user goes to the ad page, it redirects them to show the individual ads that were created %>
@WebServlet(name = "IndividualAdServlet", urlPatterns = "/showAd")
public class IndividualAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adId = request.getParameter("adId");
        int ad_id = Integer.parseInt(request.getParameter("adId"));
        Ad adResult = DaoFactory.getAdsDao().getAdById(Long.valueOf(adId));
        request.setAttribute("categories", DaoFactory.getCategoriesDao().searchCategoriesByAdId(ad_id));
        request.setAttribute("ad", adResult);
        Long adUserId = adResult.getUserId();
        User userResult = DaoFactory.getUsersDao().getUserById(adUserId);
        request.setAttribute("userInfo", userResult);
        request.getRequestDispatcher("/WEB-INF/ads/showAds.jsp").forward(request, response);
    }
}
