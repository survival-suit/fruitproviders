package fruitproviders.DAO;

import fruitproviders.Models.Fruit;
import fruitproviders.Models.Partner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PartnerDAO implements IPartnerDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Partner> getAllPartners() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Partner").list();
    }

    @Override
    public void add(Partner partner) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(partner);
    }

    @Override
    public void delete(Partner partner) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(partner);
    }

    @Override
    public Partner getById(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Partner.class, id);
    }
}
