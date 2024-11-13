package br.com.curse.webflux.controller;

import br.com.curse.webflux.entity.User;
import br.com.curse.webflux.mapper.UserMapper;
import br.com.curse.webflux.model.request.UserRequest;
import br.com.curse.webflux.service.UserService;
import com.mongodb.reactivestreams.client.MongoClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static reactor.core.publisher.Flux.just;
import static reactor.core.publisher.Mono.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureWebClient
class UserControllerImplTest {

    private static final String ID = "123456";
    private static final String NAME = "Lucas";
    private static final String EMAIL = "lucas@mail.com";
    private static final String PASSWORD = "123";
    private static final String BASE_URI = "/users";

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private UserService service;

    @MockBean
    private UserMapper mapper;

    @MockBean
    private MongoClient mongoClient;

    @Test
    @DisplayName("Test endpoint save with success")
    void testSaveWithSuccess() {
        final var request = new UserRequest(NAME, EMAIL, PASSWORD);

        when(service.save(any(UserRequest.class))).thenReturn(just(User.builder().build()));

        webTestClient.post().uri(BASE_URI)
                .contentType(APPLICATION_JSON)
                .body(fromValue(request))
                .exchange()
                .expectStatus().isCreated();

        verify(service).save(any(UserRequest.class));
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}