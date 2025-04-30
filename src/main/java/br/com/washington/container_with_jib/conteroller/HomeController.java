package br.com.washington.container_with_jib.conteroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public String home(){
        return "Last update: 04/30/2025";
    }
}
