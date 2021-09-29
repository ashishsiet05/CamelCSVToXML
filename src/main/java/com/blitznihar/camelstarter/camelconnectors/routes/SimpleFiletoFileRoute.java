package com.blitznihar.camelstarter.camelconnectors.routes;

import java.util.UUID;

import com.blitznihar.camelstarter.camelconnectors.entities.RestaurantModel;
import com.blitznihar.camelstarter.camelconnectors.entities.RestaurantModelXml;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jacksonxml.JacksonXMLDataFormat;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;
import org.apache.camel.spi.DataFormat;

@Component
public class SimpleFiletoFileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        DataFormat bindy = new BindyCsvDataFormat(RestaurantModel.class);
        
        JacksonXMLDataFormat jaxb = new JacksonXMLDataFormat(RestaurantModelXml.class);

        from("{{startRoute}}")
            .log("Timer invoked and the bodys ${body}")
            .pollEnrich("{{fromRoute}}")
            .log("Timer invoked and the bodys ${body}")
            .unmarshal(bindy)
            .split(body())
                .multicast()
                .to("direct:xml","direct:json");


                from("direct:xml").log("${body}").marshal(jaxb).log("${body}")
                .process(exchange -> {
                    exchange.getIn().setHeader(Exchange.FILE_NAME, UUID.randomUUID().toString()+".xml");
                })
                .to("{{toRoute}}").end();


                from("direct:json").log("${body}").marshal().json(JsonLibrary.Jackson).log("${body}")
                .process(exchange -> {
                    exchange.getIn().setHeader(Exchange.FILE_NAME, UUID.randomUUID().toString()+".json");
                })
                //.process(new RestaurantProcessor())
                .to("{{toRoute}}").end();


    }
   
}