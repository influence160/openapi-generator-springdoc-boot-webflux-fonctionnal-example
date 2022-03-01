package othmen.test.openapigenerator.springdoc.demo.app4.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import othmen.test.openapigenerator.springdoc.demo.app4.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {

    public Mono<User> getUserById(Long id);

    public Flux<User> getAllUsers();

    public Flux<User> getAllUsers(String firstname);

    public Mono<Void> saveUser(Mono<User> user);

    public Mono<User> putUser(Long id, Mono<User> user);

    public Mono<String> deleteUser(Long id);
}
