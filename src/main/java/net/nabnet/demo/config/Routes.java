package net.nabnet.demo.config;

import lombok.Getter;

/**
 * Created by nabuchi on 2016/06/14.
 */
public class Routes {
    public static class Hello {
        public static final String contextPath = "/hello";
        public static final String index = contextPath + "/message";
    }

    public static class HelloApi {
        public static final String contextPath = "/api/hello";
        public static final String index = contextPath + "/message";
    }
}
