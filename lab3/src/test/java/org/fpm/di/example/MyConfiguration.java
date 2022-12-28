package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;
import org.fpm.di.example.MyExample.*;

public class MyConfiguration implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());




        binder.bind(Games.class);
        binder.bind(DarkSouls.class);
        binder.bind(DarkSoulsSeries.class);

        binder.bind(Dota2.class, new Dota2());
        binder.bind(Developers.class, FromSoftware.class);
    }
}
