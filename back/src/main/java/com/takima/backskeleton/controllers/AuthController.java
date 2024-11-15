package com.takima.backskeleton.controllers;

import com.takima.backskeleton.services.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class LoginController {
    @RestController
    @RequestMapping("/auth")
    public class AuthController {

        @Autowired
        private AuthenticationService authenticationService;

        @PostMapping("/login")
        public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
            boolean authenticated = authenticationService.authenticate(username, password);

            if (authenticated) {
                return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        }
        @RequestMapping("/login")
        public String login(HttpServletRequest request, String username, String password) {
            if (authenticationService.authenticate(username, password)) {
                request.getSession().setAttribute("user", username);
                return "redirect:/dashboard";  // Redirect to a secured page
            }
            return "login";  // Return to login page on failure
        }

    }

}