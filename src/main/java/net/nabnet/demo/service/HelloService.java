package net.nabnet.demo.service;

import org.springframework.stereotype.Service;

/**
 * Created by nabuchi on 2016/06/14.
 */
@Service
public class HelloService {
    public String message() {
        return "Hello World!";
    }
}
