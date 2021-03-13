package fruitproviders.Services;

import fruitproviders.DAO.IFruitDAO;
import fruitproviders.Models.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class FruitService implements IFruitService {

    private IFruitDAO fruitDAO;

    @Autowired
    public void setFruitDAO(IFruitDAO fruitDAO){
        this.fruitDAO = fruitDAO;
    }

    @Override
    @Transactional
    public List<Fruit> getAllFruits() {
        return fruitDAO.getAllFruits();
    }

    @Override
    @Transactional
    public void add(Fruit fruit) {
        fruitDAO.add(fruit);
    }

    @Override
    @Transactional
    public void delete(Fruit fruit) {
        fruitDAO.delete(fruit);
    }

    @Override
    @Transactional
    public void edit(Fruit fruit) {
        fruitDAO.edit(fruit);
    }

    @Override
    @Transactional
    public Fruit getById(UUID id) {
        return fruitDAO.getById(id);
    }
}
