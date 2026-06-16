package com.springboot.docker_app.controller;

import com.springboot.docker_app.model.Item;
import com.springboot.docker_app.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/all")
    public List<Item> getAll(){
        return itemService.getAll();
    }

    @PostMapping("/add")
    public Item add(@RequestBody Item item){
        return itemService.add(item);
    }
}
