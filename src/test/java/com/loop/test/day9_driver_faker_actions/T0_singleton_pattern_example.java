package com.loop.test.day9_driver_faker_actions;

public class T0_singleton_pattern_example {
    //private constructor to prevent external instantiation

    private T0_singleton_pattern_example() {
    }

    private static String word;

    public static String getWord() {

        if(word==null){
            System.out.println("First time calling, Object is null and assigning now");
            word = "driver";
        } else {
            System.out.println("word is already assigned and has value");
        }
        return word;
    }
}
