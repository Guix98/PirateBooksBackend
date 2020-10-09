package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.BooksDao;
import bo.edu.ucb.sis.piratebay.dao.ProvedorDao;
import bo.edu.ucb.sis.piratebay.model.BooksModel;
import bo.edu.ucb.sis.piratebay.model.ProvedorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvedorBl {
    private ProvedorDao provedorDao;

    @Autowired
    public ProvedorBl(ProvedorDao provedorDao) {
        this.provedorDao = provedorDao;
    }

    public List<ProvedorModel> findAllProvedor() {
        return this.provedorDao.findAllProvedor();
    }
}
