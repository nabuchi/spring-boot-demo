package net.nabnet.demo.controller;

import net.nabnet.demo.model.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by nabuchi on 2016/06/15.
 */
@RunWith(SpringRunner.class)
@JsonTest
public class MessageJsonTest {
    private JacksonTester<Message> messageTester;

    @Test
    public void serializeJson() throws Exception {
        Message message = new Message("hello");
        assertThat(messageTester.write(message)).extractingJsonPathValue("@.value").isEqualTo("hello");
    }
}
