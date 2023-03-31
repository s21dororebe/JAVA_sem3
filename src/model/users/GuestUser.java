package model.users;

import model.Page;
import model.Post;
import service.MainService;

import java.util.ArrayList;

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
        return "GU No. " + generatedId;
    }

    public ArrayList<User> findUsersByNameOrSurnameOrUsername(String inputWord) throws Exception {
        if (inputWord==null){
            throw (new Exception("Wrong input"));
        }
        ArrayList<User> result = new ArrayList<>();
        for(User temp: MainService.allRegisteredUsers){
            if(temp.getName().toLowerCase().contains(inputWord.toLowerCase()) || temp.getSurname().toLowerCase().contains(inputWord.toLowerCase()) || temp.getUsername().toLowerCase().contains(inputWord.toLowerCase())){
                result.add(temp);
            }
        }
        return result;
    }
    public ArrayList<Page> findPagesByTitleOrDescription(String inputWord) throws Exception {
        if (inputWord==null){
            throw (new Exception("Wrong input"));
        }
        ArrayList<Page> result = new ArrayList<>();
        for(User temp: MainService.allRegisteredUsers){
            if(temp instanceof BusinessUser bUserTemp){
//                BusinessUser bUserTemp = (BusinessUser) temp;
                for(Page tempPage : bUserTemp.getAllPages()){
                    if(tempPage.getTitle().toLowerCase().contains(inputWord.toLowerCase()) || tempPage.getDescription().toLowerCase().contains(inputWord.toLowerCase())){
                        result.add(tempPage);
                    }
                }
            }

        }
        return result;
    }
    public ArrayList<Post> findPublicPostsInPrivateUserOrInPage(String inputWord) throws Exception {
        if (inputWord==null){
            throw (new Exception("Wrong input"));
        }
        ArrayList<Post> result = new ArrayList<>();
        for(User temp: MainService.allRegisteredUsers){
            if(temp instanceof PrivateUser pUserTemp){
                for(Post tempPost : pUserTemp.getAllPublicPosts()){
                    if(tempPost.getMsg().toLowerCase().contains(inputWord.toLowerCase())){
                        result.add(tempPost);
                    }
                }
            }
            else if (temp instanceof BusinessUser bUserTemp){
                for(Page tempPage : bUserTemp.getAllPages()){
                    for(Post tempPost : tempPage.getPostInPage()){
                        if(tempPost.getMsg().toLowerCase().contains(inputWord.toLowerCase())){
                            result.add(tempPost);
                        }
                    }
                }
            }

        }
        return result;
    }

}
