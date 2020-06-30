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
    private String postText;
    private String dateText;
    private String nameText;
    private String timeText;

    public postType() {
    }

    public postType(String postText, String dateText, String nameText, String timeText) {
        this.postText = postText;
        this.dateText = dateText;
        this.nameText = nameText;
        this.timeText = timeText;
    }
    
    
}
