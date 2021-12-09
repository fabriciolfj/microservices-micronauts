package com.github.fabriciolfj.configuration;

import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

//@Singleton
public class LocalAuthProvider implements AuthenticationProvider {

    //@Inject
    IdentityStore identityStore;

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        final String username = authenticationRequest.getIdentity().toString();
        final String password = authenticationRequest.getSecret().toString();

        if (password.equals(identityStore.getUserPassword(username))) {
            return Flux.just(AuthenticationResponse.success(username, Collections.singleton(identityStore.getUserRole(username))));
        }

        return Flux.just(new AuthenticationFailed());
    }
}
