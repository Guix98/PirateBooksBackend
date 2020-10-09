package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.BooksDao;
import bo.edu.ucb.sis.piratebay.dao.ProductsDao;
import bo.edu.ucb.sis.piratebay.model.BooksModel;
import bo.edu.ucb.sis.piratebay.model.ProductsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksBl {
    private BooksDao booksDao;

    @Autowired
    public BooksBl(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    public List<BooksModel> findBook(String product_name) {
        return this.booksDao.findBook(product_name);
    }
}
