package com.blitznihar.camelstarter.camelconnectors.routes;

import com.blitznihar.camelstarter.camelconnectors.entities.RestaurantModel;
import com.blitznihar.camelstarter.camelconnectors.processors.RestaurantProcessor;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.springframework.stereotype.Component;
import org.apache.camel.spi.DataFormat;

@Component
public class SimpleFiletoFileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        DataFormat bindy = new BindyCsvDataFormat(RestaurantModel.class);

        from("{{startRoute}}")
            .log("Timer invoked and the bodys ${body}")
            .pollEnrich("{{fromRoute}}")
            .log("Timer invoked and the bodys ${body}")
            .unmarshal(bindy)
            .split(body())
                .log("${body}")
                .process(new RestaurantProcessor())
                .to("{{toRoute}}").end();
    }
    
}
