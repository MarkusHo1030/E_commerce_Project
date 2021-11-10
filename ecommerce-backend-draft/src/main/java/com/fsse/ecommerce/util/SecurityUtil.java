package com.fsse.ecommerce.util;

import com.fsse.ecommerce.domain.User;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.security.Principal;

public class SecurityUtil {
    public static User getUser(Principal principal) {
        if (principal instanceof PreAuthenticatedAuthenticationToken) {
            PreAuthenticatedAuthenticationToken preAuthenticated = (PreAuthenticatedAuthenticationToken) principal;
            if (preAuthenticated.getPrincipal() instanceof User) {
                return (User) preAuthenticated.getPrincipal();
            }
        }
        return null;
    }
}
