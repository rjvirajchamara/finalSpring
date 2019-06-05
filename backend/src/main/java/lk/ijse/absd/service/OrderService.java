package lk.ijse.absd.service;

import lk.ijse.absd.dto.CustomerDTO;
import lk.ijse.absd.dto.ItemDTO;
import lk.ijse.absd.dto.OrderDTO;
import lk.ijse.absd.dto.OrderDetailList;

import java.util.List;

public interface OrderService {

    void saveOrder(String oid,OrderDetailList orderDetailList);
}
