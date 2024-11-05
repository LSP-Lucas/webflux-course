package br.com.curse.webflux.model.request;

public record UserRequest(
        String name,
        String email,
        String password
) {
}
