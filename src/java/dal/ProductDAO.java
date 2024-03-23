package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

public class ProductDAO extends DBContext {

    private CategoryDAO categoryDAO;

    public ProductDAO() {
        categoryDAO = new CategoryDAO();
    }

    public List<Product> GetAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT [ProductID]\n"
                + "      ,[CategoryID]\n"
                + "      ,[ProductName]\n"
                + "      ,[Image]\n"
                + "      ,[Description]\n"
                + "      ,[Price]\n"
                + "      ,[Quantity]\n"
                + "      ,[CreatedBy]\n"
                + "      ,[CreatedOn]\n"
                + "      ,[ModifiedBy]\n"
                + "      ,[ModifiedOn]\n"
                + "  FROM [dbo].[Products]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("ProductID"));
                Category c = categoryDAO.GetCategoryById(rs.getInt("CategoryID"));
                p.setCategory(c);
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getFloat("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setCreatedBy(rs.getInt("CreatedBy"));
                p.setCreatedOn(rs.getDate("CreatedOn"));
                p.setModifiedBy(rs.getInt("ModifiedBy"));
                p.setModifiedOn(rs.getDate("ModifiedOn"));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    // GET PRODUCT VIA ID
    public Product GetProductById(int product_id) {
        String sql = "SELECT [ProductID]\n"
                + "      ,[CategoryID]\n"
                + "      ,[ProductName]\n"
                + "      ,[Image]\n"
                + "      ,[Description]\n"
                + "      ,[Price]\n"
                + "      ,[Quantity]\n"
                + "      ,[CreatedBy]\n"
                + "      ,[CreatedOn]\n"
                + "      ,[ModifiedBy]\n"
                + "      ,[ModifiedOn]\n"
                + "  FROM [dbo].[Products]\n"
                + "  WHERE ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, product_id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("ProductID"));
                Category c = categoryDAO.GetCategoryById(rs.getInt("CategoryID"));
                p.setCategory(c);
                p.setProductName(rs.getString("ProductName"));
                p.setImage(rs.getString("Image"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getFloat("Price"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setCreatedBy(rs.getInt("CreatedBy"));
                p.setCreatedOn(rs.getDate("CreatedOn"));
                p.setModifiedBy(rs.getInt("ModifiedBy"));
                p.setModifiedOn(rs.getDate("ModifiedOn"));
                return p;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    // INSERT A PRODUCT INTO DATABASE
    public void InsertProduct(Product p) {
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([CategoryID]\n"
                + "           ,[ProductName]\n"
                + "           ,[Image]\n"
                + "           ,[Description]\n"
                + "           ,[Price]\n"
                + "           ,[Quantity]\n"
                + "           ,[CreatedBy]\n"
                + "           ,[CreatedOn]\n"
                + "           ,[ModifiedBy]\n"
                + "           ,[ModifiedOn])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getCategory().getCategoryId());
            st.setString(2, p.getProductName());
            st.setString(3, p.getImage());
            st.setString(4, p.getDescription());
            st.setFloat(5, p.getPrice());
            st.setInt(6, p.getQuantity());
            st.setInt(7, p.getCreatedBy());
            st.setDate(8, p.getCreatedOn());
            st.setInt(9, p.getModifiedBy());
            st.setDate(10, p.getModifiedOn());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    // UPDATE A PRODUCT
    public void UpdateProduct(Product p) {
        String sql = "UPDATE [dbo].[Products]\n"
                + "   SET [CategoryID] = ?\n"
                + "      ,[ProductName] = ?\n"
                + "      ,[Image] = ?\n"
                + "      ,[Description] = ?\n"
                + "      ,[Price] = ?\n"
                + "      ,[Quantity] = ?\n"
                + "      ,[CreatedBy] = ?\n"
                + "      ,[CreatedOn] = ?\n"
                + "      ,[ModifiedBy] = ?\n"
                + "      ,[ModifiedOn] = ?\n"
                + " WHERE ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getCategory().getCategoryId());
            st.setString(2, p.getProductName());
            st.setString(3, p.getImage());
            st.setString(4, p.getDescription());
            st.setFloat(5, p.getPrice());
            st.setInt(6, p.getQuantity());
            st.setInt(7, p.getCreatedBy());
            st.setDate(8, p.getCreatedOn());
            st.setInt(9, p.getModifiedBy());
            st.setDate(10, p.getModifiedOn());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    // DELETE A PRODUCT
    public void DeleteProduct(int product_id) {
        String sql = "DELETE FROM [dbo].[Products]\n"
                + "      WHERE ProductID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, product_id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    // End: ProductDAO
}
