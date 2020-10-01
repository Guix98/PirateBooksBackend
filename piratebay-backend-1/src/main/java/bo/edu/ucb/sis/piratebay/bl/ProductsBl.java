package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.ProductsDao;
import bo.edu.ucb.sis.piratebay.model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsBl {
    private ProductsDao productsDao;

    @Autowired
    public ProductsBl(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    public List<ProductsModel> findAllProduct(String category_name) {
        return this.productsDao.findAllProduct(category_name);
    }
}
