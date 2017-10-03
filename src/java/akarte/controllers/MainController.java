
package akarte.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    
    // cela svrha je da posalje na pocetnu, ali otavicu ga XD
    
    @RequestMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

}
