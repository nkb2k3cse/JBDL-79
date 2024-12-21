package com.gfg;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
//        CheckEven checkEven = new CheckEven();

        Predicate<Integer> checkEven = (x) -> x%2 == 0;
        System.out.println(checkEven.test(34));
        System.out.println(checkEven.test(33));

        Predicate<Person> voterElegibility = (x) -> x.getAge() >= 18;
        Person person1 = new Person("Ravi",34);
        Person person2 = new Person("Ajay",34);
        System.out.println(voterElegibility.test(person1));

        Predicate<Person> startWithA = (x) -> x.getName().startsWith("A");
        Predicate<Person> elegibleToVoteAndStartWithA = voterElegibility.and(startWithA);

        System.out.println(elegibleToVoteAndStartWithA.test(person2));

        Predicate<Person> isMinor = voterElegibility.negate();
        System.out.println(isMinor.test(new Person(9)));

        if(elegibleToVoteAndStartWithA.test(person1)){
            System.out.println("Correct");
        }
    }
}

//class CheckEven implements Predicate<Integer>{
//
//    @Override
//    public boolean test(Integer integer) {
//        return integer%2 == 0;
//    }
//}

//class VoterElegibility implements Predicate<Person>{
//
//    @Override
//    public boolean test(Person person) {
//        return person.getAge() >= 18;
//    }
//}

