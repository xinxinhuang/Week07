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

    public int insert(String username, String password) throws Exception {
        
        
        
        return 0;
    }

}
