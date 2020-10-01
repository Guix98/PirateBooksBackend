package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class CategoryDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public CategoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CategoryModel> findAllCategory() {

        String query = "SELECT category_id, category_name " +
                "\tFROM category ";
        List<CategoryModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<CategoryModel>() {
                @Override
                public CategoryModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new CategoryModel(resultSet.getInt(1),
                            resultSet.getString(2));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }
}
