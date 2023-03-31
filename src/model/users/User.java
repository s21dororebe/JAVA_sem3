package model.users;

import model.Page;
import model.Post;
import model.PostType;
import service.MainService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class User extends GuestUser {
    private String name; //for business User it will be name of owner
    private String surname;
    private String username;
    private String encodedPassword;

    //GETTERS
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return encodedPassword;
    }
    //SETTERS
    public void setName(String inputName) {
        if (inputName != null && inputName.matches("[A-ZĀĒŖŪĪĻĶĢŠŽČŅ][a-zēŗūīļķģšāžčņ]+[ ]?([A-ZĀĒŖŪĪĻĶĢŠŽČŅ][a-zēŗūīļķģšāžčņ]+)?") )
            name = inputName;
        else
            name = "name";
    }
    public void setSurname(String inputSurname) {
        if (inputSurname != null && inputSurname.matches("[A-ZĀĒŖŪĪĻĶĢŠŽČŅ][a-zēŗūīļķģšāžčņ]+[ ]?([A-ZĀĒŖŪĪĻĶĢŠŽČŅ][a-zēŗūīļķģšāžčņ]+)?") )
            surname = inputSurname;
        else
            surname = "surname";
    }
    public void setUsername(String inputUsername) {
        //no a lidz z burtiem, no 0 lidz 9 cipari un vel punktins [] iekavaas
        //no 8 lidz 20 simboliem username
        if (inputUsername != null && inputUsername.matches("[a-z0-9.]{8,20}") )
            username = inputUsername;
        else
            username = "default.user";
    }
    public void setEncodedPassword(String inputEncodedPassword) {
        if (inputEncodedPassword != null && inputEncodedPassword.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$" )){
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(inputEncodedPassword.getBytes());
                encodedPassword = new String(md.digest());
            } catch (Exception e){
                encodedPassword = "P@ssw0rd";
            }
        }
        else {
            encodedPassword = "P@ssw0rd";
        }
    }
    //CONSTRUCTORS
    public User() throws NoSuchAlgorithmException {
        super();
        setName("name");
        setSurname("surname");
        setUsername("default.user");
        setEncodedPassword("P@ssw0rd");
    }
    public User(String name, String surname, String username, String inputEncodedPassword) throws NoSuchAlgorithmException {
        super();
        setName(name);
        setSurname(surname);
        setUsername(username);
        setEncodedPassword(inputEncodedPassword);
    }
    //TO_STRING
    @Override
    public String toString() {
        return "RU No. " + getGeneratedId() + ": " + name + " " + surname + ", " + username;
    }

    //OTHER FUNCTIONS
    //TODO followPage()
    public boolean login(){
        for(User temp : MainService.allRegisteredUsers) {
            if(temp.getUsername().equals(username) && temp.getPassword().equals(encodedPassword)){
                return true;
            }
        }
        return false;
    }
    public void followPage(Page page) throws Exception {
        if(page == null){
            throw (new Exception("ERROR 404: Page not found"));
        }
        page.addFollower(this);
    }
    public void unFollowPage(Page page) throws Exception {
        if(page == null){
            throw (new Exception("ERROR 404: Page not found"));
        }
        page.removeFollower(this);
    }

    //TWO WAYS TO DEFINE ABSTRACT FUNCTIONS
    //1.
    public abstract Post createPost(Post post, PostType type);
    //2.
//    public interface IPostCreation{
//        Post createPost(Post post, PostType type);
//    }

}
