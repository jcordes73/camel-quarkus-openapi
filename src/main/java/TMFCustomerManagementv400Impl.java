import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public final class TMFCustomerManagementv400Impl extends RouteBuilder {
    
    public void configure() {

		restConfiguration();

        from("direct:listCustomer").log(LoggingLevel.DEBUG, "listCustomer");

        from("direct:createCustomer").log(LoggingLevel.DEBUG, "createCustomer");

        from("direct:retrieveCustomer").log(LoggingLevel.DEBUG, "retrieveCustomer").transform().simple("{\"customer\":{\"id\":\"${header.id}\"}}");
                
        from("direct:deleteCustomer").log(LoggingLevel.DEBUG, "deleteCustomer");
                
        from("direct:patchCustomer").log(LoggingLevel.DEBUG, "patchCustomer");

        from("direct:registerListener").log(LoggingLevel.DEBUG, "registerListener");

        from("direct:unregisterListener").log(LoggingLevel.DEBUG, "unregisterListener");

        from("direct:listenToCustomerCreateEvent").log(LoggingLevel.DEBUG, "listenToCustomerCreateEvent");

        from("direct:listenToCustomerAttributeValueChangeEvent").log(LoggingLevel.DEBUG, "listenToCustomerAttributeValueChangeEvent");

        from("direct:listenToCustomerStateChangeEvent").log(LoggingLevel.DEBUG, "listenToCustomerStateChangeEvent");

        from("direct:listenToCustomerDeleteEvent").log(LoggingLevel.DEBUG, "listenToCustomerDeleteEvent");

    }
}
