package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.RegisterPersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegisterPersonDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RegisterPersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;



    }

    public  boolean InsertPerson(RegisterPersonModel registerPersonModel) {
        // Implmentamos SQL varible binding para evitar SQL INJECTION
        try {

            jdbcTemplate.update("INSERT INTO person ( person_id, user_id, first_name, second_name, third_name, first_surname, second_surname, third_surname, birthdate, zone_direction,street_direction, document_id, document_expedition, cat_document_type, cat_genre, cat_marital_status, status, tx_id, tx_username, tx_host, tx_date)VALUES(  nextval('person_person_id_seq') ,? , ?, ?, ?, ? ,? ,? ,? ,? ,?,?,?,?,?,?, 1, 1, 'root', '127.0.0.1',now())",registerPersonModel.getFirst_name(), registerPersonModel.getSecond_name(),registerPersonModel.getThird_name(),registerPersonModel.getFirst_surname(),registerPersonModel.getSecond_surname(),registerPersonModel.getThird_surname(),registerPersonModel.getBirthdate(),registerPersonModel.getZone_direction(),registerPersonModel.getStreet_direction(),registerPersonModel.getDocument_id(),registerPersonModel.getDocument_expedition(),registerPersonModel.getCat_document_type(),registerPersonModel.getCat_genre(),registerPersonModel.getMarital_status());
            return true;
        }
        catch (Exception ex)
        {
            System.out.println("Error :"+ ex);
            return  false;
        }

    }
}
