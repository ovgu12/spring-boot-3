package com.example.boot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class BootApplicationTests {

    @Autowired
    ApplicationContext ctx;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(ctx);
    }

}
