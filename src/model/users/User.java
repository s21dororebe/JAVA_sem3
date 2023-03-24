package model.users;

class AbstractUser extends GuestUser {
    private String nameAndSurname;
    private String username;
    private String password;

    //GETTERS
    public String getNameAndSurname() {
        return nameAndSurname;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    //SETTERS
    public void setNameAndSurname(String nameAndSurname) {
        if (nameAndSurname != null && nameAndSurname.matches("[A-ZĀĒŖŪĪĻĶĢŠŽČŅ]{1}[a-zēŗūīļķģšāžčņ]+[ ]?([A-ZĀĒŖŪĪĻĶĢŠŽČŅ]{1}[a-zēŗūīļķģšāžčņ]+)?") )
            nameAndSurname = nameAndSurname;
        else
            nameAndSurname = "Unknown";
    }
    public void setUsername(String username) {
        if (username != null && username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$") )
            username = username;
        else
            username = "Unknown";
    }
    public void setPassword(String inputPassword) {
        if (inputPassword != null && inputPassword.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$" ))
            password = inputPassword;
        else
            password = "Unknown";
    }
    //CONSTRUCTORS
    AbstractUser(){
        super();
        setNameAndSurname("Unknown");
        setUsername("Unknown");
        setPassword("Unknown");
    }
    AbstractUser(String nameAndSurname, String username, String password){
        super();
        setNameAndSurname(nameAndSurname);
        setUsername(username);
        setPassword(password);
    }
    //TO_STRING

    @Override
    public String toString() {
        return "User{" +
                "nameAndSurname='" + nameAndSurname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //OTHER FUNCTIONS
    //TODO login() followPage()
    public void login(){}
    public void followPage(){}
//    public interface IPostCreation{
//        void createPost();
//    }

}
