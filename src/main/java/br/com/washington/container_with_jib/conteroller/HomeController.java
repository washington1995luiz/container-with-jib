package br.com.washington.container_with_jib.conteroller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Value("${value:default}")
    private String value;

    @CircuitBreaker(name = "Test", fallbackMethod = "fallbackCircuitBreak")
    @GetMapping("/test")
    public String test(){
        if(true) throw new RuntimeException();
        return "a";
    }

    @GetMapping
    public String home(){
        return value;
    }

    private String fallbackCircuitBreak(RuntimeException e){
        log.error("Error");
        return "Error ";
    }
}
