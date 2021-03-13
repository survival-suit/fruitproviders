package fruitproviders.DAO;

import fruitproviders.Models.Fruit;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class FruitDAO implements IFruitDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Fruit> getAllFruits() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Fruit").list();
    }

    //create
    @Override
    public void add(Fruit fruit) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(fruit);
    }

    //delete
    @Override
    public void delete(Fruit fruit) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(fruit);
    }

    //update
    @Override
    public void edit(Fruit fruit) {
        Session session = sessionFactory.getCurrentSession();
        session.update(fruit);
    }

    //read
    @Override
    public Fruit getById(UUID id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Fruit.class, id);
    }
}
