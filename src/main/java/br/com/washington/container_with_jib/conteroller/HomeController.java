package br.com.washington.container_with_jib.conteroller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

@RefreshScope
@RestController
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Value("${value:default}")
    private String value;

    private String att;

    @PostConstruct
    protected void init(){
        log.info(value);
//        Path path = Path.of("/app/resources/secrets/value");
//        if(path.toAbsolutePath().toFile().exists()) {
//            File file = new File(path.toAbsolutePath().toUri());
//            try (Scanner scanner = new Scanner(file)) {
//                att = scanner.nextLine();
//                log.info("Value: {}", att);
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }
//        }

    }

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
