package dataaccess;

import domainmodel.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDB {

    public int insert(User user) throws NotesDBException {
        return 0;
    }

    public int update(User user) throws NotesDBException {
        return 0;
    }

    public List<User> getAll() throws NotesDBException {
        try {
            PreparedStatement ps = ConnectionPool.getInstance().getConnection().prepareStatement("SELECT * FROM user;");
            ResultSet rs = ps.executeQuery();
            List<User> users = new ArrayList<>();
            while(rs.next()){
                users.add(new User());
            }
            return users;
        } catch (SQLException ex) {
            throw new NotesDBException("something serious happened");
        }
    }

    public User getUser(String username) throws NotesDBException {
        return null;
    }

    public int delete(User user) throws NotesDBException {
      ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String preparedQuery = "DELETE FROM User "
                            + "WHERE username = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(preparedQuery);
            ps.setString(1, user.getUsername());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throws new NoteDBException();
        }
        

        pool.freeConnection(connection);
        
        return 0;
    }
}
