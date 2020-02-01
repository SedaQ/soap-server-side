package org.sedaq.soap.repository;


import com.sedaq.ws.GetPersonByIdResponse;
import com.sedaq.ws.PersonById;
import org.springframework.stereotype.Repository;

import javax.xml.datatype.XMLGregorianCalendar;

@Repository
public class PersonRepository {

    public GetPersonByIdResponse getPersonByIdResponse(Long id) {
        GetPersonByIdResponse personByIdResponse = new GetPersonByIdResponse();
        personByIdResponse.setPersonById(mockedPerson(id));
        return personByIdResponse;
    }

    private PersonById mockedPerson(Long id) {
        PersonById personById = new PersonById();
        personById.setId(id);
        personById.setName("Pavel Seda");
        personById.setEmail("pavelseda@email.cz");
        personById.setBirthday(null);
        return personById;
    }
}
