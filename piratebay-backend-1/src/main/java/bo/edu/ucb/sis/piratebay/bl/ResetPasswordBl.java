package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.RegisterPersonDao;
import bo.edu.ucb.sis.piratebay.dao.ResetPasswordDao;
import bo.edu.ucb.sis.piratebay.model.RegisterPersonModel;
import bo.edu.ucb.sis.piratebay.model.ResetPasswordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResetPasswordBl {
    private ResetPasswordDao resetPasswordDao;

    @Autowired
    public ResetPasswordBl(ResetPasswordDao resetPasswordDao) {
        this.resetPasswordDao = resetPasswordDao;
    }

    public boolean changePassword(ResetPasswordModel resetPasswordModel) {
        return this.resetPasswordDao.changePassword(resetPasswordModel);
    }
}
