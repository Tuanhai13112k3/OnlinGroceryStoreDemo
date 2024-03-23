package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;

public class CategoryDAO extends DBContext {

    // GET ALL
    public List<Category> GetAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT [CategoryID]\n"
                + "      ,[CategoryName]\n"
                + "  FROM [dbo].[Categories]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCategoryId(rs.getInt("CategoryID"));
                c.setCategoryName(rs.getString("CategoryName"));
                list.add(c);
            }
        } catch (SQLException e) {
        }

        return list;
    }

    // GET VIA ID
    public Category GetCategoryById(int category_id) {
        String sql = "SELECT [CategoryID]\n"
                + "      ,[CategoryName]\n"
                + "  FROM [dbo].[Categories]\n"
                + "  WHERE CategoryID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, category_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category c = new Category();
                c.setCategoryId(rs.getInt("CategoryID"));
                c.setCategoryName(rs.getString("CategoryName"));
                return c;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    // INSERT
    public void InsertCategory(Category c) {
        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([CategoryName])\n"
                + "     VALUES(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getCategoryId());
            st.setString(2, c.getCategoryName());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // DELETE
    public void DeleteCategory(int category_id) {
        String sql = "DELETE FROM [dbo].[Categories]\n"
                + "      WHERE CategoryID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, category_id);
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }

    // UPDATE
    public void UpdateCategory(Category c) {
        String sql = "UPDATE [dbo].[Categories]\n"
                + "   SET [CategoryName] = ?\n"
                + " WHERE CategoryID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCategoryName());
            st.setInt(2, c.getCategoryId());
            st.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
