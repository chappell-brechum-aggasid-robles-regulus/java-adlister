package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="controllers.AdSearchServlet", urlPatterns = "/ads/search")
public class AdsSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String category = req.getParameter("category");
        String param = req.getParameter("query");
        List<Ad> results = new ArrayList<>();
        if(param != null){
            if(category.contains("0")) {
                results = DaoFactory.getAdsDao().searchAdByTitle(param);
            }else{
                results = DaoFactory.getAdsDao().searchAdByCategory(Long.parseLong(category), param);
            }
        }
        req.setAttribute("ads", results);
        req.setAttribute("query", param);
        req.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(req, resp);
    }
}
