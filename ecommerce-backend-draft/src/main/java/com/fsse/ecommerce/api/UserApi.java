package com.fsse.ecommerce.api;

import com.fsse.ecommerce.domain.User;
import com.fsse.ecommerce.domain.dto.response.user.UserDetailsResponseDto;
import com.fsse.ecommerce.util.SecurityUtil;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserApi {
    @GetMapping("/me/details")
    public UserDetailsResponseDto getMyUserDetails(Principal principal) {
        User user = SecurityUtil.getUser(principal);
        if (user != null) {
            return new UserDetailsResponseDto(user);
        }

        return null;
    }
}