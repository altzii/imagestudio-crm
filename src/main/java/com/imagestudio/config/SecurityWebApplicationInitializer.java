package com.imagestudio.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by alt on 10.04.17.
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityWebApplicationInitializer() {
        super(SecurityConfig.class);
    }
}
