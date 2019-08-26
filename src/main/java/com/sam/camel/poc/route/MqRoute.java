package com.sam.camel.poc.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MqRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("{{toRoute}}")
                .routeId("mqRoute")
                .log(LoggingLevel.INFO, "${body}")
                .to("{{writeToQueue}}")
                ;
    }
}
