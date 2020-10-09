package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.BooksModel;
import bo.edu.ucb.sis.piratebay.model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class BooksDao {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public BooksDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BooksModel> findBook(String product_name) {

        String query = "SELECT category_name, product_code,  author, product_name, product_description, image, unit_price " +
                "\tFROM product a, category b"+
                "\tWHERE a.category_id = b.category_id "+
                "\tAND product_name= '"+product_name+"'";
        List<BooksModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<BooksModel>() {
                @Override
                public BooksModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new BooksModel(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getDouble(7));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }
}
