package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.RegisterPersonModel;
import bo.edu.ucb.sis.piratebay.model.RegisterProviderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegisterProviderDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RegisterProviderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;



    }

    public  boolean InsertProvider(RegisterProviderModel registerProviderModel) {
        // Implmentamos SQL varible binding para evitar SQL INJECTION

        try {

            jdbcTemplate.update("INSERT INTO provider ( provider_id, provider_name, provider_zone, provider_street, email, phone, phone2, latitude, longitude, status, tx_id, tx_username, tx_host, tx_date)VALUES(  nextval('provider_provider_id_seq') , ?, ?, ?, ? ,? ,? ,0,0, 1, 1, 'root', '127.0.0.1',now())",registerProviderModel.getProvider_name(), registerProviderModel.getProvider_zone(),registerProviderModel.getProvider_street(),registerProviderModel.getEmail(),registerProviderModel.getPhone(),registerProviderModel.getPhone2());
            return true;
        }
        catch (Exception ex)
        {
            System.out.println("Error per:"+ ex);
            return  false;
        }

    }
}
