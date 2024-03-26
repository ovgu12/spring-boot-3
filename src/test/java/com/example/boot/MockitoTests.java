package com.example.boot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTests {

    @Mock
    List<String> tests;

    @Spy
    Map<String, String> mappings;

    @Test
    void testMock() {
        when(tests.size()).thenReturn(2);
        assertEquals(2, tests.size());
        mappings.put("test", "me");
        verify(mappings).put("test", "me");
    }

    @Test
    void testJson() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        assertEquals("{\"id\":1,\"title\":\"hello\"}",
                mapper.writeValueAsString(new HelloJson(1L, "hello")), "null");
    }

    private record HelloJson(Long id, String title) {
    }

}
