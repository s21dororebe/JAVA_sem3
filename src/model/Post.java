package model;

import java.time.LocalDateTime;

public class Post {
    private String msg;
    private LocalDateTime date;
    private int countOfLikes;

    //GETTERS
    public String getMsg() {
        return msg;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public int getCountOfLikes() {
        return countOfLikes;
    }
    //SETTERS
    public void setDate() {
        this.date = LocalDateTime.now();
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setCountOfLikes(int countOfLikes) {
        this.countOfLikes = countOfLikes;
    }
    //CONSTRUCTORS
    Post(){
        setDate();
        setMsg("Unknown");
        setCountOfLikes(0);
    }
    Post(String msg, LocalDateTime date, int countOfLikes){
        setDate();
        setMsg(msg);
        setCountOfLikes(countOfLikes);
    }
    //TO_STRING
    @Override
    public String toString() {
        return "Post{" +
                "msg='" + msg + '\'' +
                ", date=" + date +
                ", countOfLikes=" + countOfLikes +
                '}';
    }
}
