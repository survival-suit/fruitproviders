package fruitproviders.Services;

import fruitproviders.Models.Delivery;

import java.sql.Date;
import java.util.*;

public interface IDeliveryService {
    List<Delivery> getAllDeliveries();
    List<Delivery> getDeliveriesPerPeriod(java.sql.Date dateBegin, Date dateEnd);
    void add(Delivery delivery);
    void delete(Delivery delivery);
    Delivery getById(UUID id);
}
