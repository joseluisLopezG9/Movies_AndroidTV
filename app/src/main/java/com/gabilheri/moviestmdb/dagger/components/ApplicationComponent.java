package com.gabilheri.moviestmdb.dagger.components;


import com.gabilheri.moviestmdb.App;
import com.gabilheri.moviestmdb.dagger.AppScope;
import com.gabilheri.moviestmdb.dagger.modules.ApplicationModule;
import com.gabilheri.moviestmdb.dagger.modules.HttpClientModule;
import com.gabilheri.moviestmdb.ui.main.MainFragment;

import javax.inject.Singleton;

import dagger.Component;


@AppScope
@Singleton
@Component(modules = {
        ApplicationModule.class,
        HttpClientModule.class,
})
public interface ApplicationComponent {

    void inject(App app);
    void inject(MainFragment mainFragment);


}
