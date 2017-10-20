package dataaccess;

import domainmodel.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDB {

    public int insert(User user) throws NotesDBException {
        return 0;
    }

    public int update(User user) throws NotesDBException {
        try
        {
            String preparedSQL = "UPDATE User SET"
                    +"password = ?,"
                    +"email = ?,"
                    +"WHERE username = ?";
            
            PreparedStatement ps = connection.preparedStatement(preparedSQL);
            
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getUsername());
            
            ps.executeUpdate();
        } catch (SQLException ex)
        {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
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
