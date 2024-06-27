package ma.mak.tryyyy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Homepage controller.
 */
@RestController
public class IndexController {

    @GetMapping("/")
    String index() {
        return "index";
    }

}
