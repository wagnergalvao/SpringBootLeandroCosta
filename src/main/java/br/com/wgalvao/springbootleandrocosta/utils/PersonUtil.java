package br.com.wgalvao.springbootleandrocosta.utils;

import java.util.Locale;

import com.github.javafaker.Faker;

import br.com.wgalvao.springbootleandrocosta.model.Person;

public class PersonUtil {

    private static final Faker faker = Faker.instance(Locale.getDefault());

    public static Person createFakePerson() {
        Person fakePerson = new Person();
        fakePerson.setId(faker.random().nextLong());
        fakePerson.setFirstName(faker.name().firstName());
        fakePerson.setLastName(faker.name().lastName());
        fakePerson.setAdress(
                faker.address().fullAddress());
        fakePerson.setGender(faker.demographic().sex());
        return fakePerson;
    }

}
