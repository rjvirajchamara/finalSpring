package lk.ijse.absd.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {

    @Id
    private String code;
    private String description;
    private double price;
    private int qty;


    public Item() {
    }

    public Item(String code, String decription, double price, int qty) {
        this.setCode(code);
        this.setDescription(decription);
        this.setPrice(price);
        this.setQty(qty);
    }

    public void setQty(int qty) {

        this.qty=qty;
    }
    public int getQty() {
        return this.qty;
    }

    public void setPrice(double price) {

        this.price=price;
    }
    public double getPrice() {

        return this.price;
    }

    public String getDescription() {

        return this.description;
    }
    public void setDescription(String decription)
    {
        this.description=decription;
    }

    public void setCode(String code)
    {
        this.code=code;
    }

    public String getCode()
    {
        return this.code;
    }


    @Override
    public String toString() {
        return "Item{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
