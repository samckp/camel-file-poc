package com.sam.camel.poc.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class UnzipRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("")
                .log(LoggingLevel.INFO, "${body}")
                .to("")
                ;
    }
}
