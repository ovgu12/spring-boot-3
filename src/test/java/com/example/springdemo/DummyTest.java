package com.example.springdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.springdemo.book.dto.BookDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class DummyTest {

	@Mock
	List<String> strs;

    @Spy
    Map<String, String> mappings;
	
	@Test
	void test1() {
		when(strs.size()).thenReturn(2);
		assertEquals(2, strs.size());
	}

	@Test
	void testJson() throws JsonProcessingException {
		var mapper =  new ObjectMapper();
		assertEquals("{\"id\":1,\"title\":\"hello\",\"authorName\":\"Max\"}", mapper.writeValueAsString(new BookDTO(1L,"hello", "Max")), "null");
	}
}
