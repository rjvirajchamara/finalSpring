package lk.ijse.absd.controller;

import lk.ijse.absd.dto.ItemDTO;
import lk.ijse.absd.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/{code}")
    public String saveItem(@PathVariable("code")String code, @RequestBody ItemDTO itemDTO){
        System.out.println("***********save item ********");
        itemService.saveItem(code,itemDTO);
        return "{\"Success\": \"Item Saved\"}";
    }

    @DeleteMapping("/{code}")
    public String deleteItem(@PathVariable("code") String code ){
        System.out.println("***********delete item ********");
        itemService.deleteItem(code);
        return "{\"Success\": \"Item Deleted\"}";
    }

    @PutMapping("/{code}")
    public String updateItem(@PathVariable("code") String code,@RequestBody ItemDTO itemDTO){
        System.out.println("***********update item ********");
        itemService.updateItem(code,itemDTO);
        return "{\"Success\": \"Item Updated\"}";
    }

    @GetMapping("/{code}")
    public ItemDTO findItem(@PathVariable("code") String code){
        System.out.println("***********find  item ********");
        return itemService.findItem(code);
    }

    @GetMapping
    public Object itemList(@RequestParam(value = "action",required = false) String action,@RequestParam(value = "description",required = false) String descriptipn){
        System.out.println("***********  item  list********");

        if(action!=null){
            switch (action){
                case "count": return itemService.getItemCount();
                case "like" :return itemService.finditemsLike(descriptipn);
                default:return itemService.findAllItems();
            }
        }else{
            return itemService.findAllItems();
        }
    }



}
