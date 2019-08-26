package com.sam.camel.poc.route;

import com.sam.camel.poc.strategy.AggregationSimpleStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.stereotype.Component;

@Component
public class FileMergeRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:src/main/resources/inbox")
                .log(LoggingLevel.INFO, "Message Received : ${body} and key{header.aggregatorId}")
                .aggregate(new AggregationSimpleStrategy())
;
//                .completionSize(3)
//                .ignoreInvalidCorrelationKeys()
//                .log(LoggingLevel.INFO, "Aggregate Message : ${body} and key{header.aggregatorId}")
//
 //               .to("file:src/main/resources/outbox")
   //             ;

    }
}
