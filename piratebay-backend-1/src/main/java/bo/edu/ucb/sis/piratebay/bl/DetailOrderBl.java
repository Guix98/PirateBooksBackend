package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.DetailOrderDao;
import bo.edu.ucb.sis.piratebay.dao.OrderDao;
import bo.edu.ucb.sis.piratebay.model.DetailOrderModel;
import bo.edu.ucb.sis.piratebay.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailOrderBl {
    private DetailOrderDao detailOrderDao;

    @Autowired
    public DetailOrderBl(DetailOrderDao detailOrderDao) {
        this.detailOrderDao= detailOrderDao;
    }

    public List<DetailOrderModel> findOrder(int order_id) {
        return this.detailOrderDao.findOrder(order_id);
    }
}
