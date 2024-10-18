package com.example.handler;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class HelloHandler {

    public Mono<ServerResponse> greeting (ServerRequest request) {
        return ServerResponse.ok().body(Mono.just("Hello, Spring!"), String.class);
    }
}
