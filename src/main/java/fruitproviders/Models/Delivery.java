package fruitproviders.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

/*Класс поставок*/
@Entity
@Table(name = "Deliveries")
public class Delivery {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "priceperiod_id", nullable = false)
    private PricePeriod pricePeriod;

    @Transient
    private UUID pricePeriodId;

    public Delivery(){}


    public Delivery(UUID id, double weight, Date date)
        {
        this.id = id;
        this.weight = weight;
        this.date = date;
        }

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public PricePeriod getPricePeriod() {
        return pricePeriod;
    }
    public void setPricePeriod(PricePeriod pricePeriod) {
        this.pricePeriod = pricePeriod;
    }

    public UUID getPricePeriodId() {
        return pricePeriodId;
    }
    public void setPricePeriodId(UUID pricePeriodId) {
        this.pricePeriodId = pricePeriodId;
    }
}
