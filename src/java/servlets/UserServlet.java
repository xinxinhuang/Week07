package servlets;

import businesslogic.UserService;
import domainmodel.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<User> users = null;
        UserService user = new UserService();
        try {
            users = (ArrayList<User>) user.getAll();
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = (String) request.getAttribute("action");
        String username = (String) request.getAttribute("username");
        String password = (String) request.getAttribute("password");
        String email = (String) request.getAttribute("email");
        String firstname = (String) request.getAttribute("firstname");
        String lastname = (String) request.getAttribute("lastname");
        UserService user = new UserService();
        
        if (action.equals("delete")) {
            try {
                user.delete(username);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equals("edit")) {
            try {
                user.update(username, password, email);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (action.equals("add"))
        {
            try {
                user.insert(username, password, email, 1, firstname, lastname);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
