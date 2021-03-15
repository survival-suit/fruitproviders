package fruitproviders.DAO;

import fruitproviders.Models.Delivery;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class DeliveryDAO implements IDeliveryDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Delivery ").list();
    }

    @Override
    public List<Delivery> getDeliveriesPerPeriod(Date dateBegin, Date dateEnd) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Delivery AS d WHERE d.date BETWEEN :dateBegin AND :dateEnd");
        query.setParameter("dateBegin", dateBegin);
        query.setParameter("dateEnd", dateEnd);
        return query.getResultList();
    }

    @Override
    public void add(Delivery delivery) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(delivery);
    }

    @Override
    public void delete(Delivery delivery) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(delivery);
    }

    @Override
    public Delivery getById(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Delivery.class, id);
    }
}
