package uk.co.lewisvince.camelexample.routes;

import org.apache.camel.Exchange;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MainRoute extends SpringRouteBuilder {
    @Override
    public void configure() throws Exception {

        restConfiguration().component("servlet");


        rest()
                .get("test")
                .to("{{routes.test}}")

                .post("test")
                .to("{{routes.test}}")

                .put("test")
                .to("{{routes.test}}")

                .patch("test")
                .to("{{routes.test}}")

                .delete("test")
                .to("{{routes.test}}");

        from("{{routes.test}}").id("{{routes.test.id}}")
                .process(exchange -> {
                    exchange.getIn().setBody(exchange.getIn().getHeader(Exchange.HTTP_METHOD));
                });
    }
}
