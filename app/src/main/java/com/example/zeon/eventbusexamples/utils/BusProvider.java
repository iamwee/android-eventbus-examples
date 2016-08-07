package com.example.zeon.eventbusexamples.utils;

import com.squareup.otto.Bus;

/**
 * Created by Zeon on 8/8/2559.
 */

public class BusProvider {


    private static Bus instance;

    public static Bus getInstance(){
        if(instance == null) instance = new Bus();
        return instance;
    }

}
