package com.renato.shoppingcart.controlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class DemoController {

    @GetMapping("demo")
    public ResponseEntity<String> register() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("admin/hello")
    public ResponseEntity<String> registeter() {
        return ResponseEntity.ok("Hello sysadmin");
    }
}
