package fruitproviders.Models;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.*;

/*Класс сортов фруктов*/
@Entity
@Table(name = "FruitTypes")
public class FruitType {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Fruit fruit;

    public FruitType() {}

    public FruitType(String name) {
        this.name = name;
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

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public String toString() {
        return "id: " + id.toString() + " FruitType name: " + name;
    }
}