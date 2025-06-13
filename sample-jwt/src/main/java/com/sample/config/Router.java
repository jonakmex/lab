package com.sample.config;

import com.sample.handler.OpenHandler;
import com.sample.handler.RestrictedHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class Router {
    @Bean
    public RouterFunction<ServerResponse> route (OpenHandler openHandler, RestrictedHandler restrictedHandler) {
        return RouterFunctions.route(
                GET("/hello").and(accept(MediaType.APPLICATION_JSON)), openHandler::greeting).andRoute(
                GET("/restricted").and(accept(MediaType.APPLICATION_JSON)), restrictedHandler::greeting
        );
    }
}
