package com.blitznihar.camelstarter.camelconnectors.processors;

import java.util.UUID;

import com.blitznihar.camelstarter.camelconnectors.entities.RestaurantModel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class RestaurantProcessor implements Processor{

    @Override
    public void process(Exchange exchange) throws Exception {
        RestaurantModel restaurantmodel = (RestaurantModel)exchange.getIn().getBody();
        exchange.getIn().setBody(restaurantmodel.toString());
        exchange.getIn().setHeader("CamelFileName", restaurantmodel.getName()+UUID.randomUUID().toString());
    }

}
