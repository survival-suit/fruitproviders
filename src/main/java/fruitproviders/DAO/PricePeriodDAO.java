package fruitproviders.DAO;

import fruitproviders.Models.PricePeriod;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class PricePeriodDAO implements IPricePeriodDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<PricePeriod> getAllPricePeriod() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from PricePeriod").list();
    }

    @Override
    public void add(PricePeriod pricePeriod) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(pricePeriod);
    }

    @Override
    public void delete(PricePeriod pricePeriod) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(pricePeriod);
    }

    @Override
    public PricePeriod getById(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(PricePeriod.class, id);
    }
}
