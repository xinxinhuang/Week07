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
        List<User> users = new ArrayList<>();
        
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM user");
        try {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                users.add(new User());
            }
        } catch (SQLException ex) {
            throw new NotesDBException();
        }
        
        
        return null;
    }

    /**
     * Get a single user by their username.
     * @param username The unique username.
     * @return A User object if found, null otherwise.
     * @throws NotesDBException 
     */
    public User getUser(String username) throws NotesDBException {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String selectSQL = "SELECT * FROM User WHERE username = ?";
        PreparedStatement ps = connection.prepareStatement(selectSQL);
        try {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
       
            User user = null;
            while (rs.next()) {
                user = new User(rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getInt("active"), rs.getString("firstname"), rs.getString("lastname"));
            }
            
            return user;
        } catch (SQLException e) {
            throw new NotesDBException();
        }
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
