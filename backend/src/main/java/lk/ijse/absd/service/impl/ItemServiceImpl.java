package lk.ijse.absd.service.impl;

import lk.ijse.absd.dto.CustomerDTO;
import lk.ijse.absd.dto.ItemDTO;
import lk.ijse.absd.entity.Customer;
import lk.ijse.absd.entity.Item;
import lk.ijse.absd.repository.ItemRepository;
import lk.ijse.absd.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveItem(String code, ItemDTO itemDTO) {
        if(itemDTO.getCode().equals(code)){
            itemRepository.save(new Item(itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getPrice(),itemDTO.getQty()));
        }else{
            throw new RuntimeException("Item Code is Mismathch");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteItem(String code) {
        itemRepository.deleteById(code);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateItem(String code, ItemDTO itemDTO) {
        if(!itemDTO.getCode().equals(code)){
            throw new RuntimeException("Item Code Is mismatch");
        }
        if(itemRepository.existsById(code)){
            itemRepository.save(new Item(itemDTO.getCode(),itemDTO.getDescription(),itemDTO.getPrice(),itemDTO.getQty()));
        }else{
            throw new RuntimeException("Item Not exist");
        }
    }

    @Override
    public ItemDTO findItem(String code) {
        Item item = itemRepository.findById(code).get();
        return new ItemDTO(item.getCode(),item.getDescription(),item.getPrice(),item.getQty());
    }

    @Override
    public List<ItemDTO> findAllItems() {
        List<Item> itemlist = itemRepository.findAll();
        List<ItemDTO> items=new ArrayList<>();
        itemlist.forEach(item -> items.add(new ItemDTO(item.getCode(),item.getDescription(),item.getPrice(),item.getQty())));
        return items;
    }

    @Override
    public List<ItemDTO> finditemsLike(String name) {
        //List<Item> itemlist = itemRepository. letsfindItemsByname(name+"%");
        //List<Item> itemlist = itemRepository.findItemsByDescriptionIsLike(name+"%");
        List<Item> itemlist = itemRepository.findByDescriptionLike(name);
        System.out.println( "name "+name);
        System.out.println( "itemlist "+itemlist);
        List<ItemDTO> items=new ArrayList<>();
        itemlist.forEach(it->items.add(new ItemDTO(it.getCode(),it.getDescription(),it.getPrice(),it.getQty())));
        return items;
    }

    @Override
    public long getItemCount() {
        return itemRepository.count();
    }
}
