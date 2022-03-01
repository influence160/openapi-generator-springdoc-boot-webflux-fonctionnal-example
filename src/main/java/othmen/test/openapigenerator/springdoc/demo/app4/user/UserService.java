package othmen.test.openapigenerator.springdoc.demo.app4.user;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import othmen.test.openapigenerator.springdoc.demo.app4.api.ApiApi;
import othmen.test.openapigenerator.springdoc.demo.app4.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService implements ApiApi{

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Mono<ResponseEntity<String>> deleteUser(Long id, ServerWebExchange exchange) {
        return userRepository.deleteUser(id)
                .map(userId -> ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body(userId));
    }

    public Mono<ResponseEntity<Flux<User>>> getAllUsers(ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.ok().body(userRepository.getAllUsers()));
    }

    public Mono<ResponseEntity<User>> getUserById(Long id, ServerWebExchange exchange) {
        return userRepository.getUserById(id)
                .map(user -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(user));
    }

    public Mono<ResponseEntity<User>> putUser(Long id, User monoUser, ServerWebExchange exchange) {
        return null;
    }

    public Mono<ResponseEntity<Void>> saveUser(User monoUser, ServerWebExchange exchange) {
        return null;
    }
}
