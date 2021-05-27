package com.pp.ut.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pp.ut.service.ItemService;
import com.pp.ut.vos.Item;

@RestController
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/item")
	public Item getItem() {
		return new Item(10,"Tennis Ball",10.5,10);
	}
	
	@GetMapping("/item-from-service")
	public Item getItemFromService() {
		Item item=itemService.getTopItem();
		return item;
	}
	
	@GetMapping("/item-from-db")
	public List<Item> getAllItems() {
		List<Item> items=itemService.getAllItems();
		return items;
	}
	
	@PostMapping("/item")
	public ResponseEntity<Item> saveItem(@RequestBody Item item){
		Item savedItem=itemService.saveItem(item);
		URI uri=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedItem.getId())
				.toUri();
		ResponseEntity<Item> resp=ResponseEntity.created(uri).body(savedItem);
		return resp;
	}

}
