package com.dagger2.akshayfaye.dagger2demo;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {SharedPrefModule.class})
public interface MyComponent {
    void inject(MainActivity activity);
}
