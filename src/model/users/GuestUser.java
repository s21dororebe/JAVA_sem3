package model.users;

public class GuestUser {
    private int generatedId;
    private static int idCounter = 0;
    //GETTERS
    //SETTERS
    public int getGeneratedId() {
        return generatedId;
    }
    public void setGeneratedId(int generatedId) {
        this.generatedId = generatedId;
    }
    //CONSTRUCTORS
    GuestUser(){
        setGeneratedId(idCounter);
        idCounter++;
    }
    //TO_STRING
    @Override
    public String toString() {
        return "GuestUser{" +
                "generatedId=" + generatedId +
                '}';
    }
}
