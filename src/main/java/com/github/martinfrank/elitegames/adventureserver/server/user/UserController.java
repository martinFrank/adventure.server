package com.github.martinfrank.elitegames.adventureserver.server.user;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {


    //dieser endpoint ist nun für registrierte user erreichbar

    @GetMapping("/me")
    public UserEntity getMe(@AuthenticationPrincipal UserEntity user) {
        return user;
    }
}
