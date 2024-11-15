package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Users;
import com.takima.backskeleton.services.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

        @Autowired
        private AuthenticationService authenticationService;

        @PostMapping("/login")
        public ResponseEntity<Users> login(@RequestParam String email, @RequestParam String password) {
            Users authenticatedUser = authenticationService.authenticate(email, password);

            if (authenticatedUser != null) {
                System.out.println("Login successful");
                return ResponseEntity.ok(authenticatedUser);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        }
        @RequestMapping("/login")
        public String login(HttpServletRequest request, String email, String password) {
            Users authenticatedUser = authenticationService.authenticate(email, password);
            if (authenticatedUser != null) {
                request.getSession().setAttribute("email", email);
                return "redirect:/";  // Redirect to a secured page
            }
            return "login";  // Return to login page on failure
        }

    }

