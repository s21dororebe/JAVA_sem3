package service;

import model.PostType;
import model.users.*;
import model.Post;
import model.Page;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class MainService {

    public static ArrayList<User> allRegisteredUsers = new ArrayList<>();

    public static void main(String[] args) throws NoSuchAlgorithmException {
        GuestUser guest1 = new GuestUser();
        GuestUser guest2 = new GuestUser();

        PrivateUser private1 = new PrivateUser("Peter", "Richardson", "richpeter", "Richardson89");
        PrivateUser private2 = new PrivateUser("Olivia", "Peterson", "olivia20", "OliviaP20");
        allRegisteredUsers.add(private1);
        allRegisteredUsers.add(private2);

        BusinessUser business1 = new BusinessUser("SIA", "Ziedi", "ziiidiii22", "Ziedi25");
        BusinessUser business2 = new BusinessUser("SIA", "Datori", "datori11", "Datori12");
        allRegisteredUsers.add(business1);
        allRegisteredUsers.add(business2);

        private1.createPost(new Post("I like programming so much"), PostType.privatePost);
        private1.createPost(new Post("Hello everybody"), PostType.publicPost);
        private2.createPost(new Post("I am glad to see myself here"), PostType.privatePost);
        private2.createPost(new Post("I am glad to see you today"), PostType.publicPost);

        Page page1 = new Page("Ziedi Venstpils", "Flowers for all of your girls in Ventpils");
        Page page2 = new Page("Ziedi Liepaja", "Flowers for all of your girls in Liepaja");
        business1.addPage(page1);
        business1.addPage(page2);
        business1.createPostInPage(page1, business1.createPost(new Post("Discount 20%"), PostType.publicPost));
        business1.createPostInPage(page1, business1.createPost(new Post("Flowers for free for women"), PostType.publicPost));
        business1.createPostInPage(page2, business1.createPost(new Post("Discount 25%"), PostType.publicPost));

        System.out.println("Users:");
        System.out.println(guest1);
        System.out.println(guest2);
        System.out.println(private1);
        System.out.println(private2);
        System.out.println(business1);
        System.out.println(business2);
        System.out.println();

        System.out.println("Peter's posts:");
        for (Post temp: private1.getAllPrivatePosts()){
            System.out.println(temp);
        }
        for (Post temp: private1.getAllPublicPosts()){
            System.out.println(temp);
        }
        System.out.println();

        System.out.println("Ziedi posts:");
        for (Post temp: business1.getAllPages().get(0).getPostInPage()){
            System.out.println(temp);
        }
        System.out.println();

        //8. verify login func.
        System.out.println("Login function:");
//        guest1.login(); //nestrada => good
        System.out.println(private1.login());
        System.out.println(business1.login());
        System.out.println();
        //9. verify followPage func.
        System.out.println("followPage function:");
        try {
            page1.addFollower(private1);
            page1.addFollower(business1);
            page1.addFollower(business2);
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println(page1.getFollowers());
        System.out.println();
        //10. verify addFollower func.
        System.out.println("addFollower function:");
        private1.addFollower(private2);
        System.out.println(private1.getFollowers());
        System.out.println();
        //11. verify removeFollower func.
        System.out.println("removeFollower function:");
        private1.removeFollower(private2);
        System.out.println(private1.getFollowers());
        System.out.println();
        //12. verify increaseLikes func.
        System.out.println("increaseLikes function:");
        for(int i = 0; i < 10; i++){
            private1.getAllPrivatePosts().get(0).increaseLikes();
            if(i % 2 == 0)
                System.out.println(private1.getAllPrivatePosts().get(0));
        }
        System.out.println();

        System.out.println("FIND FUNCTIONS");
        System.out.println("findUsersByNameOrSurnameOrUsername");
        try {
            System.out.println("Search for 'Peter': " + private1.findUsersByNameOrSurnameOrUsername("Peter"));
            System.out.println("Search for 'Zakis': " + private1.findUsersByNameOrSurnameOrUsername("Zakis"));
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println();
        System.out.println("findPagesByTitleOrDescription");
        try {
            System.out.println("Search for 'ziedi': " + business1.findPagesByTitleOrDescription("ziedi"));
            System.out.println("Search for 'priede': " + business1.findPagesByTitleOrDescription("priede"));
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println();
        System.out.println("findPublicPostsInPrivateUserOrInPage");
        try {
            System.out.println("Search for 'Discount': " + business1.findPublicPostsInPrivateUserOrInPage("Discount"));
            System.out.println("Search for 'video': " + private1.findPublicPostsInPrivateUserOrInPage("video"));
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println();



    }

    //TODO create register function for users
    /*public boolean register(String name, String surname, String username, String password, UserType type){
     *//*find in allRegisteredUsers - vai jau eksiste tads users
     izvele, kads users tu busi (private / business)*//*
        for(User temp : allRegisteredUsers){
            if(username.equals(temp.getUsername())){
                return false;
            }
        }
        return true;
     }*/
}
