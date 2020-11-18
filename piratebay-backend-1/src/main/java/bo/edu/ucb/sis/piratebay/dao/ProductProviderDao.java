package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.OrderModel;
import bo.edu.ucb.sis.piratebay.model.ProductProviderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProductProviderDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public ProductProviderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProductProviderModel> findAllProduct(int id_provider) {

       //String query =  "SELECT x.product_code , x.product_name,  x.author, x.unit_price, y.category_name FROM product x, category y, provider z WHERE x.category_id = y.category_id AND x.provider_id = z.provider_id AND z.provider_id = 1;";
       String query = "SELECT x.product_code , x.product_name,  x.author, x.unit_price, y.category_name\n " +
                "                FROM product x, category y, provider z\n " +
                "                WHERE x.category_id = y.category_id\n " +
                "                AND x.provider_id = z.provider_id\n " +
                "                AND z.provider_id = "+id_provider+";";
        List<ProductProviderModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<ProductProviderModel>() {
                @Override
                public ProductProviderModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new ProductProviderModel(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4),
                            resultSet.getString(5));

                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }
}
