package bo.edu.ucb.sis.piratebay.bl;


import bo.edu.ucb.sis.piratebay.dao.RegisterClientDao;
import bo.edu.ucb.sis.piratebay.dao.RegisterPersonDao;

import bo.edu.ucb.sis.piratebay.model.RegisterPersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterPersonBl {
    private RegisterPersonDao registerPersonDao;

    @Autowired
    public RegisterPersonBl(RegisterPersonDao registerPersonDao) {
        this.registerPersonDao = registerPersonDao;
    }

    public boolean InsertPerson(RegisterPersonModel registerPersonModel) {
        return this.registerPersonDao.InsertPerson(registerPersonModel);
    }
}
