package com.loop.test.day9_driver_faker_actions;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class T2_java_faker {

    @Test
    public void java_faker(){
        Faker faker = new Faker();

        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.numerify(\"202-###-####\") = " + faker.numerify("###-###-####"));

        System.out.println("faker.letterify(\"????\") = " + faker.letterify("????"));
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard().replace("-",""));
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.bothify() = " + faker.bothify("###??"));
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());
    }
}
