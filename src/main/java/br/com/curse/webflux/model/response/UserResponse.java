package br.com.curse.webflux.model.response;

public record UserResponse(
        String id,
        String name,
        String email,
        String password
) {
}
