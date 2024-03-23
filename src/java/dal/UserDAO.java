package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAO extends DBContext {

    // GET ALL
    public List<User> GetAllUser() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT [UserID]\n"
                + "      ,[Username]\n"
                + "      ,[Password]\n"
                + "      ,[Email]\n"
                + "      ,[FullName]\n"
                + "      ,[Role]\n"
                + "      ,[JoinDate]\n"
                + "      ,[Phone]\n"
                + "      ,[Address]\n"
                + "      ,[Department]\n"
                + "  FROM [dbo].[Users]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("UserID"));
                u.setUsername(rs.getString("Username"));
                u.setPassword(rs.getString("Password"));
                u.setEmail(rs.getString("Email"));
                u.setFullName(rs.getString("FullName"));
                u.setRole(rs.getString("Role"));
                u.setJoinDate(rs.getDate("JoinDate"));
                u.setPhone(rs.getString("Phone"));
                u.setAddress(rs.getString("Address"));
                u.setDepartment(rs.getString("Department"));
                list.add(u);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    // INSERT 
    public void InsertUser(User u) {
        String sql = "INSERT INTO [dbo].[Users]\n"
                + "           ([Username]\n"
                + "           ,[Password]\n"
                + "           ,[Email]\n"
                + "           ,[FullName]\n"
                + "           ,[Role]\n"
                + "           ,[JoinDate]\n"
                + "           ,[Phone]\n"
                + "           ,[Address]\n"
                + "           ,[Department])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getUsername());
            st.setString(2, u.getPassword());
            st.setString(3, u.getEmail());
            st.setString(4, u.getFullName());
            st.setString(5, u.getRole());
            st.setDate(6, u.getJoinDate());
            st.setString(7, u.getPhone());
            st.setString(8, u.getAddress());
            st.setString(9, u.getDepartment());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // UPDATE
    public void UpdateUser(User u) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "   SET [Username] = ?\n"
                + "      ,[Password] = ?>\n"
                + "      ,[Email] = ?\n"
                + "      ,[FullName] = ?\n"
                + "      ,[Role] = ?\n"
                + "      ,[JoinDate] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[Department] = ?\n"
                + " WHERE UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u.getUsername());
            st.setString(2, u.getPassword());
            st.setString(3, u.getEmail());
            st.setString(4, u.getFullName());
            st.setString(5, u.getRole());
            st.setDate(6, u.getJoinDate());
            st.setString(7, u.getPhone());
            st.setString(8, u.getAddress());
            st.setString(9, u.getDepartment());
        } catch (SQLException e) {
        }
    }

    // DELETE
    public void DeleteUser(int user_id) {
        String sql = "DELETE FROM Users WHERE UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user_id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public User GetUserById(int user_id) {
        String sql = "SELECT * FROM Users WHERE UserID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, user_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("UserID"));
                u.setUsername(rs.getString("Username"));
                u.setPassword(rs.getString("Password"));
                u.setEmail(rs.getString("Email"));
                u.setFullName(rs.getString("FullName"));
                u.setRole(rs.getString("Role"));
                u.setJoinDate(rs.getDate("JoinDate"));
                u.setPhone(rs.getString("Phone"));
                u.setAddress(rs.getString("Address"));
                u.setDepartment(rs.getString("Department"));
                return u;
            }
        } catch (SQLException e) {
        }
        return null;
    }
}
