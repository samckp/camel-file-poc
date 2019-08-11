package com.sam.camel.poc.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.zipfile.ZipSplitter;
import org.springframework.stereotype.Component;

@Component
public class UnzipRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("{{fromZipRoute}}")
                .log(LoggingLevel.INFO, "${body}")
                .split(new ZipSplitter())
                .streaming()
                .convertBodyTo(String.class)
                .to("{{toZipRoute}}")
                ;
    }
}
