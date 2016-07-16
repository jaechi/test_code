package com.company;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by Jae on 7/6/2016.
 */
public class Modifier implements Runnable {


    private HashMap<String, Echo> echos;
    private int counter = 0;
    private int sleepDur = 1000;

    public Modifier(HashMap<String, Echo>  map) {
        echos = map;
    }


    @Override
    public void run() {
        while (true) {
            add();

            try {
                Thread.sleep(sleepDur);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            add();
            remove();
        }
    }


    private void add() {
        String tag = "Echo" + counter++;
        Echo echo = new Echo(tag);
        echos.put(tag, echo);
    }

    private void remove() {
        String key = "Echo" + randome();
        if (echos.containsKey(key)) {
            echos.remove(key);
        }
    }

    private int randome() {
        return 1 + (int)(Math.random() * ((counter - 1) + 1));
    }
}
