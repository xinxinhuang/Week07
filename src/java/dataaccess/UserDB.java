package dataaccess;

import domainmodel.User;
import java.sql.PreparedStatement;
import java.util.List;

public class UserDB {

    public int insert(User user) throws NotesDBException {
        return 0;
    }

    public int update(User user) throws NotesDBException {
        return 0;
    }

    public List<User> getAll() throws NotesDBException {
        return null;
    }

    public User getUser(String username) throws NotesDBException {
        return null;
    }

    public int delete(User user) throws NotesDBException {
        String preparedQuery = "DELETE FROM User "
                            + "WHERE username = ?";
        PreparedStatement ps = connection.prepareStatement(preparedQuery);
        ps.setString(1, username);
        ps.executeUpdate();

        
        
        return 0;
        // test
    }
}
