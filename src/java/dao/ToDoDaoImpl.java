/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.ToDo;

/**
 *
 * @author ADMIN
 */
public class ToDoDaoImpl implements ToDoDao{

    @Override
    public void insetToDo(ToDo toDo) throws SQLException {
        try {
            Connection connection = JDBCUtils.getConnection();
            String INSERT_TODO = "INSERT INTO todos "
                    + "(title, username, description, is_done, target_date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(INSERT_TODO);
            statement.setString(1, toDo.getTitle());
            statement.setString(2, toDo.getUserName());
            statement.setString(3, toDo.getDescription());
            statement.setBoolean(4, toDo.isIsDone());
            statement.setDate(5, JDBCUtils.getSQLDate(toDo.getTargetDate()));
            
            statement.executeUpdate();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public ToDo selectToDo(long toDoId) {
       ToDo toDo = null;
        try {
            Connection connection = JDBCUtils.getConnection();
            String SELECT_SQL = "SELECT id, title, username, description, is_done, target_date "
                    + "FROM todos WHERE id = ?";
            
            PreparedStatement statement = connection.prepareStatement(SELECT_SQL);
            statement.setLong(1, toDoId);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()) {
                long id = rs.getLong("id");
                String title = rs.getString("title");
                String userName = rs.getString("username");
                String description = rs.getString("description");
                LocalDate target_date = rs.getDate("target_date").toLocalDate();
                boolean is_done = rs.getBoolean("is_done");
                
                toDo = new ToDo(id, title, userName, description, is_done, target_date);
            
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return toDo;
    }

    @Override
    public List<ToDo> selectionAllToDo() {
        List<ToDo> list = new ArrayList<>();
        ToDo todo = null;
        try {
            Connection connection = JDBCUtils.getConnection();
            String SELECT_ALL_SQL = "SELECT id, title, username, description, is_done, target_date FROM todos";
            
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SQL);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                long id = rs.getLong("id");
                String title = rs.getString("title");
                String userName = rs.getString("username");
                String description = rs.getString("description");
                LocalDate target_date = rs.getDate("target_date").toLocalDate();
                boolean is_done = rs.getBoolean("is_done");
                
                todo = new ToDo(id, title, userName, description, is_done, target_date);
                list.add(todo);
            }
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteToDo(long toDoId) throws SQLException {
        boolean status = false;
        try {
            
            Connection connection = JDBCUtils.getConnection();
            String DELETE_BYID_SQL = "DELETE FROM Todos WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(DELETE_BYID_SQL);
            statement.setLong(1, toDoId);
            
            status = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return status;
    }

    @Override
    public boolean updateToDo(ToDo toDo) throws SQLException {
        boolean status = false;
        
        try {
            Connection connection = JDBCUtils.getConnection();
            String UPDATE_SQL = "UPDATE todos "
                    + "SET title = ?, username = ?, description = ?, is_done = ?, target_date = ? "
                    + "WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(UPDATE_SQL);
            statement.setString(1, toDo.getTitle());
            statement.setString(2, toDo.getUserName());
            statement.setString(3, toDo.getDescription());
            statement.setBoolean(4, toDo.isIsDone());
            statement.setDate(5, JDBCUtils.getSQLDate(toDo.getTargetDate()));
            statement.setLong(6, toDo.getId());
            status = statement.executeUpdate() > 0;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return status;
    }
    
}
