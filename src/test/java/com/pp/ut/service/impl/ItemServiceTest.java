package com.pp.ut.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pp.ut.repo.ItemRepository;
import com.pp.ut.vos.Item;
@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {
	
	@Mock
	ItemRepository itemRepository;
	@InjectMocks
	ItemServiceImpl itemService;
	@Test
	public void testGetAllItems() {
		when(itemRepository.findAll())
		.thenReturn(java.util.Arrays.asList(new Item(10,"rose-bud",20.0,30)));
		List<Item> items=itemService.getAllItems();
		assertEquals(items.size(),1);
		assertEquals(20.0*30.0,items.get(0).getValue());
	}
	
	@Test
	public void testGetItemById() {
		when(itemRepository.findById(anyInt()))
		.thenReturn(Optional.ofNullable(new Item(10, "rose-bud", 10.0, 20)));
		
		Item item = itemService.getItemById(10);
		assertEquals(200.0, item.getPrice()*item.getQuantity());
		
	}
	
	@Test
	public void testGetItemByIdNull() {
		when(itemRepository.findById(anyInt()))
		.thenReturn(Optional.ofNullable(null));
		
		Item item = itemService.getItemById(10);
		assertEquals(null, item);
		
	}

}
