package model.users;

public class GuestUser {
    private final long generatedId;
    private static long idCounter = 0;
    //GETTERS
    //SETTERS
    public long getGeneratedId() {
        return generatedId;
    }
    //CONSTRUCTORS
    public GuestUser(){
        generatedId = idCounter;
        idCounter++;
    }
    //TO_STRING
    @Override
    public String toString() {
        return "GuestUser Nr. " + generatedId;
    }

    //TODO add find functions
}
