package org.fpm.di.example;

import org.fpm.di.Container;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;

public class DummyContainer implements Container {
    DummyBinder binder;
    public DummyContainer(DummyBinder b){
        this.binder = b;
    }
    @Override
    public <T> T getComponent(Class<T> clazz) {
        HashMap<Class<?>, Class<?>> imp = binder.implementations;
        HashMap<Class<?>, Object> ins = binder.instances;
        if (imp.containsKey(clazz)) {
            return getComponent((Class<T>) imp.get(clazz));
        }
        if (ins.containsKey(clazz)) {
            return (T) ins.get(clazz);
        }
        try {
            for (Constructor<?> constructor : clazz.getConstructors()) {
                if (constructor.isAnnotationPresent(Inject.class)) {
                    Parameter[] p = constructor.getParameters();
                    int len = p.length;

                    Object[] init_p = new Object[len];
                    for (int i = 0; i < len; i++) {
                        init_p[i] = getComponent(p[i].getType());
                    }

                    T res = (T) constructor.newInstance(init_p);

                    if (clazz.isAnnotationPresent(Singleton.class)) {
                        binder.bind(clazz, res);
                    }
                    return res;
                }
            }
            T res = clazz.newInstance();
            if(clazz.isAnnotationPresent(Singleton.class)){
                binder.bind(clazz, res);
            }
            return res;

        }
        catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
        catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
