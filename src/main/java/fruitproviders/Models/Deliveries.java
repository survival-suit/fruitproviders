package fruitproviders.Models;

import javax.persistence.*;
import java.sql.Date;
import java.util.UUID;

/*Класс поставок*/
public class Deliveries {
    private UUID id;
    private double weight;
    @Temporal(TemporalType.DATE)
    private Date date;
    private int idPricePeriod;

    Deliveries(){}

    Deliveries(UUID id, double weight, Date date, int idPricePeriod)
        {
        this.id = id;
        this.weight = weight;
        this.date = date;
        this.idPricePeriod = idPricePeriod;
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

    public int getIdPricePeriod() {
        return idPricePeriod;
    }

    public void setIdPricePeriod(int idPricePeriod) {
        this.idPricePeriod = idPricePeriod;
    }
}
