package com.pp.ut.service;

import java.util.List;

import com.pp.ut.vos.Item;

public interface ItemService {

	Item getTopItem();

	List<Item> getAllItems();

	Item getItemById(Integer id);

	Item saveItem(Item item);

}
