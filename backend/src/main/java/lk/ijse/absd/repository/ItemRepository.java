package lk.ijse.absd.repository;

import lk.ijse.absd.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository  extends JpaRepository<Item,String> {

    @Query("SELECT i FROM Item  i WHERE i.description like ?1")
    List<Item> findByDescriptionLike(String name);

//    @Query("SELECT i FROM Item  i WHERE i.description like ?#{[0]}")
//     List<Item> letsfindItemsByname(String description);

}
