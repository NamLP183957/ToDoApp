
package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author NAM
 */
public class ToDo implements Serializable{
    
    private long id;
    private String title;
    private String userName;
    private String description;
    private boolean isDone;
    private LocalDate targetDate;
    
    public ToDo(){
        
    }
    public ToDo(long id, String title, String userName, String description, boolean isDone, LocalDate targetDate){
        super();
        this.id = id;
        this.title = title;
        this.userName = userName;
        this.description = description;
        this.isDone = isDone;
        this.targetDate = targetDate;
    }
    
    public ToDo(String title, String userName, String description, boolean isDone, LocalDate targetDate){
        super();
        this.title = title;
        this.userName = userName;
        this.description = description;
        this.isDone = isDone;
        this.targetDate = targetDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
    
    
}
