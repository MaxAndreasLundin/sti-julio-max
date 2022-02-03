package se.sti.stijuliomax;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StiJulioMaxApplicationTests {
    /**
     * That a Spring Boot application compiles does not mean it will successfully start.
     * If you should have one single test in a Spring Boot application it should be a contextLoads.
     * To not require a running Postgres server we use H2 instead.
     */
    @Test
    void contextLoads() {
    }
}
