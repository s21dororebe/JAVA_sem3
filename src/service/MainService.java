package service;

import model.users.User;
import model.users.BusinessUser;
import model.users.PrivateUser;
import model.users.GuestUser;
import model.Post;
import model.Page;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

import static model.PostType.privatePost;
import static model.PostType.publicPost;

public class MainService {

    public static ArrayList<User> allRegisteredUsers = new ArrayList<>();

    public static void main(String[] args) throws NoSuchAlgorithmException {
        GuestUser guest1 = new GuestUser();
        GuestUser guest2 = new GuestUser();

        System.out.println(guest1);
        System.out.println(guest2);

        PrivateUser private1 = new PrivateUser("Peter", "Richardson", "richpeter", "Richardson89");
        PrivateUser private2 = new PrivateUser("Olivia", "Peterson", "olivia20", "OliviaP20");
        allRegisteredUsers.add(private1);
        allRegisteredUsers.add(private2);
        System.out.println(private1);
        System.out.println(private2);

        BusinessUser business1 = new BusinessUser("SIA", "Ziedi", "ziedi", "Ziedi25");
        BusinessUser business2 = new BusinessUser("SIA", "Datori", "datori", "Datori12");
        allRegisteredUsers.add(business1);
        allRegisteredUsers.add(business2);
        System.out.println(business1);
        System.out.println(business2);

        System.out.println();
        System.out.println(Arrays.toString(allRegisteredUsers));

        Post post1 = new Post();
        Post post2 = new Post("This is my new account. I am glad to see my friends here. It is beautiful time today.");

        Page page1 = new Page();
        Page page2 = new Page();

        private1.createPost(post1, privatePost);
        private1.createPost(post1, publicPost);

        private2.createPost(post2, privatePost);
        private2.createPost(post2, publicPost);



        //TODO create register function for users
        //TODO create UserType enum privateUser, businessUser
        //public boolean register(String name, String surname, String username, String password, UserType type){
        // find in allRegisteredUsers - vai jau eksiste tads users
        // izvele, kads users tu busi (private / business)
        // }




    }
}
