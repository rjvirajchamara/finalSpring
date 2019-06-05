package lk.ijse.absd.dto;

import lk.ijse.absd.entity.OrderDetail_PK;

public class OrderDetailDTO {
    private int orderQty;
    private double orderPrice;
    private ItemDTO itemdto;
    private OrderDTO order;
    private OrderDetail_PK orderDetail_PK;


    public OrderDetailDTO() {

    }

    public OrderDetailDTO(int orderQty, double orderPrice, ItemDTO item, OrderDTO order, OrderDetail_PK orderDetail_PK) {
        this.orderQty = orderQty;
        this.orderPrice = orderPrice;
        this.itemdto = item;
        this.order = order;
        this.orderDetail_PK = orderDetail_PK;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public ItemDTO getItemdto() {
        return itemdto;
    }

    public void setItemdto(ItemDTO itemdto) {
        this.itemdto = itemdto;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public OrderDetail_PK getOrderDetail_PK() {
        return orderDetail_PK;
    }

    public void setOrderDetail_PK(OrderDetail_PK orderDetail_PK) {
        this.orderDetail_PK = orderDetail_PK;
    }

}
