package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jae on 7/6/2016.
 */
public class Caller implements Runnable {

    private int sleepDur = 500;
    private HashMap<String, Echo> echos;


    public Caller(HashMap<String, Echo> map) {
        echos = map;
    }

    public void run() {

        while (true) {
            try {
                System.out.println("run");
                for (Echo echo : echos.values()) {
                    echo.echo();
                    waitFor(sleepDur);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private void waitFor(int milli) {
        try {
            Thread.sleep(sleepDur);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
