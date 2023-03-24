package model;

import model.users.User;

import java.util.ArrayList;

public class Page {
    private String title;
    private String description;
    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<Post> postsInPage = new ArrayList<>();

    //GETTERS
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public ArrayList<User> getFollowers() {
        return followers;
    }
    public ArrayList<Post> getPostsInPage() {
        return postsInPage;
    }
    //SETTERS
    public void setTitle(String inputTitle) {
        if(inputTitle != null && inputTitle.length() > 4 && inputTitle.length() < 30){
            title = inputTitle;
        } else {
            title = "---TITLE---";
        }
    }
    public void setDescription(String inputDescription) {
        if(inputDescription != null && inputDescription.length() > 10 && inputDescription.length() < 300){
            description = inputDescription;
        } else {
            description = "---DESCRIPTION---";
        }
    }
    public void addFollower(User follower) {
        //PARBAUDE AR REFERENCI
        if(follower!= null && !followers.contains(follower)){
            followers.add(follower);
        }
    }
    public void removeFollowers(User follower) {
        if(follower!= null && followers.contains(follower)){
            followers.remove(follower);
        }
    }
    public void addPostInPage(Post post) {
        if(post != null){
            postsInPage.add(post);
        }
    }
    public void removePostInPage(Post post) {
        if(post != null && postsInPage.contains(post)){
            postsInPage.remove(post);
        }
    }
    //CONSTRUCTORS
    Page(){
        setTitle("Unknown");
        setDescription("Unknown");
    }
    Page(String title, String description){
        setTitle(title);
        setDescription(description);
    }
    //TO_STRING
    @Override
    public String toString() {
        return "Page{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", postsInPage=" + postsInPage +
                '}';
    }
}
