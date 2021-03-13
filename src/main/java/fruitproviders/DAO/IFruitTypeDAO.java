package fruitproviders.DAO;

import fruitproviders.Models.FruitType;
import java.util.List;
import java.util.UUID;

public interface IFruitTypeDAO {
    List<FruitType> getAllFruitTypes();
    void add(FruitType fruitType);
    void delete(FruitType fruitType);
    FruitType getById(UUID id);
}
