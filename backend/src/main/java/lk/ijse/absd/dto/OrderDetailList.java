package lk.ijse.absd.dto;

import java.util.List;

public class OrderDetailList {
    private List<ItemDTO> itemDTOList;
    private OrderDTO orderDTO;

    OrderDetailList(){}
    OrderDetailList(List<ItemDTO> itemDTOList,OrderDTO orderDTO){
        this.itemDTOList=itemDTOList;
        this.orderDTO=orderDTO;

    }

    public void setItemDTOList(List<ItemDTO> itemDTOList){
        this.itemDTOList=itemDTOList;
    }
    public List<ItemDTO> getItemDTOList(){
        return this.itemDTOList;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }
    public String toString(){
        return "OrderDetailList : ["+this.itemDTOList+","+this.orderDTO+"]";
    }
}
