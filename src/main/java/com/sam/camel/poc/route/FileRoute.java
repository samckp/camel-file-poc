package com.sam.camel.poc.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("{{fromRoute}}")
//            .log("${body}")
            .log("${headers}")
            .to("{{toRoute}}")
        ;
    }
}
