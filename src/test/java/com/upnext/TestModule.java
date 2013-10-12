package com.upnext;

import dagger.Module;
import dagger.Provides;

/**
 * Created with IntelliJ IDEA.
 * User: przemek
 * Date: 10/12/13
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
@Module(library = true, complete = false, overrides = true, injects = { HelloAndroidActivityTest.class, HelloAndroidActivity.class}, includes = RootModule.class       )
public class TestModule {

    @Provides
    ExecutorInterface providesExecutorInterface(){
        return new TestExecutor();
    }
}
