package controllers;

import dao.DaoFactory;
import models.Ad;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/searchAds")
public class SearchAdsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchForAd = request.getParameter("search");
        request.setAttribute("search", searchForAd);
        request.setAttribute("ads", DaoFactory.getAdsDao().searchForAds(searchForAd));
        request.getRequestDispatcher("/WEB-INF/ads/searchResults.jsp").forward(request, response);
    }
}
