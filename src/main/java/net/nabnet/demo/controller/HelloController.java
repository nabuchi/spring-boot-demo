package net.nabnet.demo.controller;

import lombok.AllArgsConstructor;
import net.nabnet.demo.config.Routes;
import net.nabnet.demo.model.Message;
import net.nabnet.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by nabuchi on 2016/06/14.
 */
@RestController
@AllArgsConstructor
public class HelloController {
    private final HelloService helloService;

    @GetMapping(Routes.Hello.index)
    public String index() {
        return helloService.message();
    }

}
