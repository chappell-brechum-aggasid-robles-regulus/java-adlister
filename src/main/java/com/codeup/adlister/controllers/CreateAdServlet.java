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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        String title = request.getParameter("title").trim();
        String description = request.getParameter("description").trim();
        String[] categories = request.getParameterValues("category");
        System.out.println(Arrays.toString(categories));
        boolean noTitle = title.isEmpty();
        boolean noDescription = description.isEmpty();
        if(noTitle && noDescription){
            request.getSession().setAttribute("createTitleFail",true);
            request.getSession().setAttribute("createDescriptionFail",true);
            response.sendRedirect("/ads/create");
        }else if (noTitle) {
            request.getSession().removeAttribute("createDescriptionFail");
            request.getSession().setAttribute("createTitleFail", true);
            response.sendRedirect("/ads/create");
        } else {
            request.getSession().removeAttribute("createTitleFail");
            if (noDescription) {
                request.getSession().setAttribute("createDescriptionFail", true);
                response.sendRedirect("/ads/create");
            } else {
                request.getSession().removeAttribute("createDescriptionFail");
                Ad ad = new Ad(
                        user.getId(),
                        request.getParameter("title"),
                        request.getParameter("description")
                );
                if(categories == null){
                    DaoFactory.getAdsDao().insert(ad);
                }else{
                    DaoFactory.getAdsDao().insertAdAndCategory(ad, categories);
                }
                response.sendRedirect("/ads");
            }
        }
    }
}
