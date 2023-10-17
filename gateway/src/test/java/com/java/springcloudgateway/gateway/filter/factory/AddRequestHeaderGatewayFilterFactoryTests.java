package com.java.springcloudgateway.gateway.filter.factory;

import com.java.springcloudgateway.gateway.test.BaseWebClientTests;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;

import static com.java.springcloudgateway.gateway.test.TestUtils.getMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@DirtiesContext
@ActiveProfiles(profiles = "request-header-web-filter")
public class AddRequestHeaderGatewayFilterFactoryTests extends BaseWebClientTests {

    @Test
    public void addRequestHeaderFilterWorks() {
        testClient.get().uri("/headers").header("Host", "www.addrequestheader.org").exchange().expectBody(Map.class)
                .consumeWith(result -> {
                    Map<String, Object> headers = getMap(result.getResponseBody(), "headers");
                    assertThat(headers).containsEntry("X-Request-Example", "ValueA");
                });
    }
}
