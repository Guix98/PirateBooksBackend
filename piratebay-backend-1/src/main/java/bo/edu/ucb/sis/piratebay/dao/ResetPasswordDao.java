package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.RegisterClientModel;
import bo.edu.ucb.sis.piratebay.model.ResetPasswordModel;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class ResetPasswordDao {
    private JdbcTemplate jdbcTemplate;

    @Value("${piratebay.security.salt}")
    private String salt;

    @Autowired
    public ResetPasswordDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  boolean changePassword(ResetPasswordModel resetPasswordModel) {
        // Implmentamos SQL varible binding para evitar SQL INJECTION
        //TODO Debo completar el query para insertar el nuesvo regisdtro de cliente
        try {
            String sha256hexpassword = Hashing.sha256()
                    .hashString(resetPasswordModel.getPassword()+salt, StandardCharsets.UTF_8)
                    .toString(); // TODO Repetir el algoritmo de hash N veces para encriptar
            jdbcTemplate.update("UPDATE public.\"user\" SET   password='"+sha256hexpassword+"' WHERE email='"+resetPasswordModel.getEmail()+"';");
            //jdbcTemplate.update("INSERT INTO public.user( user_id, username, password, email, phone_number,cat_user_status, status, tx_id, tx_username, tx_host,tx_date)VALUES(  nextval('user_user_id_seq') ,? , ?, ?, ?,?, 1, 1, 'root', '127.0.0.1',now())", registerClientModel.getUsername(),sha256hexpassword,registerClientModel.getEmail(),registerClientModel.getPhoneNumber(),registerClientModel.getCatUserStatus());
            return true;
        }
        catch (Exception ex)
        {
            System.out.println("Error :"+ ex);
            return  false;
        }

    }
}
