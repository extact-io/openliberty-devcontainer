package io.extact.openliberty.sample.webapi.resource;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import lombok.Cleanup;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;

public class PersonResourceIT {

    private static final String TARGET_URL = "http://localhost:9080/dev/api/persons";

    @Test
    void testGet() {
        var expected = new Person(1L, "taro", 12);
        @Cleanup var client = ClientBuilder.newClient();
        @Cleanup var response = client
                .target(TARGET_URL)
                .path("{id}")
                .resolveTemplate("id", 1)
                .request()
                .get();
        var actual = response.readEntity(Person.class);

        assertEquals(expected, actual);
    }

    @Test
    void testAdd() {
        @Cleanup var client = ClientBuilder.newClient();
        @Cleanup var response = client
                .target(TARGET_URL)
                .request()
                .post(Entity.json(new Person(null, "test" + LocalDateTime.now(), 99)));
        var actual = response.readEntity(Person.class);
        assertNotNull(actual);
    }

    @Test
    void testFind() {
        @Cleanup var client = ClientBuilder.newClient();
        @Cleanup var response = client
                .target(TARGET_URL)
                .queryParam("name", "taro")
                .request()
                .get();
        var actual = response.readEntity(new GenericType<List<Person>>() {});
        assertEquals(1, actual.size());
    }
}
