package fruitproviders.Models;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.*;

/*Класс фруктов*/
@Entity
@Table(name = "Fruits")
public class Fruit {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "fruit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FruitType> fruitTypeList;

    public Fruit() {}

    public Fruit(String name) {
        this.name = name;
        this.fruitTypeList = new ArrayList<>();
    }

    public Fruit(UUID id, String name){
        this.id = id;
        this.name = name;
    }

    public void addFruitType(FruitType fruitType) {
        fruitType.setFruit(this);
        fruitTypeList.add(fruitType);
    }

    public void removeAuto(FruitType fruitType) {
        fruitTypeList.remove(fruitType);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FruitType> getAutos() {
        return fruitTypeList;
    }

    public void setAutos(List<FruitType> fruitTypeList) {
        this.fruitTypeList = fruitTypeList;
    }

    @Override
    public String toString()
        {
            return "id: " + id.toString() + " Fruit name: " + name;
        }
}
