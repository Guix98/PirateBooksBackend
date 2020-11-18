package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.CartModel;
import bo.edu.ucb.sis.piratebay.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class OrderDao {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OrderModel> findAllOrders() {

        String query = "SELECT order_id, x.user_id,  \"date\", amount\n" +
                "                FROM \"order\" x, \"user\" y\n" +
                "                WHERE x.user_id = y.user_id;";
        List<OrderModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<OrderModel>() {
                @Override
                public OrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new OrderModel(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getDate(3),
                            resultSet.getDouble(4));

                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }
    public List<CartModel> findCarrito(int order) {

        String query = "SELECT x.order_id, y.username, z.product_name, z.unit_price, w.qtty_requested, z.unit_price*w.qtty_requested as total\n" +
                "from \"order\" x, \"user\" y, product z, product_order w\n" +
                "WHERE x.order_id=w.order_id\n" +
                "AND   x.user_id=y.user_id\n" +
                "AND   w.product_id=z.product_id" +
                "AND   x.order_id = "+order;
        List<CartModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<CartModel>() {
                @Override
                public CartModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new CartModel(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4),
                            resultSet.getInt(5),
                            resultSet.getDouble(6));

                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }
    public  boolean InsertOrder(OrderModel OrderModel) {
        // Implmentamos SQL varible binding para evitar SQL INJECTION

        try {

            jdbcTemplate.update("INSERT INTO \"order\"(\n" +
                            "\tuser_id, \"date\", amount, status, tx_id, tx_username, tx_host, tx_date)\n" +
                            "\tVALUES ( ?, ?, ?, 1, 1, 'root', '127.0.0.1',now());",
                    OrderModel.getUserid(),
                    OrderModel.getDate(),
                    OrderModel.getAmount()
            );
            return true;
        }
        catch (Exception ex)
        {
            System.out.println("Error per:"+ ex);
            return  false;
        }

    }

}
