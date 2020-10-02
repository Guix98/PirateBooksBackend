package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.InicioDao;
import bo.edu.ucb.sis.piratebay.dao.ProductsDao;
import bo.edu.ucb.sis.piratebay.model.InicioModel;
import bo.edu.ucb.sis.piratebay.model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InicioBl {
    private InicioDao inicioDao;

    @Autowired
    public InicioBl(InicioDao inicioDao) {
        this.inicioDao = inicioDao;
    }

    public List<InicioModel> findAllProductInicio() {
        return this.inicioDao.findAllProductInicio();
    }
}
