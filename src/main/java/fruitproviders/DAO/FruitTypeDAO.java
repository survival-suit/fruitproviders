package fruitproviders.DAO;

import fruitproviders.Models.FruitType;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FruitTypeDAO implements IFruitTypeDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<FruitType> getAllFruitTypes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from FruitType").list();
    }

    //create
    @Override
    public void add(FruitType fruitType) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(fruitType);
    }

    //delete
    @Override
    public void delete(FruitType fruitType) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(fruitType);
    }

    //read
    @Override
    public FruitType getById(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(FruitType.class, id);
    }
}
