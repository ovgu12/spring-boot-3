package com.example.boot;

import com.example.boot.book.dto.BookDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    @Mock
    List<String> strs;

    @Spy
    Map<String, String> mappings;

    @Test
    void testMock() {
        when(strs.size()).thenReturn(2);
        assertEquals(2, strs.size());
        mappings.put("test", "me");
        verify(mappings).put("test", "me");
    }

    @Test
    void testJson() throws JsonProcessingException {
        var mapper = new ObjectMapper();
        assertEquals("{\"id\":1,\"title\":\"hello\",\"authorName\":\"Max\"}",
                mapper.writeValueAsString(new BookDTO(1L, "hello", "Max")), "null");
    }

    @Test
    void testDummy() throws Exception {
        try (var ins = getClass().getClassLoader().getResourceAsStream("dummy.txt")) {
            if (ins != null) {
                Arrays.stream(new String(ins.readAllBytes())
                                .split(System.lineSeparator()))
                        .map(String::toUpperCase)
                        .forEach(System.out::println);
            }
        }
    }

    @Test
    void testIo() throws Exception {
        var url = getClass().getClassLoader().getResource("dummy.txt");
        if (url != null) {
            try (var lines = Files.lines(Path.of(url.getPath()))) {
                lines.skip(1).forEach(System.out::println);
            }
        }
    }

}
