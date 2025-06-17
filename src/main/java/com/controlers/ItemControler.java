package com.controlers;

import com.dto.ItemDto;
import com.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemControler {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody ItemDto itemRequest, Authentication authentication) {
        String username = authentication.getName();
        ItemDto itemDto = itemService.createItem(itemRequest, username);
        return ResponseEntity.ok(itemDto);
    }

    @GetMapping
    public ResponseEntity<?> getItems(Authentication authentication) {
        String items = itemService.getItems(authentication.getName());
        return ResponseEntity.ok(items);
    }
}
