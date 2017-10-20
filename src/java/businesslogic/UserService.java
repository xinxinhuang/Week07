package businesslogic;

import dataaccess.UserDB;
import domainmodel.User;
import java.util.List;

public class UserService {
    private UserDB userDB;
    
    
    public User get(String username) throws Exception {
        userDB = new UserDB();
        
        return userDB.getUser(username);
        
    }

    public List<User> getAll() throws Exception {
        userDB = new UserDB();
        return userDB.getAll();
    }

    public int update(String username, String password, String email) throws Exception {
        
        User user = new User (username, password, email);
        userDB = new UserDB();
        
        return userDB.update(user);
        
        
    }

    public int delete(String username) throws Exception {
        userDB = new UserDB();
        User deletedUser = userDB.getUser(username);
        return userDB.delete(deletedUser);
    }
    
    // if firstname and lastname not entered pass null
    public int insert(String username, String password,String email,int active,String firstname,String lastname) throws Exception {

        userDB = new UserDB();

         User insertUser = null;
        if(firstname == null || lastname == null)
        {
           insertUser = new User(username,password,email,active); 
        }
        else if(firstname != null&& firstname.isEmpty() || lastname != null && lastname.isEmpty())
        {
           insertUser = new User(username,password,email,active,firstname,lastname); 
        }
        

        
        return  userDB.insert(insertUser);        
       
    }

}
