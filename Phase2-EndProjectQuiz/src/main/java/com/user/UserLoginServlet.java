package com.user;
import java.io.IOException;
import javax.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/userloginServlet")
public class UserLoginServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String email = request.getParameter("email");
String password = request.getParameter("password");
UserDAO userDAO = new UserDAO();
User user = userDAO.validateUser(email, password);
if (user != null) {
HttpSession session = request.getSession();
session.setAttribute("name", user.getName());
response.sendRedirect("Userdashboard.jsp");
} else {
request.setAttribute("error", "Invalid email or password");
request.getRequestDispatcher("Userlogin.jsp").forward(request, response);
}
}
}
