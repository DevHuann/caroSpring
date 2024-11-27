package com.vcoderlog.lab01.controller;

import com.vcoderlog.lab01.config.JwtTokenProvider;
import com.vcoderlog.lab01.reponsitory.models.CustomUserDetails;
import com.vcoderlog.lab01.reponsitory.models.User;
import com.vcoderlog.lab01.reponsitory.models.request.user.CreateUserRequest;
import com.vcoderlog.lab01.reponsitory.models.request.LoginRequest;
import com.vcoderlog.lab01.reponsitory.models.request.user.EditUserRequest;
import com.vcoderlog.lab01.reponsitory.models.response.LoginResponse;
import com.vcoderlog.lab01.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

//        @PreAuthorize("hasAuthority('User.Write')")
    @PostMapping("/registration")
    public Boolean createUser(@Valid @RequestBody CreateUserRequest request) throws Exception {
        return userService.createUser(request);
    }

    @PreAuthorize("hasAuthority('user.delete')")
    @DeleteMapping("/DeleteUser/{userId}")
    Boolean delUser(@PathVariable long userId) {
        return userService.delUser(userId);
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/getListUser")
    public List<User> getListUser() {
        return   userService.getListUser();
    }

    @PreAuthorize("hasAuthority('user')")
    @PutMapping("/editUser")
    public User editUser(@RequestBody EditUserRequest request){return userService.editUser(request);}

    @GetMapping("/GetUserById/{userId}")
    public User getUserById(@PathVariable long userId){
        var UserOptional=userService.getUserById(userId);
        if (UserOptional.isPresent()){
            return UserOptional.get();
        }
        return null;
    }
}


