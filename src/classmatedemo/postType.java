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
public class postType {

    public String getPostText() {
        return postText;
    }

    public String getDateText() {
        return dateText;
    }

    public String getNameText() {
        return nameText;
    }

    public String getTimeText() {
        return timeText;
    }
    public String getStateText() {
        return stateText;
    }
    private String postText;
    private String dateText;
    private String nameText;
    private String timeText;
    private String stateText;

    public postType() {
    }

    public postType(String postText, String dateText, String nameText, String timeText,String stateText) {
        this.postText = postText;
        this.dateText = dateText;
        this.nameText = nameText;
        this.timeText = timeText;
        this.stateText = stateText;
    }
    
    
}
