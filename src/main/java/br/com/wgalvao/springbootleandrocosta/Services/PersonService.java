package br.com.wgalvao.springbootleandrocosta.Services;

import static br.com.wgalvao.springbootleandrocosta.utils.PersonUtil.createFakePerson;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.wgalvao.springbootleandrocosta.model.Person;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {

        logger.info("finding one person!");

        Person person = createFakePerson();
        person.setId(counter.incrementAndGet());

        return person;
    }
}
