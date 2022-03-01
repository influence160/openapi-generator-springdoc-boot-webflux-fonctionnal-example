package othmen.test.openapigenerator.springdoc.demo.app4.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import othmen.test.openapigenerator.springdoc.demo.app4.api.ApiApi;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;


@Configuration
public class RoutingConfiguration {

	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler) {
		return route().GET("/api/user/index", accept(APPLICATION_JSON), userHandler::getAll, ops -> ops.beanClass(ApiApi.class).beanMethod("getAllUsers")).build()
				.and(route().GET("/api/user/{id}", accept(APPLICATION_JSON), userHandler::getUser, ops -> ops.beanClass(ApiApi.class).beanMethod("getUserById")).build()
						.and(route().POST("/api/user/post", accept(APPLICATION_JSON), userHandler::postUser, ops -> ops.beanClass(ApiApi.class).beanMethod("saveUser")).build())
						.and(route().PUT("/api/user/put/{id}", accept(APPLICATION_JSON), userHandler::putUser, ops -> ops.beanClass(ApiApi.class).beanMethod("putUser")).build())
						.and(route().DELETE("/api/user/delete/{id}", accept(APPLICATION_JSON), userHandler::deleteUser, ops -> ops.beanClass(ApiApi.class).beanMethod("deleteUser")).build()));
	}

}