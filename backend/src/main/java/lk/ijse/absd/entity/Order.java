package lk.ijse.absd.entity;

import javax.persistence.*;

@Entity
@Table(name = "Orders")//required if table name is differ
public class Order {

    @Id
    private String oid;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
    private String date;


    public Order() {
    }

    public Order(String oid, Customer customer, String date) {
        this.setOid(oid);
        this.setDate(date);
        this.setCustomer(customer);
    }

    public void setOid(String oid) {

        this.oid=oid;
    }
    public String getOid() {
        return this.oid;
    }

    public void setCustomer(Customer customer) {

        this.customer=customer;
    }
    public Customer getCustomer() {

        return this.customer;
    }

    public String getDate() {

        return this.date;
    }
    public void setDate(String date)
    {
        this.date=date;
    }




    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", date='" + date + '\'' +
                ", customer='" + customer + '\'' +
                '}';
    }
}
