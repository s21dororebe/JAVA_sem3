package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String msg;
    private LocalDateTime dateTime;
    //TODO need to change to ArrayList of user, which set the like to this post
    private int countOfLikes = 0;

    //GETTERS
    public String getMsg() {
        return msg;
    }
    public LocalDateTime getDate() {
        return dateTime;
    }
    public int getCountOfLikes() {
        return countOfLikes;
    }
    //SETTERS
    public void setDate() {
        this.dateTime = LocalDateTime.now();
    }
    public void setMsg(String inputMsg) {
        if(inputMsg != null && inputMsg.length() > 3){
            msg = inputMsg;
        } else {
            msg = "----";
        }
    }
    public void increaseLikes() {
        countOfLikes++;
    }
    //CONSTRUCTORS
    Post(){
        setDate();
        setMsg("Test message");
    }
    Post(String msg){
        setDate();
        setMsg(msg);
    }
    //TO_STRING
    //24/03/2023 13:57 -> message (0)
    @Override
    public String toString() {
        return dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")) + " -> " + msg + " (" + countOfLikes + ") ";
    }
}
