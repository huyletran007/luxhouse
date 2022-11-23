package com.luxhouse.main.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luxhouse.main.domain.Roles;
import com.luxhouse.main.domain.Users;
import com.luxhouse.main.model.LoginDTO;
import com.luxhouse.main.model.SignUpDTO;
import com.luxhouse.main.repository.RoleRepository;
import com.luxhouse.main.repository.UserRepository;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public Map<String, String> authenticateUser(@RequestBody LoginDTO loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Map<String, String> map = new HashMap<>();
        map.put("success", "User signed-in successfully!");
        return map;
        // {"data":""}
    }

    @PostMapping("/signup")
    public Map<String, String> registerUser(@RequestBody SignUpDTO signUpDto) {

        // add check for username exists in a DB
        if (userRepository.existsByUsername(signUpDto.getUsername())) {
//            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
            Map<String, String> map = new HashMap<>();
            map.put("error", "Username đã tồn tại!.");
            return map;
        }

        // add check for email exists in DB
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
//            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
            Map<String, String> map = new HashMap<>();
            map.put("error", "Email đã tồn tại!.");
            return map;
        }
        
     // add check for phone exists in DB
        if (userRepository.existsByPhone(signUpDto.getPhone())) {
//            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
            Map<String, String> map = new HashMap<>();
            map.put("error", "Số điện thoại đã tồn tại!.");
            return map;
        }

        // create user object
        Users user = new Users();
        user.setFullname(signUpDto.getFullname());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPhone(signUpDto.getPhone());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Roles roles = roleRepository.findByName("Users").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

//        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
        Map<String, String> map = new HashMap<>();
        map.put("success", "User signed-in successfully!");
        return map;

    }
}
