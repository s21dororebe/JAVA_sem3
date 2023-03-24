package model.users;

import model.Post;

import java.util.ArrayList;

public class PrivateUser extends AbstractUser {
    private ArrayList<Post> privatePosts;
    private ArrayList<Post> publicPosts;
    private ArrayList<AbstractUser> followers;

    //GETTERS
    public ArrayList<Post> getPrivatePosts() {
        return privatePosts;
    }
    public ArrayList<Post> getPublicPosts() {
        return publicPosts;
    }
    public ArrayList<AbstractUser> getFollowers() {
        return followers;
    }

    //SETTERS
    public void setPrivatePosts(ArrayList<Post> inputPrivatePosts) {
        privatePosts = inputPrivatePosts;
    }
    public void setPublicPosts(ArrayList<Post> inputPublicPosts) {
        publicPosts = inputPublicPosts;
    }
    public void setFollowers(ArrayList<AbstractUser> inputFollowers) {
        followers = inputFollowers;
    }

    //CONSTRUCTORS
    //TODO non argument constructor
    PrivateUser(){
//        setPrivatePosts();
//        setPublicPosts();
//        setFollowers();
    }
    PrivateUser(ArrayList<Post> inputPrivatePosts, ArrayList<Post> inputPublicPosts, ArrayList<AbstractUser> inputFollowers){
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
