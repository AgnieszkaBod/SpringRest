package com.mapper;

import com.dto.ItemDto;
import com.entities.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemMapper {
    public List<ItemDto> mapItemToItemDto(List<Item> items) {

        return new ArrayList<>();
    }

    public ItemDto mapItemToItemDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setName(item.getName());
        return itemDto;


    }
}
