package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class Main {



    public static void main(String[] args) {
	// write your code here

        HashMap<String, Echo> echos = new HashMap<>();
        Caller caller = new Caller(echos);

        Thread callerThread = new Thread(caller);
        callerThread.start();

        Modifier modifier = new Modifier(echos);
        Thread modifierThread = new Thread(modifier);
        modifierThread.start();

        try {
            callerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
