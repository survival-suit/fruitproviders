package fruitproviders.Services;

import fruitproviders.Models.Fruit;
import java.util.List;
import java.util.UUID;

public interface IFruitService {
    List<Fruit> getAllFruits();
    void add(Fruit fruit);
    void delete(Fruit fruit);
    void edit(Fruit fruit);
    Fruit getById(UUID id);
}
