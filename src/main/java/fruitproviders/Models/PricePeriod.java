package fruitproviders.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PricePeriod")
public class PricePeriod {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private int price; /*под финансы лучше юзать BigDecimal, пока ограничимся целочисленными*/

    @Column(nullable = false)
    private Date dateBegin;

    @Column(nullable = false)
    private Date dateEnd;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partner_id", nullable = false)
    private Partner partner;

    @Transient
    private UUID partnerId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fruittype_id", nullable = false)
    private FruitType fruitType;

    @Transient
    private UUID fruitTypeId;

    @OneToMany(mappedBy = "pricePeriod", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Delivery> deliveriesList;

    public PricePeriod(){}

    public PricePeriod(int price, Date dateBegin, Date dateEnd){
        this.price = price;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.deliveriesList = new ArrayList<>();
    }

    public PricePeriod(UUID id, int price, Date dateBegin, Date dateEnd){
        this.id = id;
        this.price = price;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public void addFruitType(Delivery delivery) {
        delivery.setPricePeriod(this);
        deliveriesList.add(delivery);
    }

    public void removeFruitType(Delivery delivery) {
        deliveriesList.remove(delivery);
    }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id){ this.id = id; }

    public int getPrice(){ return price; }
    public void setPrice(int price){ this.price = price; }

    public Date getDateBegin() {
        return dateBegin;
    }
    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Partner getPartner() {
        return partner;
    }
    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public FruitType getFruitType() {
        return fruitType;
    }
    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public UUID getFruitTypeId() {
        return fruitTypeId;
    }
    public void setFruitTypeId(UUID fruitTypeId) {
        this.fruitTypeId = fruitTypeId;
    }

    public UUID getPartnerId() {
        return partnerId;
    }
    public void setPartnerId(UUID partnerId) {
        this.partnerId = partnerId;
    }

    public List<Delivery> getDeliveriesList() {
        return deliveriesList;
    }
    public void setDeliveriesList(List<Delivery> deliveriesList) {
        this.deliveriesList = deliveriesList;
    }
}
