package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.RegisterPersonDao;
import bo.edu.ucb.sis.piratebay.dao.RegisterProviderDao;
import bo.edu.ucb.sis.piratebay.model.RegisterPersonModel;
import bo.edu.ucb.sis.piratebay.model.RegisterProviderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterProviderBl {
    private RegisterProviderDao registerProviderDao;

    @Autowired
    public RegisterProviderBl(RegisterProviderDao registerProviderDao) {
        this.registerProviderDao = registerProviderDao;
    }

    public boolean InsertProvider(RegisterProviderModel registerProviderModel) {
        return this.registerProviderDao.InsertProvider(registerProviderModel);
    }
}
