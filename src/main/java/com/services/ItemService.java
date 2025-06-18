package com.services;

import com.dto.ItemDto;
import com.entities.Item;
import com.entities.User;
import com.mapper.ItemMapper;
import com.repository.ItemRepository;
import com.repository.UserRepository;

import java.util.List;


public class ItemService {
    private ItemRepository itemRepository;
    private ItemMapper itemMapper;
    private UserRepository userRepository;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper, UserRepository userRepository) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.userRepository = userRepository;
    }

    public ItemDto createItem(ItemDto request, String username) {
        User owner = userRepository.findByLogin(username)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        Item item = new Item();
        item.setName(request.getName());
        item.setOwner(owner);
        itemRepository.save(item);
        return itemMapper.mapItemToItemDto(item);
    }

    public List<ItemDto> getItems(String username) {
        User owner = userRepository.findByLogin(username)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        return itemMapper.mapItemToItemDto(itemRepository.findByOwner_Uuid(owner.getUuid()));
    }
}
