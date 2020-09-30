package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.RegisterClientModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class RegisterClientDao {
    private JdbcTemplate jdbcTemplate;



    @Autowired
    public RegisterClientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;



    }

    public  boolean InsertClient(RegisterClientModel registerClientModel) {
        // Implmentamos SQL varible binding para evitar SQL INJECTION
        //TODO Debo completar el query para insertar el nuesvo regisdtro de cliente
        try {
            jdbcTemplate.update("INSERT INTO public.user( user_id, username, password, email, phone_number,cat_user_status, status, tx_id, tx_username, tx_host,tx_date)VALUES(  nextval('user_user_id_seq') ,? , ?, ?, ?,?, 1, 1, 'root', '127.0.0.1',now())", registerClientModel.getUsername(),registerClientModel.getPassword(),registerClientModel.getEmail(),registerClientModel.getPhoneNumber(),registerClientModel.getCatUserStatus());
                    return true;
        }
        catch (Exception ex)
        {
            System.out.println("Error :"+ ex);
            return  false;
        }

    }
}
