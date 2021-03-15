package fruitproviders.Services;

import fruitproviders.DAO.IPricePeriodDAO;
import fruitproviders.Models.PricePeriod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PricePeriodService implements IPricePeriodService{

    private IPricePeriodDAO pricePeriodDAO;

    @Autowired
    public void setPricePeriodDAO(IPricePeriodDAO pricePeriodDAO){ this.pricePeriodDAO = pricePeriodDAO; }


    @Override
    @Transactional
    public List<PricePeriod> getAllPricePeriod() {
        return pricePeriodDAO.getAllPricePeriod();
    }

    @Override
    @Transactional
    public void add(PricePeriod pricePeriod) {
        pricePeriodDAO.add(pricePeriod);
    }

    @Override
    @Transactional
    public void delete(PricePeriod pricePeriod) {
        pricePeriodDAO.delete(pricePeriod);
    }

    @Override
    @Transactional
    public PricePeriod getById(UUID id) {
        return pricePeriodDAO.getById(id);
    }
}
