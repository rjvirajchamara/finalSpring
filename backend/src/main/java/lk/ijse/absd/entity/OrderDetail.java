package lk.ijse.absd.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@IdClass(OrderDetail_PK.class)//for composite key
public class OrderDetail {

    @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumns(@JoinColumn(name = "code",referencedColumnName = "code",insertable = false,updatable = false))
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "oid",referencedColumnName = "oid",insertable = false,updatable = false))
    private Order order;
    private int orderqty;
    private double orderPrice;

    @EmbeddedId
    private OrderDetail_PK orderDetail_pk;


    public OrderDetail() {
    }

    public OrderDetail(String code,String oid,int orderQty,double orderPrice,Order order, Item item,OrderDetail_PK orderDetail_pk) {

        this.orderqty = orderQty;
        this.orderPrice = orderPrice;
        this.order = order;
        this.item = item;
        orderDetail_pk = new OrderDetail_PK(code, oid);
    }

    public OrderDetail(int orderQty,double orderPrice,Order order, Item item,OrderDetail_PK orderDetail_pk) {
        this.orderqty = orderQty;
        this.orderPrice = orderPrice;
        this.order = order;
        this.item = item;
        this.orderDetail_pk = orderDetail_pk;
    }

    /**
     * @return the orderQty
     */
    public int getOrderQty() {
        return orderqty;
    }

    /**
     * @param orderQty the orderQty to set
     */
    public void setOrderQty(int orderQty) {
        this.orderqty = orderQty;
    }

    /**
     * @return the orderPrice
     */
    public double getOrderPrice() {
        return orderPrice;
    }

    /**
     * @param orderPrice the orderPrice to set
     */
    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * @return the item
     */
    public Item getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * @return the orders
     */
    public Order getOrders() {
        return order;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(Order orders) {
        this.order = orders;
    }

    /**
     * @return the orderDetail_pk
     */
    public OrderDetail_PK getOrderDetail_pk() {
        return orderDetail_pk;
    }

    /**
     * @param orderDetail_pk the orderDetail_pk to set
     */
    public void setOrderDetail_pk(OrderDetail_PK orderDetail_pk) {
        this.orderDetail_pk = orderDetail_pk;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderQty=" + orderqty + ", orderPrice=" + orderPrice + ", item=" + item + ", orders=" + order + ", orderDetail_pk=" + orderDetail_pk + '}';
    }

}
