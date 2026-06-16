package com.springboot.docker_app.service;

import com.springboot.docker_app.model.Item;
import com.springboot.docker_app.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAll() {
        return itemRepository.findAll();
    }

    public Item add(Item item) {
        return itemRepository.save(item);
    }
}
