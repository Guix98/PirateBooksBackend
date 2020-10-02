package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.InicioModel;
import bo.edu.ucb.sis.piratebay.model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class InicioDao {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public InicioDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<InicioModel> findAllProductInicio() {

        String query = "SELECT product_name, product_code, product_description, image, author, unit_price " +
                "\tFROM product a"+
                "\tORDER BY product_code DESC LIMIT 6";


        List<InicioModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<InicioModel>() {
                @Override
                public InicioModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new InicioModel(
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
