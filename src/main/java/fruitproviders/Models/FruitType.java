package fruitproviders.Models;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fruit_id", nullable = false)
    private Fruit fruit;

    @Transient
    private UUID fruitId;

    @OneToMany(mappedBy = "fruitType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PricePeriod> pricePeriodList;

    public FruitType() {}

    public FruitType(String name) {
        this.name = name;
        this.pricePeriodList = new ArrayList<>();
    }

    public FruitType(UUID id, String name){
        this.id = id;
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

    public UUID getFruitId() {
        return fruitId;
    }

    public void setFruitId(UUID fruitId) {
        this.fruitId = fruitId;
    }

    public String toString() {
        return "id: " + id.toString() + " FruitType name: " + name;
    }
}