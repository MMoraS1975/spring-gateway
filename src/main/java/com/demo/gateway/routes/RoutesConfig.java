package com.demo.gateway.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Configuration
public class RoutesConfig {
    @Value("${uri.api.clientes}")
    private String clientesUri;

    @Value("${uri.api.cuentas}")
    private String cuentasUri;
//    @Bean
//    public RouteLocator rutasDeClientes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("all_clientes", r -> r.path("/promerica/todos-los-clientes")
//                        .filters(f -> f.rewritePath("/promerica/todos-los-clientes", "/v1/api/cliente/all")
//                                .addRequestHeader("X-GATEWAY-REQUEST-HEADER", "GATEWAY-SOLITUD")
//                                .addResponseHeader("X-GATEYWAY-RESPONSE-HEADER", "GATEWAY_RESPONSE"))
//                        .uri(clientesUri)
//                )
//                .route("cliente_id", r -> r.path("/promerica/cliente/{id}")
//                        .and().method(HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT)
//                        .filters(f -> f.rewritePath("/promerica/", "/v2/api/")
//                                .addRequestHeader("X-GATEWAY-REQUEST-HEADER", "GATEWAY-SOLITUD")
//                                .addResponseHeader("X-GATEYWAY-RESPONSE-HEADER", "GATEWAY_RESPONSE"))
//                        .uri(clientesUri)
//                )
//                .build();
//    }
//
//    @Bean
//    public RouteLocator rutasDeCuentas(RouteLocatorBuilder builder) {
//        //Colocar todas las rutas del api de cuentas
//        return builder.routes()
//                .route("cuentas", r -> r.path("/api/v2/pokemon/ditto")
//                        .filters(f -> f.addRequestHeader("X-GATEWAY-REQUEST-HEADER", "API-CUENTAS-SOLITUD")
//                                .addResponseHeader("X-GATEYWAY-RESPONSE-HEADER", "API-CUENTAS_RESPONSE"))
//                        .uri(cuentasUri)
//                )
//                .build();
//    }

    @Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getAddress().getHostAddress());
    }
}
