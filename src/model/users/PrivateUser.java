package model.users;

import model.Post;

import java.util.ArrayList;

public class PrivateUser extends User {
    private ArrayList<Post> privatePosts;
    private ArrayList<Post> publicPosts;
    private ArrayList<User> followers;

    //GETTERS
    public ArrayList<Post> getPrivatePosts() {
        return privatePosts;
    }
    public ArrayList<Post> getPublicPosts() {
        return publicPosts;
    }
    public ArrayList<User> getFollowers() {
        return followers;
    }

    //SETTERS
    public void setPrivatePosts(ArrayList<Post> inputPrivatePosts) {
        privatePosts = inputPrivatePosts;
    }
    public void setPublicPosts(ArrayList<Post> inputPublicPosts) {
        publicPosts = inputPublicPosts;
    }
    public void setFollowers(ArrayList<User> inputFollowers) {
        followers = inputFollowers;
    }

    //CONSTRUCTORS
    //TODO non argument constructor
    PrivateUser(){
//        setPrivatePosts();
//        setPublicPosts();
//        setFollowers();
    }
    PrivateUser(ArrayList<Post> inputPrivatePosts, ArrayList<Post> inputPublicPosts, ArrayList<User> inputFollowers){
        setPrivatePosts(inputPrivatePosts);
        setPublicPosts(inputPublicPosts);
        setFollowers(inputFollowers);
    }

    //TO_STRING
    @Override
    public String toString() {
        return "PrivateUser{" +
                "privatePosts=" + privatePosts +
                ", publicPosts=" + publicPosts +
                ", followers=" + followers +
                '}';
    }
}
