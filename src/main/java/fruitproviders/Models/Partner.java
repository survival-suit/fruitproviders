package fruitproviders.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*Класс поставщиков*/
@Entity
@Table(name = "Partners")
public class Partner {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PricePeriod> pricePeriodList;

    public Partner(){}

    public Partner(String name) {
        this.name = name;
        this.pricePeriodList = new ArrayList<>();
    }

    public Partner(UUID id, String name) { this.id = id; this.name = name; }

    public void addPricePeriod(PricePeriod pricePeriod) {
        pricePeriod.setPartner(this);
        pricePeriodList.add(pricePeriod);
    }

    public void removePricePeriod(PricePeriod pricePeriod) {
        pricePeriodList.remove(pricePeriod);
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<PricePeriod> getPricePeriodList() {
        return pricePeriodList;
    }
    public void setPricePeriodList(List<PricePeriod> pricePeriodList) {
        this.pricePeriodList = pricePeriodList;
    }

}
