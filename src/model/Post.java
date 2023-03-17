package model;

import java.util.Date;

public class Post {
    private String msg;
    private Date date;
    private int countOfLikes;

    //GETTERS
    public String getMsg() {
        return msg;
    }
    public Date getDate() {
        return date;
    }
    public int getCountOfLikes() {
        return countOfLikes;
    }
    //SETTERS
    public void setDate(Date date) {
        this.date = date;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setCountOfLikes(int countOfLikes) {
        this.countOfLikes = countOfLikes;
    }
    //CONSTRUCTORS
    Post(){
//        setDate();
        setMsg("Unknown");
        setCountOfLikes(0);
    }
    Post(String msg, Date date, int countOfLikes){
        setDate(date);
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
