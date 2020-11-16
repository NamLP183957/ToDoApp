
package controller;

import dao.ToDoDao;
import dao.ToDoDaoImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ToDo;

/**
 *
 * @author NAM
 */
@WebServlet("/")
public class ToDoController extends HttpServlet{
    private ToDoDao toDoDao;
    @Override
    public void init() throws ServletException {
        toDoDao = new ToDoDaoImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getServletPath();
            switch(action) {
                case "/new":
                    showNewForm(req, resp);
                    break;
                case "/insert":
                    insertTodo(req, resp);
                    break;
                case "/delete":
                    deleteTodo(req, resp);
                    break;
                case "/edit":
                    showEditForm(req, resp);
                    break;
                case "/update":
                    updateTodo(req, resp);
                    break;
                case "/list":
                    listToDo(req, resp);
                    break;
                case "/logout":
                    resp.sendRedirect("https://www.youtube.com/");
                    break;
                default:
                    RequestDispatcher rd = req.getRequestDispatcher("login/login.jsp");
                    rd.forward(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("todo/todo_form.jsp");
        rd.forward(req, resp);
    }
    
    private void listToDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ToDo> listTodo = toDoDao.selectionAllToDo();
        req.setAttribute("listTodo", listTodo);
        RequestDispatcher rd = req.getRequestDispatcher("todo/todolist.jsp");
        rd.forward(req, resp);
    }
    
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        ToDo exitingTodo = toDoDao.selectToDo(id);
        RequestDispatcher rd = req.getRequestDispatcher("todo/todo_form.jsp");
        req.setAttribute("todo", exitingTodo);
        rd.forward(req, resp);
    }
    
    private void insertTodo(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        String title = req.getParameter("title");
        String userName = req.getParameter("username");
        String description = req.getParameter("description");
        LocalDate date = LocalDate.parse(req.getParameter("target_date"));
        boolean isDone = Boolean.valueOf(req.getParameter("is_done"));
        
        ToDo toDo = new ToDo(title, userName, description, isDone, date);
        toDoDao.insetToDo(toDo);
        resp.sendRedirect("list");
    }
    
    private void updateTodo(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        
        String title = req.getParameter("title");
        String userName = req.getParameter("username");
        String description = req.getParameter("description");
        LocalDate date = LocalDate.parse(req.getParameter("target_date"));
        boolean isDone = Boolean.valueOf(req.getParameter("is_done"));
        
        ToDo toDo = new ToDo(id, title, userName, description, isDone, date);
        toDoDao.updateToDo(toDo);
        resp.sendRedirect("list");
    }
    
    private void deleteTodo(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        toDoDao.deleteToDo(id);
        resp.sendRedirect("list");
    }
}
