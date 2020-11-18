package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.OrderDao;
import bo.edu.ucb.sis.piratebay.dao.ProductProviderDao;
import bo.edu.ucb.sis.piratebay.model.OrderModel;
import bo.edu.ucb.sis.piratebay.model.ProductProviderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductProviderBl {
    private ProductProviderDao productProviderDao;

    @Autowired
    public ProductProviderBl(ProductProviderDao productProviderDao) {
        this.productProviderDao= productProviderDao;
    }

    public List<ProductProviderModel> findAllProduct(int id_provider) {
        return this.productProviderDao.findAllProduct(id_provider);
    }
}
