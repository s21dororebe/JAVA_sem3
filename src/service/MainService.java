package service;

import model.PostType;
import model.users.User;
import model.users.BusinessUser;
import model.users.PrivateUser;
import model.users.GuestUser;
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


        //TODO create register function for users
        //TODO create UserType enum privateUser, businessUser
        //public boolean register(String name, String surname, String username, String password, UserType type){
        // find in allRegisteredUsers - vai jau eksiste tads users
        // izvele, kads users tu busi (private / business)
        // }

    }
}
