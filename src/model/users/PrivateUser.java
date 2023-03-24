package model.users;

import model.Post;
import model.PostType;

import java.util.ArrayList;

public class PrivateUser extends User {
    private final ArrayList<Post> allPrivatePosts = new ArrayList<>();
    private final ArrayList<Post> allPublicPosts = new ArrayList<>();
    private final ArrayList<PrivateUser> followers = new ArrayList<>();

    //GETTERS
    public ArrayList<Post> getAllPrivatePosts() {
        return allPrivatePosts;
    }
    public ArrayList<Post> getAllPublicPosts() {
        return allPublicPosts;
    }
    public ArrayList<PrivateUser> getFollowers() {
        return followers;
    }

    public void addFollower(PrivateUser follower) {
        if(follower!= null && !followers.contains(follower)){
            followers.add(follower);
        }
    }
    public void removeFollower(PrivateUser follower) {
        if(follower!= null && followers.contains(follower)){
            followers.remove(follower);
        }
    }

    @Override
    public Post createPost(Post post, PostType type) {
        if(type.equals(PostType.privatePost) && !allPrivatePosts.contains(post)){
            allPrivatePosts.add(post);
        } else if(type.equals(PostType.publicPost) && !allPublicPosts.contains(post)){
            allPublicPosts.add(post);
        } else {
            return null;
        }
        return post;
    }
}
