package com.repository;

import com.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByOwner_Uuid(UUID ownerId);

}
