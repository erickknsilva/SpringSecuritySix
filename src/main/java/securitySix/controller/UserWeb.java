package securitySix.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import securitySix.dto.UserRequest;
import securitySix.dto.UserResponse;
import securitySix.service.UserService;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserWeb {

    private final UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createdUser(@Valid @RequestBody UserRequest request) {
        return userService.createdUser(request);
    }


}
