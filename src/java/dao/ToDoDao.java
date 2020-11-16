
package dao;

import java.sql.SQLException;
import java.util.List;
import model.ToDo;

/**
 *
 * @author NAM
 */
public interface ToDoDao {
    void insetToDo(ToDo toDo) throws SQLException;
    
    ToDo selectToDo(long toDoId);
    
    List<ToDo> selectionAllToDo();
    
    boolean deleteToDo(long toDoId) throws SQLException;
    
    boolean updateToDo(ToDo toDo) throws SQLException;
}
