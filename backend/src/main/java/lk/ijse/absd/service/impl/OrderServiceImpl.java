package lk.ijse.absd.service.impl;


import lk.ijse.absd.dto.CustomerDTO;
import lk.ijse.absd.dto.ItemDTO;
import lk.ijse.absd.dto.OrderDTO;
import lk.ijse.absd.dto.OrderDetailList;
import lk.ijse.absd.entity.*;
import lk.ijse.absd.repository.ItemRepository;
import lk.ijse.absd.repository.OrderDetailRepository;
import lk.ijse.absd.repository.OrderRepository;
import lk.ijse.absd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrder(String oid,OrderDetailList oList) {
        if(!oList.getOrderDTO().getOid().equals(oid)){
            throw  new RuntimeException(" Order Id Is mismatch");
        }else{
            OrderDetail od=new OrderDetail();
            Customer customer=new Customer();
            customer.setId(oList.getOrderDTO().getCustomer().getId());
            Order order=new Order(oList.getOrderDTO().getOid(),customer,oList.getOrderDTO().getDate());
            Order save = orderRepository.save(order);
            System.out.println( " order service : order saved  ");
            System.out.println( " order service : customer  "+customer);
            System.out.println( " order service : order  "+order);
            System.out.println( " order service : oList  "+oList);

            for(ItemDTO item:oList.getItemDTOList()){

                System.out.println( " order service : orderdetail  procesed... ");
                Item it=itemRepository.findById(item.getCode()).get();
                it.setQty(it.getQty()-item.getQty());
                itemRepository.save(it);
                od.setOrderDetail_pk(new OrderDetail_PK(item.getCode(),order.getOid()));
                od.setOrderQty(item.getQty());
                od.setOrderPrice(item.getAmount());
                orderDetailRepository.save(od);

            }
            System.out.println( " order service : orderdetail  saved..... ");



        }

  }
}
