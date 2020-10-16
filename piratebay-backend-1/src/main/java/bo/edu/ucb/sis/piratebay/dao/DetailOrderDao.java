package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.DetailOrderModel;
import bo.edu.ucb.sis.piratebay.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class DetailOrderDao {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public DetailOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DetailOrderModel> findOrder(int order_id) {
        String query = "SELECT provider_product_id, product_name, c.unit_price " +
                "\tFROM \"order\" a, product_order b, product c"+
                "\tWHERE a.order_id = b.order_id "+
                "\tAND b.product_id = c.product_id "+
                "\tAND b.order_id = "+order_id+"";
        List<DetailOrderModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<DetailOrderModel>() {
                @Override
                public DetailOrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new DetailOrderModel(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getDouble(3));


                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }
}
