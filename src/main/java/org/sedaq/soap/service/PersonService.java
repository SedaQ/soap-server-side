package org.sedaq.soap.service;

import com.sedaq.ws.GetPersonByIdResponse;
import org.sedaq.soap.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public GetPersonByIdResponse getPersonByIdResponse(Long personId) {
        return personRepository.getPersonByIdResponse(personId);
    }

}
