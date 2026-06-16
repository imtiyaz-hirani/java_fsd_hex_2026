package com.springboot.docker_app.repository;

import com.springboot.docker_app.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
