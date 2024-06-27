package com.demo.nonstatic.utils;

import java.util.Random;

public class TestUtils {
    
    public static int randomIntBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt(max-min+1) + min;
    }

    public static int randomIntBetween() {
        return randomIntBetween(4,6);
    }

    public static void hardWait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Sleep interrupted");
        }
    }

    public static void hardWait() {
        hardWait(500);
    }

}
