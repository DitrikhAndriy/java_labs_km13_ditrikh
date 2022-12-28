package org.fpm.di.example.MyExample;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FromSoftware extends Developers{
    private final EldenRing er;
    private final DarkSoulsSeries dss;

    @Inject
    public FromSoftware(EldenRing er, DarkSoulsSeries dss) {
        this.er = er;
        this.dss = dss;
    }

    public EldenRing getEldenRing(){
        return er;
    }
    public DarkSoulsSeries getDarkSoulsSeries(){
        return dss;
    }
}
