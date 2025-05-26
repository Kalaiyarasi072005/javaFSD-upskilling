package com.greetings;

import com.utils.QuantumUtil;

public class Main {
    public static void main(String[] args) {
        String greeting = QuantumUtil.createGreeting("Alice");
        System.out.println(greeting);
        System.out.println("Module: " + Main.class.getModule().getName());
    }
}