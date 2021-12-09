package com.github.fabriciolfj.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.convert.format.MapFormat;

import java.util.Map;

//@ConfigurationProperties("identity-store")
public class IdentityStore {

    @MapFormat
    Map<String, String> users;
    @MapFormat
    Map<String, String> roles;

    public String getUserPassword(final String user) {
        return users.get(user);
    }

    public String getUserRole(final String user) {
        return roles.get(user);
    }
}
