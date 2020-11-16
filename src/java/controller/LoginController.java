
package controller;

import dao.LoginDao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author NAM
 */

@WebServlet("/login")
public class LoginController extends HttpServlet{
    private LoginDao loginDao;
    @Override
    public void init() throws ServletException {
       loginDao = new LoginDao();
    }
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            authenticate(req, resp);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void authenticate(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, SQLException, ServletException, IOException{
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        
        User employee = new User();
        
        employee.setUserName(userName);
        employee.setPassword(password);
        
        if(loginDao.validate(employee)) {
            RequestDispatcher rd = req.getRequestDispatcher("todo/todolist.jsp");
            rd.forward(req, resp);
        }
        else {
            resp.sendRedirect("login/login.jsp");
        }
    }
}
