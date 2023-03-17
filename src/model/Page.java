package model;

import java.util.ArrayList;

public class Page {
    private String title;
    private String description;
    private ArrayList<Post> postsInPage;

    /*
    private ArrayList<User> followers; //see User class description below
    public ArrayList<User> getFollowers() {
        return followers;
    }
    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }
    */
    //GETTERS
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public ArrayList<Post> getPostsInPage() {
        return postsInPage;
    }
    //SETTERS
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPostsInPage(ArrayList<Post> postsInPage) {
        this.postsInPage = postsInPage;
    }
    //CONSTRUCTORS
    Page(){
        setTitle("Unknown");
        setDescription("Unknown");
//        setPostsInPage();
    }
    Page(String title, String description, ArrayList<Post> postsInPage){
        setTitle("title");
        setDescription("description");
        setPostsInPage(postsInPage);
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
