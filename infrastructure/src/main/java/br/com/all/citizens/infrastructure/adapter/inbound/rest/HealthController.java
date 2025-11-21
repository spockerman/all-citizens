package br.com.all.citizens.infrastructure.adapter.inbound.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/ping")
    public String ping() {
        System.out.println(">>> CHEGOU NO /health/ping");
        return "ok";
    }

}
