/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classmatedemo;

/**
 *
 * @author Asus
 */
public class DeadlineType {

    public String getThreadText() {
        return threadText;
    }

    public String getTaskText() {
        return taskText;
    }

    public String getDateText() {
        return dateText;
    }

    public String getTimeText() {
        return timeText;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    private String threadText;
    private String taskText;
    private String dateText;
    private String timeText;
    private String descriptionText;

    public DeadlineType(){
        
    }
    public DeadlineType(String threadText, String taskText,String dateText,String timeText,String descriptionText ){
        this.threadText=threadText;
        this.dateText=dateText;
        this.timeText=timeText;
        this.taskText=taskText;
        this.descriptionText=descriptionText;
    }
    
    
}
