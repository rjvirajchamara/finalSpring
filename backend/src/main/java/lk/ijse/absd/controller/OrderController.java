package lk.ijse.absd.controller;

import lk.ijse.absd.dto.CustomerDTO;
import lk.ijse.absd.dto.ItemDTO;
import lk.ijse.absd.dto.OrderDTO;
import lk.ijse.absd.dto.OrderDetailList;
import lk.ijse.absd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

   //@PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @PostMapping("/{oid}")
    public String saveOrder(@PathVariable("oid") String oid,@RequestBody OrderDetailList olist){
        orderService.saveOrder(oid,olist);
        return "{\"Success\": \"Order Saved\"}";

        // public String saveCustomer(@RequestParam Map<String,String> params)
        // public String saveCustomer(@RequestParam(name="items,defaultValue="itrtem001") String item)
    }
}
