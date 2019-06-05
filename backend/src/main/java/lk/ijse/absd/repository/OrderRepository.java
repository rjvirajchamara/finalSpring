package lk.ijse.absd.repository;

import lk.ijse.absd.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {


}
