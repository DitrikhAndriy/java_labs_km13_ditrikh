package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;

import org.fpm.di.example.MyExample.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }





    @Test
    public void Test1() {
        DarkSouls ds = container.getComponent(DarkSouls.class);
        DarkSoulsSeries series = container.getComponent(DarkSoulsSeries.class);
        assertSame(ds, series.getDarkSouls());
    }

    @Test
    public void Test2() {
        DarkSouls ds = container.getComponent(DarkSouls.class);
        FromSoftware fs = container.getComponent(FromSoftware.class);
        assertSame(ds, fs.getDarkSoulsSeries().getDarkSouls());
    }

    @Test
    public void Test3() {
        EldenRing ring1 = container.getComponent(EldenRing.class);
        EldenRing ring2 = container.getComponent(EldenRing.class);
        assertSame(ring1, ring2);
        Games game1 = container.getComponent(Games.class);
        Games game2 = container.getComponent(Games.class);
        assertNotSame(game1, game2);
    }

    @Test
    public void Test4() {
        Dota2 dota = container.getComponent(Dota2.class);
        assertSame(container.getComponent(Dota2.class), dota);
    }

    @Test
    public void Test5() {
        Developers devs = container.getComponent(Developers.class);
        FromSoftware software = container.getComponent(FromSoftware.class);
        assertSame(devs, software);
    }

    @Test
    public void Test6() {
        DarkSoulsSeries dss = container.getComponent(DarkSoulsSeries.class);
        assertSame(dss.getDarkSouls2(), container.getComponent(DarkSouls2.class));
        assertSame(dss.getDarkSouls3(), container.getComponent(DarkSouls3.class));
        assertSame(container.getComponent(EldenRing.class), container.getComponent(FromSoftware.class).getEldenRing());
    }
}
