package net.nabnet.demo.controller;

import lombok.AllArgsConstructor;
import net.nabnet.demo.config.Routes;
import net.nabnet.demo.model.Message;
import net.nabnet.demo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by nabuchi on 2016/06/15.
 */
@RestController
@AllArgsConstructor
public class HelloApiController {
    private final HelloService helloService;

    @GetMapping(Routes.HelloApi.index)
    public Message index() {
        String message = helloService.message();
        return new Message(message);
    }
}
