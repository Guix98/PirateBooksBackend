package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.RegisterClientDao;
import bo.edu.ucb.sis.piratebay.dao.UserDao;
import bo.edu.ucb.sis.piratebay.model.RegisterClientModel;
import bo.edu.ucb.sis.piratebay.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterClientBl {
    private RegisterClientDao registerClientDao;

    @Autowired
    public RegisterClientBl(RegisterClientDao registerClientDao) {
        this.registerClientDao = registerClientDao;
    }

    public boolean InsertClient(RegisterClientModel registerClientModel) {
        return this.registerClientDao.InsertClient(registerClientModel);
    }
}
