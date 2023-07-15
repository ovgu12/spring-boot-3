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
}
