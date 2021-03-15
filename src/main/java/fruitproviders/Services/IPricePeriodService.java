package fruitproviders.Services;

import fruitproviders.Models.PricePeriod;
import java.util.*;

public interface IPricePeriodService {
    List<PricePeriod> getAllPricePeriod();
    void add(PricePeriod pricePeriod);
    void delete(PricePeriod pricePeriod);
    PricePeriod getById(UUID id);
}
