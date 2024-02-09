package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {

    private ArrayList<Person> persons = new ArrayList<>();
    public RegisterResult registerVoter(Person p) {

       if ( invalidAge(p) == RegisterResult.VALID && underAge(p) == RegisterResult.VALID && deadPerson(p) == RegisterResult.VALID && duplicatedPerson(p) == RegisterResult.VALID){
           persons.add(p);
           return RegisterResult.VALID;

       }
       return RegisterResult.INVALID_AGE;
    }

    public RegisterResult invalidAge(Person p) {
        if(p.getAge()<0){
            return RegisterResult.INVALID_AGE;
        }
        return RegisterResult.VALID;
    }

    public RegisterResult underAge(Person p){
        if(p.getAge() < 18){
            return RegisterResult.UNDERAGE;
        }
        return RegisterResult.VALID;
    }

    public RegisterResult deadPerson(Person p){
        if(!p.isAlive()){
            return RegisterResult.DEAD;
        }
        return RegisterResult.VALID;
    }

    public RegisterResult duplicatedPerson(Person p){
        for (Person person: persons){
            if (person.getId() == p.getId()){
                return RegisterResult.DUPLICATED;
            }

        }
        return RegisterResult.VALID;
    }
}
