package com.services;

import com.dto.ItemDto;
import com.entities.Item;
import com.entities.User;
import com.mapper.ItemMapper;
import com.mapper.UserRegistrationMapper;
import com.repository.ItemRepository;
import com.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private ItemRepository itemRepository;

    private UserRepository userRepository;

    public ItemDto createItem(ItemDto request, String username) {
        User owner = userRepository.findByLogin(username)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        ItemMapper itemMapper = new ItemMapper();
        Item item = new Item();
        item.setName(request.getName());
        item.setOwner(owner);
        itemRepository.save(item);
        return itemMapper.mapItemToItemDto(item);
    }

    public String getItems(String username) {
        User owner = userRepository.findByLogin(username)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        String items = itemRepository.findByOwner_Uuid(owner.getUuid());
        return items;
    }
}
