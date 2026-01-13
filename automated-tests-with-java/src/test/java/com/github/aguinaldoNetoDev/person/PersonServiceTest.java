package com.github.aguinaldoNetoDev.person;

import com.github.aguinaldoNetoDev.person.model.Person;
import com.github.aguinaldoNetoDev.person.services.IPersonService;
import com.github.aguinaldoNetoDev.person.services.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    Person person;
    IPersonService personService;

    @BeforeEach
    void setup() {
        personService = new PersonService();

        person = new Person(
                "Keith",
                "Moon",
                "kmoon@batata.com",
                "Wembley - UK",
                "Male"
        );
    }

    @DisplayName("When create a Person with success should return a Person object.")
    @Test
    void testCreatePerson_whenSuccess_shouldReturnPersonObject() {
        //When / Act
        Person result = personService.createPerson(person);

        //Then / Assert
        assertNotNull(result, "The createPerson() should not have returned null!");
    }

    @DisplayName("When create a Person with success should contains valid fields in returned a Person object.")
    @Test
    void testCreatePerson_whenSuccess_shouldContainsValidFieldsInReturnedPersonObject() {
        //When / Act
        Person result = personService.createPerson(person);

        //Then / Assert
        assertNotNull(person.getId(), "The id is null!");
        assertEquals(person.getFirstName(), result.getFirstName(), "The FirstName is diferent!");
        assertEquals(person.getLastName(), result.getLastName(), "The lastName is diferent!");
        assertEquals(person.getAddress(), result.getAddress(), "The address is diferent!");
        assertEquals(person.getGender(), result.getGender(), "The gender is diferent!");
        assertEquals(person.getEmail(), result.getEmail(), "The email is diferent!");
    }

    @DisplayName("When create a Person with null email should throw an Illegal Argument Exception.")
    @Test
    void testCreatePerson_withNullEmail_shouldThrowIllegalArgumentException() {
        person.setEmail(null);

        String expectedMessage = "The person e-mail is null or empty";

        //When / Act

        IllegalArgumentException result = assertThrows(IllegalArgumentException.class, () ->
                personService.createPerson(person),
                "Empty e-mail should have cause an IllegalArgumentException");

        //Then / Assert
        assertEquals(expectedMessage, result.getMessage(), "Exception error message is incorrect");
    }
}
