package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person("Jose",1010,25, Gender.MALE, true );

        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void shouldUnderAdAge() {
        Person person = new Person();
        person.setAge(13);
        RegisterResult result = registry.underAge(person);
            Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
    @Test
    public void invalidAge() {
        Person person = new Person();
        person.setAge(-1);
        RegisterResult result = registry.invalidAge(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
    @Test
    public void isDeadPerson() {
        Person person = new Person();
        person.setAlive(false);
        RegisterResult result = registry.deadPerson(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
    @Test
    public void shouldDuplicatePerson() {
        Person person = new Person("Jose",1010,25, Gender.MALE, true );
        Person person2 = new Person("Maria",1010,20, Gender.FEMALE, true );
        RegisterResult result = registry.registerVoter(person);
        RegisterResult result2 = registry.duplicatedPerson(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }


}