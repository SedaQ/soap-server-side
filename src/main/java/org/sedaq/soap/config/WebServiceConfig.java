package org.sedaq.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 * <ul>
 * <li>@EnableWs - Enable SOAP Web Service features in this Spring Boot application.</li>
 * <li>@Configuration - This class contains Spring configuration.</li>
 * <li>@Bean public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) -- We would want to create message dispatcher servlet to act as a front controller. return new ServletRegistrationBean(messageDispatcherServlet, "/sedaq-ws/*") - Configure the URL to the web services.</li>
 * </ul>
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    /**
     * DefaultWsdl11Definition exposes a standard WSDL 1.1 using XsdSchema.
     * The bean name studentDetailsWsdl will be the wsdl name that will be exposed.
     * It will be available under http://localhost:8080/sedaq-ws/Persons.wsdl.
     * This is the simplest approach to expose the contract first wsdl in spring.
     *
     * @param personsSchema
     * @return
     */
    @Bean(name = "Persons") // A spring bean. The name of the bean is the name of the wsdl in the URL.
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema personsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("PersonsPort");
        // URL of the WSDL - http://localhost:8080/sedaq-ws/personsWsdl.wsdl
        wsdl11Definition.setLocationUri("/ws"); // The url where we want to expose the wsdl at.
        wsdl11Definition.setTargetNamespace("http://sedaq.com/ws"); // Default name space
        wsdl11Definition.setSchema(personsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema personsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("/xsd/persons.xsd")); //We would create WSDL based on the xsd defined here -
    }
}
