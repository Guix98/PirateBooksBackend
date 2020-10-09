package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.BooksModel;
import bo.edu.ucb.sis.piratebay.model.ProvedorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProvedorDao {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public ProvedorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ProvedorModel> findAllProvedor() {

        String query = "SELECT provider_id, provider_name " +
                "\tFROM provider a";


        List<ProvedorModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<ProvedorModel>() {
                @Override
                public ProvedorModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new ProvedorModel(
                            resultSet.getInt(1),
                            resultSet.getString(2));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    public List<ProvedorModel> findProvedor(int provider_id) {

        String query = "SELECT provider_id, provider_name, provider_zone, provider_street, email, phone, phone2" +
                "\tFROM provider a "+
                "\tWHERE provider_id = '"+provider_id+"'";

        List<ProvedorModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<ProvedorModel>() {
                @Override
                public ProvedorModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new ProvedorModel(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7));


                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }
}
