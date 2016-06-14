package net.nabnet.demo.controller;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import net.nabnet.demo.config.Routes;
import net.nabnet.demo.model.Message;
import net.nabnet.demo.service.HelloService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by nabuchi on 2016/06/14.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloController.class, secure = false)
public class HelloControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private WebClient webClient;
    @Autowired
    private WebDriver webDriver;

    @MockBean
    HelloService helloService;


    private final String MESSAGE="hello";
    @Before
    public void before() {
        when(helloService.message())
                .thenReturn(MESSAGE);
    }

    @Test
    public void index_mvc() throws Exception {
        mvc.perform(get(Routes.Hello.index))
                .andExpect(status().isOk())
                .andExpect(content().string(MESSAGE)
                );
    }

    @Test
    public void index_webClient() throws Exception {
        HtmlPage htmlPage = webClient.getPage(Routes.Hello.index);
        assertThat(htmlPage.asText(), is(MESSAGE));
    }

    @Test
    public void index_webDriver() throws Exception {
        webDriver.get(Routes.Hello.index);
        assertThat(webDriver.getPageSource(), containsString(MESSAGE));
        webDriver.quit();
    }
}