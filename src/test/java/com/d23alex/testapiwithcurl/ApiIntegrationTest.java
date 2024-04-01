package com.d23alex.testapiwithcurl;


import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.IOException;

import static com.d23alex.testapiwithcurl.CurlRunner.runCurlScript;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestApiWithCurlApplication.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class ApiIntegrationTest {

    @Autowired
    public ProductRepository productRepository;

    @LocalServerPort
    private int port;

    @Test
    @Sql("classpath:sql/load-1-product.sql")
    @DirtiesContext
    public void testApiIntegration1() throws IOException, InterruptedException {
        assertEquals(1, productRepository.findAll().size());

        String response = runCurlScript(new File(System.getProperty("user.dir") + "/src/test/resources/curl/add-product.sh"), port);

        assertEquals(2, productRepository.findAll().size());
    }

    @Test
    @Sql("classpath:sql/load-1-product.sql")
    @DirtiesContext
    public void testApiIntegration2() throws IOException, InterruptedException {
        assertEquals(1, productRepository.findAll().size());

        String response = runCurlScript(new File(System.getProperty("user.dir") + "/src/test/resources/curl/add-product.sh"), port);

        assertEquals(2, productRepository.findAll().size());
    }
}
