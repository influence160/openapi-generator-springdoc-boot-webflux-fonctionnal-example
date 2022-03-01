package othmen.test.openapigenerator.springdoc.demo.app4.user;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import othmen.test.openapigenerator.springdoc.demo.app4.api.ApiApi;
import othmen.test.openapigenerator.springdoc.demo.app4.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static othmen.test.openapigenerator.springdoc.demo.app4.user.Util.responseEntityToServerResponse;

@Component
public class UserHandler {

    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    /**
     * GET ALL Users
     */
    public Mono<ServerResponse> getAll(ServerRequest request) {
        // fetch all customers from repository
        return userService.getAllUsers(request.exchange())
                .flatMap(Util::responseEntityToServerResponse);
    }

    /**
     * GET a User by ID
     */
    public Mono<ServerResponse> getUser(ServerRequest request) {
        // parse path-variable
        long customerId = Long.valueOf(request.pathVariable("id"));

        // build notFound response 
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        // get customer from repository 
        return userService.getUserById(customerId, request.exchange())
                .flatMap(Util::responseEntityToServerResponse)
                .switchIfEmpty(notFound);
    }

    /**
     * POST a User
     */
    public Mono<ServerResponse> postUser(ServerRequest request) {
        Mono<User> customerMono = request.bodyToMono(User.class);
        return customerMono.flatMap(customer -> userService.saveUser(customer, request.exchange()))
                .flatMap(Util::responseEntityToServerResponse);
    }

    /**
     * PUT a User
     */
    public Mono<ServerResponse> putUser(ServerRequest request) {
        // parse id from path-variable
        long customerId = Long.valueOf(request.pathVariable("id"));

        // get customer data from request object
        Mono<User> customer = request.bodyToMono(User.class);

        // get customer from repository 
        return userService.putUser(customerId, customer.block(), request.exchange())
                .flatMap(Util::responseEntityToServerResponse);
    }

    /**
     * DELETE a User
     */
    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        // parse id from path-variable
        long customerId = Long.valueOf(request.pathVariable("id"));

        // get customer from repository 
        return userService.deleteUser(customerId, request.exchange())
                .flatMap(Util::responseEntityToServerResponse);
    }

}
