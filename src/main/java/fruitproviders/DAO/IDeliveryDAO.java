package fruitproviders.DAO;

import fruitproviders.Models.Delivery;

import java.sql.Date;
import java.util.*;

public interface IDeliveryDAO {
    List<Delivery> getAllDeliveries();
    List<Delivery> getDeliveriesPerPeriod(Date dateBegin, Date dateEnd);
    void add(Delivery delivery);
    void delete(Delivery delivery);
    Delivery getById(UUID id);
}
