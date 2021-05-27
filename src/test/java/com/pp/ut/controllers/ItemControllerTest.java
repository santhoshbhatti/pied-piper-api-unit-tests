package com.pp.ut.controllers;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import  org.mockito.ArgumentMatchers;
import com.pp.ut.service.ItemService;
import com.pp.ut.vos.Item;
@WebMvcTest(ItemController.class)
class ItemControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	ItemService itemService;
	@Test
	void testItemControllerBasic() throws Exception {
		RequestBuilder requestBuilder=MockMvcRequestBuilders
				.get("/item")
				.accept(MediaType.APPLICATION_JSON);
		//we can match a json . We can matcha part of json
		//by providing  only ke/value that are required
		mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())
		.andExpect(content().json("{\"id\":10,\"name\":\"Tennis Ball\",\"price\":10.5,\"quantity\":10}"))
		.andReturn();
		
		
	}
	
	
	@Test
	public void testItemFromService() throws Exception {
		
		when(itemService.getTopItem())
		.thenReturn(new Item(10,"rose-bud",20.0,10));
		RequestBuilder builder = MockMvcRequestBuilders
							.get("/item-from-service")
							.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(builder)
		.andExpect(status().isOk())
		.andExpect(content().json("{id:10,name:rose-bud,price:20.0,quantity:10}"))
		.andReturn();
							
	}
	
	@Test
	public void testItemFromDb() throws Exception {
		
		when(itemService.getAllItems())
		.thenReturn(java.util.Arrays.asList(new Item(10,"rose-bud",20.0,10),
				new Item(20,"baygon-spary",20.0,20)));
		RequestBuilder builder = MockMvcRequestBuilders
							.get("/item-from-db")
							.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(builder)
		.andExpect(status().isOk())
		.andExpect(content().json("[{id:10,name:rose-bud,price:20.0,quantity:10},{}]"))
		.andReturn();
							
	}
	
	@Test
	public void testSaveItem() throws Exception {
		when(itemService.saveItem(ArgumentMatchers.any(Item.class)))
		.thenReturn(new Item(10,"pencil",2.0,35));
		
		RequestBuilder builder = MockMvcRequestBuilders
				.post("/item")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"name\":\"pencil\",\"price\":2.0,\"quantity\":35}");
		mockMvc.perform(builder)
		.andExpect(status().isCreated())
		.andExpect(header().exists("location"))
		.andExpect(header().string("location","http://localhost/item/10"))
		.andExpect(content().json("{id:10,name:pencil,price: 2.0,quantity:35}"))
		.andReturn();
		
	}

}
