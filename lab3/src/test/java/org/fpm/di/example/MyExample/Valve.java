package org.fpm.di.example.MyExample;


public class Valve extends Developers {
    private final Dota2 dt;

    public Valve(Dota2 dt) {
        this.dt = dt;
    }

    public Dota2 getDota(){
        return dt;
    }
}
