package lk.ijse.absd.entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY )
    private List<Order> order;

    public Customer() {
    }

    public Customer(String id, String name, String address,List<Order> order) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setOrder(order);
    }
    public Customer(String id, String name, String address) {
        this.setId(id);
        this.setName(name);
        this.setAddress(address);
        this.setOrder(order);
    }
    public String getId() {
        return id;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order)
    {
        this.order = order;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", order='" + order + '\'' +
                '}';
         }
    }