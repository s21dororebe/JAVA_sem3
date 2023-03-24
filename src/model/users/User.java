package model.users;

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
        if (inputEncodedPassword != null && inputEncodedPassword.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$" ))
            //TODO find out simple password encoder
            encodedPassword = inputEncodedPassword;
        else
            encodedPassword = "P@ssw0rd";
    }
    //CONSTRUCTORS
    public User(){
        super();
        setName("name");
        setSurname("surname");
        setUsername("default.user");
        setEncodedPassword("P@ssw0rd");
    }
    public User(String name, String surname, String username, String inputEncodedPassword){
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
    //TODO login() followPage()
    public void login(){}
    public void followPage(){}
    public interface IPostCreation{
        void createPost();
    }

}
