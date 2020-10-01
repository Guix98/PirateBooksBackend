package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.CategoryModel;
import bo.edu.ucb.sis.piratebay.model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProductsDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public ProductsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProductsModel> findAllProduct(String category_name) {

        String query = "SELECT product_code, author, product_name, product_description, image, unit_price " +
                "\tFROM product a, category b"+
                "\tWHERE a.category_id = b.category_id "+
                "\tAND category_name= '"+category_name+"'";
        List<ProductsModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<ProductsModel>() {
                @Override
                public ProductsModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new ProductsModel(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getDouble(6));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }
}
