package model.users;

import model.Page;
import model.Post;
import model.PostType;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;

public class BusinessUser extends User {
    private final ArrayList<Page> allPages = new ArrayList<>();

    public BusinessUser(String name, String surname, String username, String inputEncodedPassword) throws NoSuchAlgorithmException {
        super(name, surname, username, inputEncodedPassword);
    }

    public ArrayList<Page> getAllPages() {
        return allPages;
    }

    public void addPage(Page page){
        if(page != null && !allPages.contains(page)) {
            allPages.add(page);
        }
    }
    public void removePage(Page page){
        if(page != null && allPages.contains(page)) {
            allPages.remove(page);
        }
    }
    @Override
    public Post createPost(Post post, PostType type) {
        return Objects.requireNonNullElseGet(post, Post::new);
    }
    public void createPostInPage(Page page, Post post){
        if(page != null && post != null && !page.getPostInPage().contains(post)){
            page.getPostInPage().add(post);
        }
    }
}
