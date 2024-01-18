package securitySix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/home/")
@RestController
public class HomeWeb {

    @GetMapping("public")
    public String publicRoute() {
        return "Bem vindo ao meu Spring Security Six";
    }



}
