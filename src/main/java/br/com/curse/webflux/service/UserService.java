package br.com.curse.webflux.service;

import br.com.curse.webflux.entity.User;
import br.com.curse.webflux.mapper.UserMapper;
import br.com.curse.webflux.model.request.UserRequest;
import br.com.curse.webflux.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest request) {
        return repository.save(mapper.toEntity(request));
    }
}
