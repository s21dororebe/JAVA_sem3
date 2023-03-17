package model.users;

public class User extends GuestUser {
    private String nameAndSurname;
    private String username;
    private String password; //(can be created using MD5 Hashing cryptographic method)

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
    //TODO
    /*
    public void setPassword(String password) {
        if (password != null && password.matches("^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$") )
            password = password;
        else
            password = "Unknown";
    }*/
    //CONSTRUCTORS
    User(){
        super();
        setNameAndSurname("Unknown");
        setUsername("Unknown");
        setPassword("Unknown");
    }
    User(String nameAndSurname, String username, String password){
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
}
