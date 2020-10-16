package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.ProvedorModel;
import bo.edu.ucb.sis.piratebay.model.ResetPasswordRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ResetPasswordRequestDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ResetPasswordRequestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ResetPasswordRequestModel> findUserByEmail(String email) {

        String query = "SELECT  email, username, password\n" +
                "\tFROM public.\"user\"\n" +
                "\tWHERE email='"+email+"';";


        List<ResetPasswordRequestModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<ResetPasswordRequestModel>() {
                @Override
                public ResetPasswordRequestModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new ResetPasswordRequestModel(
                            resultSet.getString(1),
                            resultSet.getString(2));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }
}
