package com.mapper;

import com.dto.ItemDto;
import com.entities.Item;

import java.util.List;

public class ItemMapper {
    public List<ItemDto> mapItemToItemDto(List<Item> items) {
        return items.stream().map(item -> new ItemDto(item.getItemId(), item.getName())).toList();
    }

    public ItemDto mapItemToItemDto(Item item) {
        return new ItemDto(item.getItemId(), item.getName());
    }
}
