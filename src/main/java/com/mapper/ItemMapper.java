package com.mapper;

import com.dto.ItemDto;
import com.entities.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {
    public List<ItemDto> mapItemToItemDto(List<Item> items) {
        return items.stream().map(item -> new ItemDto(item.getItemId(), item.getName())).collect(Collectors.toList());
    }

    public ItemDto mapItemToItemDto(Item item) {
        return new ItemDto(item.getItemId(), item.getName());
    }
}
