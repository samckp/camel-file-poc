package com.sam.camel.poc.strategy;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.stereotype.Component;

@Component
public class AggregationSimpleStrategy implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        if (oldExchange == null) {
            return newExchange;

        } else {
            String oldData = (String) oldExchange.getIn().getBody();
            String newData = (String) newExchange.getIn().getBody();

            newData = oldData.concat(newData);
            newExchange.getIn().setBody(newData);
            return newExchange;
        }
    }
}