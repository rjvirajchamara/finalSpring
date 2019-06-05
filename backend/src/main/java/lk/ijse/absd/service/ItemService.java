package lk.ijse.absd.service;

import lk.ijse.absd.dto.ItemDTO;

import java.util.List;

public interface ItemService {

    void saveItem(String code, ItemDTO itemDTO);
    void deleteItem(String code);
    void updateItem(String code, ItemDTO itemDTO);
    ItemDTO findItem(String code);
    List<ItemDTO> findAllItems();
    List<ItemDTO> finditemsLike(String name);
    long getItemCount();

}
