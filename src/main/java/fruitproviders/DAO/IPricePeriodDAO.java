package fruitproviders.DAO;

import fruitproviders.Models.PricePeriod;

import java.util.List;
import java.util.UUID;

public interface IPricePeriodDAO {
    List<PricePeriod> getAllPricePeriod();
    void add(PricePeriod pricePeriod);
    void delete(PricePeriod pricePeriod);
    PricePeriod getById(UUID id);
}
