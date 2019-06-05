package lk.ijse.absd.controller;

import lk.ijse.absd.dto.CustomerDTO;
import lk.ijse.absd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;


    //@RequestMapping(value ="/{id}",method = RequestMethod.POST,produces = "application/json")
    @PostMapping(value = "/{id}")
    public String saveCustomer(@PathVariable("id") String customerId,
                             @RequestBody CustomerDTO customerDTO) {

        service.saveCustomer(customerId, customerDTO);
        return "{\"Success\": \"Customer Saved\"}";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable("id") String customerId){

        System.out.println("*********** delete customer **************");
        service.deleteCustomer(customerId);

        return "{\"Success\": \"Customer Deleted\"}";
    }

    @PutMapping("/{id}")
    public String updateCustomer(@PathVariable("id") String customerId,
                               @RequestBody CustomerDTO customerDTO){
        System.out.println( "post req"+customerId);
        service.updateCustomer(customerId, customerDTO);

        return "{\"Success\": \"Customer Updated\"}";
    }

    @GetMapping("/{id}")
    public CustomerDTO findCustomer(@PathVariable("id") String customerId){
        System.out.println("*********** search customer ***************");

        return service.findCustomer(customerId);
    }

    @GetMapping
    public Object findAllCustomers(@RequestParam(value = "action", required = false) String action
                ,@RequestParam(value="name", required = false) String name){
        System.out.println("request "+action+" name "+name);
        System.out.println("action =");
        if (action !=null){
            switch (action){
                case "count":
                    return service.getCustomersCount();
                case "like":
                    System.out.println("like case called");
                    return service.findCustomersLike(name);
                default:
                    return service.findAllCustomers();
            }
        }else {
            return service.findAllCustomers();
        }
    }


}
