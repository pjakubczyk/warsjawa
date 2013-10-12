package com.upnext;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: przemek
 * Date: 10/12/13
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
@Module(injects = HelloAndroidActivity.class, library = true, complete = false)
public class ExecModule {


    @Singleton
    @Provides
    ExecutorInterface provideExecutorInterface() {
        return new ExecutorImpl();

    }
}
