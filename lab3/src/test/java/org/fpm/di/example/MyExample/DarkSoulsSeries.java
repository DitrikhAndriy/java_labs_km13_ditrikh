package org.fpm.di.example.MyExample;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DarkSoulsSeries extends Series{
    private final DarkSouls ds1;
    private final DarkSouls2 ds2;
    private final DarkSouls3 ds3;

    @Inject
    public DarkSoulsSeries(DarkSouls ds1, DarkSouls2 ds2, DarkSouls3 ds3) {
        this.ds1 = ds1;
        this.ds2 = ds2;
        this.ds3 = ds3;
    }

    public DarkSouls getDarkSouls(){
        return ds1;
    }

    public DarkSouls2 getDarkSouls2(){
        return ds2;
    }

    public DarkSouls3 getDarkSouls3(){
        return ds3;
    }
}
