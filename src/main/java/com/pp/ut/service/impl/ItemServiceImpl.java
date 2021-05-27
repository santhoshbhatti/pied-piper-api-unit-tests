package com.pp.ut.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.ut.repo.ItemRepository;
import com.pp.ut.service.ItemService;
import com.pp.ut.vos.Item;
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public Item getTopItem() {
		
		return new Item(10,"rose-bud",20.0,10);
	}

	
	@Override
	public List<Item> getAllItems(){
		List<Item> items = itemRepository.findAll();
		items.forEach(item -> item.setValue(item.getPrice() * item.getQuantity()));
		return items;
	}
	
	
	@Override
	public Item getItemById(Integer id) {
		Optional<Item> item = itemRepository.findById(id);
		
		if(item.isPresent()) {
			Item i=item.get();
			i.setValue(i.getQuantity()*i.getPrice());
			return i;
		}
		return null;
	}


	@Override
	public Item saveItem(Item item) {
		
		return itemRepository.save(item);
	}
}


