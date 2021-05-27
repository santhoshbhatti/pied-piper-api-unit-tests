package com.pp.ut.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pp.ut.vos.Item;

@DataJpaTest
class ItemRepositoryTest {
	
	@Autowired
	ItemRepository itemRepo;

	@Test
	void testFindAll() {
		List<Item> items = itemRepo.findAll();
		assertEquals(4, items.size());
	}

}
