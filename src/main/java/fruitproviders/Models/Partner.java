package fruitproviders.Models;

import java.util.UUID;

/*Класс поставщиков*/
public class Partner {
    private UUID id;
    private String name;
    Partner(){}
    Partner(UUID id, String name) { this.id = id; this.name = name; }

    public UUID getId() { return id; }

    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}
