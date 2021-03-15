package fruitproviders.Services;

import fruitproviders.DAO.IDeliveryDAO;
import fruitproviders.Models.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DeliveryService implements IDeliveryService{

    private IDeliveryDAO deliveryDAO;

    @Autowired
    public void setDeliveryDAO(IDeliveryDAO deliveryDAO){ this.deliveryDAO = deliveryDAO; }

    @Override
    @Transactional
    public List<Delivery> getAllDeliveries() {
        return deliveryDAO.getAllDeliveries();
    }

    @Override
    @Transactional
    public List<Delivery> getDeliveriesPerPeriod(Date dateBegin, Date dateEnd) {
        return deliveryDAO.getDeliveriesPerPeriod(dateBegin, dateEnd);
    }

    @Override
    @Transactional
    public void add(Delivery delivery) {
        deliveryDAO.add(delivery);
    }

    @Override
    @Transactional
    public void delete(Delivery delivery) {
        deliveryDAO.delete(delivery);
    }

    @Override
    @Transactional
    public Delivery getById(UUID id) {
        return deliveryDAO.getById(id);
    }
}
