package model;

import java.time.LocalDateTime;

public class Post {
    private String msg;
    private LocalDateTime dateTime;
    //TODO need to change to ArrayList of user, which set the like to this post
    private int countOfLikes;

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
        setMsg("Unknown");
    }
    Post(String msg){
        setDate();
        setMsg(msg);
    }
    //TO_STRING
    @Override
    public String toString() {
        return "Post{" +
                "msg='" + msg + '\'' +
                ", dateTime=" + dateTime +
                ", countOfLikes=" + countOfLikes +
                '}';
    }
}
