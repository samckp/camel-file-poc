package com.sam.camel.poc.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileNameBasedRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("{{fromFileRoute}}")
                .routeId("fileNameBasedRouting")
                .log(LoggingLevel.INFO, "${header.CamelFileName}")
                .choice()
                    .when(header("CamelFileName").startsWith("Cli"))
                        .to("{{toCliFileRoute}}")
                    .when(header("CamelFileName").startsWith("D"))
                        .to("{{toDFileRoute}}")
                    .when(header("CamelFileName").startsWith("C"))
                        .to("{{toCFileRoute}}")
                    .otherwise()
                        .to("log:test?level=INFO")
                .end();
    }
}
