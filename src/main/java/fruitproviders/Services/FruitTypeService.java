package fruitproviders.Services;

import fruitproviders.DAO.IFruitTypeDAO;
import fruitproviders.Models.FruitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class FruitTypeService implements IFruitTypeService{
    private IFruitTypeDAO fruitTypeDAO;

    @Autowired
    public void setFruitDAO(IFruitTypeDAO fruitTypeDAO){
        this.fruitTypeDAO = fruitTypeDAO;
    }

    @Override
    @Transactional
    public List<FruitType> getAllFruitTypes() {
        return fruitTypeDAO.getAllFruitTypes();
    }

    @Override
    @Transactional
    public void add(FruitType fruit) {
        fruitTypeDAO.add(fruit);
    }

    @Override
    @Transactional
    public void delete(FruitType fruit) {
        fruitTypeDAO.delete(fruit);
    }

    @Override
    @Transactional
    public FruitType getById(UUID id) {
        return fruitTypeDAO.getById(id);
    }
}
