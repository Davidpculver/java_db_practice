package controllers;

import dao.DaoFactory;
import models.User;
import util.VerifyData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateProfile")
public class UpdateProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        User loggedInUser = (User) request.getSession().getAttribute("user");
        String username = loggedInUser.getUsername();
        request.setAttribute("username", username);
        request.getRequestDispatcher("/WEB-INF/updateProfile.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User loggedInUser = (User) request.getSession().getAttribute("user");
        String userName = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        boolean isValidEmail = VerifyData.isValidEmail(email);
        boolean emailDoesNotExist = VerifyData.userEmailNotExist(email);

        System.out.println(isValidEmail);
        System.out.println(emailDoesNotExist);

        if(isValidEmail && emailDoesNotExist){
            System.out.println("this works");
            DaoFactory.getUsersDao().updateUser(email, userName);
        }

        System.out.println(userName);
        System.out.println(email);

    }
}

