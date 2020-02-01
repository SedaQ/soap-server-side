package org.sedaq.soap.endpoints;

import com.sedaq.ws.GetPersonByIdRequest;
import com.sedaq.ws.GetPersonByIdResponse;
import org.sedaq.soap.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * <ul>
 * <li> @Endpoint -- Annotation to indicate that this is a Web Service Endpoint </li>
 * <li> @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonByIdRequest") -- Defines the details of the request that this method would handle. We will handle GetPersonByIdRequest with the given namespace </li>
 * <li> @ResponsePayload -- This method will return a response which would need to be converted to a response xml.</li>
 * <li> public getPersonById processCourseDetailsRequest(@RequestPayload GetStudentDetailsRequest request)-- Method would handle the request. @RequestPayload indicates that this is got from the request.</li>
 * </ul>
 */
@Endpoint
public class PersonEndpoint {

    private static final String NAMESPACE_URI = "http://sedaq.com/ws";

    private PersonService personService;

    @Autowired
    public PersonEndpoint(PersonService personService) {
        this.personService = personService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetPersonByIdRequest")
    @ResponsePayload
    public GetPersonByIdResponse getPersonById(@RequestPayload GetPersonByIdRequest request) {
        return personService.getPersonByIdResponse(request.getId());
    }

}
