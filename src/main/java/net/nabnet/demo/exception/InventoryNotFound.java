package net.nabnet.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by nabuchi on 2016/06/14.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InventoryNotFound extends RuntimeException {
}
