package com.repository;

import com.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select i.name, i.itemId from Item i where i.owner.uuid = ?1")
String findByOwner_Uuid(UUID ownerId);

}
