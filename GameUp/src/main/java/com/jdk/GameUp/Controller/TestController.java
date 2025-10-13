package com.jdk.GameUp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

        @GetMapping("/")
        public String home() {
            return "Pagina pubblica, accessibile da tutti";
        }

        @GetMapping("/user/dashboard")
        public String userDashboard() {
            return "Dashboard utente - accessibile solo se loggato";
        }

        @GetMapping("/admin/dashboard")
        public String adminDashboard() {
            return "Dashboard admin - accessibile solo agli admin";
        }
    }
